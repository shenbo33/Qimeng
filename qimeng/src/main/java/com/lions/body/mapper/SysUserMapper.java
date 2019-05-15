package com.lions.body.mapper;

import com.lions.body.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:10
 */
@Mapper
public interface SysUserMapper {

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);

    @Select("SELECT * FROM sys_user WHERE mobile = #{mobile}")
    SysUser selectByMobile(String mobile);
}
