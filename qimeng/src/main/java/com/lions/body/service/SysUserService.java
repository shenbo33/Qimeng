package com.lions.body.service;

import com.lions.body.mapper.SysUserMapper;
import com.lions.body.entity.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:13
 */
@Service
public class SysUserService {

    @Resource
    private SysUserMapper userMapper;

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public SysUser selectByMobile(String mobile) {
        return userMapper.selectByMobile(mobile);
    }
}
