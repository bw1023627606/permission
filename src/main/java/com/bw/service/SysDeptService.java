package com.bw.service;

import com.bw.dao.SysDeptMapper;
import com.bw.exception.ParamException;
import com.bw.model.SysDept;
import com.bw.param.DeptParam;
import com.bw.util.BeanValidator;
import com.bw.util.LevelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @auther bai
 * @data 2019/5/24 - 16:56
 * @description
 */
@Service
public class SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    public void save(DeptParam param){
        BeanValidator.check(param);
        if(checkExits(param.getParentId(),param.getName(),param.getId())){
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(param.getName()).parentId(param.getParentId()).seq(param.getSeq()).remark(param.getRemark()).build();
        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        dept.setOperator("system");//TODO
        dept.setOperateIp("127.0.0.7");//TODO
        dept.setOperateTime(new Date());
        sysDeptMapper.insertSelective(dept);
    }

    private boolean checkExits(Integer parentId,String deptName,Integer deptId){
        //TODO
        return true;
    }

    private String getLevel(Integer deptId){
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if(dept==null){
            return null;
        }
        return dept.getLevel();
    };


}
