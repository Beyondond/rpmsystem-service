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
     *删除权限
     * @param id
     * @return
     */
    Integer deleteSkillInfo(int id);

    /**
     *修改权限
     * @param memberRole
     * @return
     */
    Boolean updateSkillInfo(MemberRole memberRole);

    /**
     * 查询单个权限（根据id名称查询）
     * @param memName
     * @return
     */

    MemberRole findOneSkillInfo(String memName);

    /**
     * 查询所有权限
     * @return
     */
    List<MemberRole> findAllSkillInfo();

}
