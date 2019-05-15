package com.lions.body.security.sms;


import com.lions.body.entity.SysRole;
import com.lions.body.entity.SysUser;
import com.lions.body.entity.SysUserRole;
import com.lions.body.service.SysRoleService;
import com.lions.body.service.SysUserRoleService;
import com.lions.body.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("smsDetailsService")
public class CustomSmsDetailsService implements UserDetailsService {
    private final SysUserService userService;

    private final SysRoleService roleService;

    private final SysUserRoleService userRoleService;

    @Autowired
    public CustomSmsDetailsService(SysUserService userService, SysRoleService roleService, SysUserRoleService userRoleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.selectByMobile(mobile);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("电话号码不存在");
        }

        // 添加权限
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new User(user.getName(), user.getPassword(), authorities);
    }
}


