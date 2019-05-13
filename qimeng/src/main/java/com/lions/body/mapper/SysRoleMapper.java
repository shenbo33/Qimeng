package com.lions.body.mapper;

import com.lions.body.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:11
 */
@Mapper
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);

    @Select("SELECT * FROM sys_role WHERE name = #{name}")
    SysRole selectByName(String name);
}
