package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.system.dto.MemberRole;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;

import java.util.List;

/**
 * @author kemeiyi
 * @description
 * @date 2019/8/7
 */
public interface AuthorityService {


    /**
     *新增权限
     * @param rpmMemberRole
     * @return
     */
    Integer addAuthority(RpmMemberRole rpmMemberRole);

    /**
     *删除权限
     * @param numUid
     * @return
     */
    Integer deleteAuthority(Integer numUid);

    /**
     *修改权限
     * @param rpmMemberRole
     * @return
     */
    Boolean updateAuthority(RpmMemberRole rpmMemberRole);

    /**
     * 查询单个权限（根据name名称查询）
     * @param memName
     * @return
     */

    MemberRole findOneAuthority(String memName);

    /**
     * 查询所有权限
     * @return
     */
    List<MemberRole> findAllAuthoritys();

}
