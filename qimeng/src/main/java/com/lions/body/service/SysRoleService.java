package com.lions.body.service;

import com.lions.body.entity.SysRole;
import com.lions.body.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:16
 */
@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }


    public SysRole selectByName(String name) {
        return roleMapper.selectByName(name);
    }
}
