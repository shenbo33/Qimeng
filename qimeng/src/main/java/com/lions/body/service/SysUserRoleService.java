package com.lions.body.service;

import com.lions.body.mapper.SysUserRoleMapper;
import com.lions.body.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:17
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
