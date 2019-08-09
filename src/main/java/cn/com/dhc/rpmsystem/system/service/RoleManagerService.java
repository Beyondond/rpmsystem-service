package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.system.entity.RpmRole;

import java.util.List;

/**
 * @author kemeiyi
 * @description 角色配置管理
 * @date 2019/8/7
 */
public interface RoleManagerService {

    /**
     * 增加角色
     * @param rpmRole
     * @return
     */
    int addRole(RpmRole rpmRole);


    /**
     * 根据角色工号删除
     * @param id
     * @return
     */
    int deleteRoleByName(int id);


    /**
     *修改角色
     * @param rpmRole
     * @return
     */
    Boolean updateRpmRole(RpmRole rpmRole);


    /**
     * 查询所有的角色
     * @return
     */
    List<RpmRole> findAllRole();

    /**
     * 根据角色名称查询
     * @param roleName
     * @return
     */
    RpmRole findRoleByName(String roleName);
}
