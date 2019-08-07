package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.system.entity.RpmRole;

import java.util.List;

/**
 * @author zhouyongzhou
 * @description 角色配置管理
 * @date 2019/8/6
 */
public interface RoleManagerService {

    /**
     * 增加角色
     * @param rpmRole
     * @return
     */
    int addRole(RpmRole rpmRole);


    /**
     * 根据角色名称删除
     * @param name
     * @return
     */
    int deleteRoleByName(String name);

    /**
     * 查询所有的角色
     * @return
     */
    List<RpmRole> findAllRole();

    /**
     * 根据角色名称查询
     * @param name
     * @return
     */
    List<RpmRole> findRoleByName(String name);


}
