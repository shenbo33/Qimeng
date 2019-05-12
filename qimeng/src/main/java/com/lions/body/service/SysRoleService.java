package com.lions.body.service;

import com.lions.body.entity.SysPermission;
import com.lions.body.mapper.SysRoleMapper;
import com.lions.body.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:16
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }


    public SysRole selectByName(String name) {
        return roleMapper.selectByName(name);
    }
}
