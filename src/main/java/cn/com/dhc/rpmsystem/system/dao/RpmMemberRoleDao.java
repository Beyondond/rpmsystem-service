package cn.com.dhc.rpmsystem.system.dao;

import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import org.springframework.stereotype.Repository;

@Repository
public interface RpmMemberRoleDao {

    /**
     * 获查询员工首页列展示
     * @param numUid
     * @return
     * @throws Exception
     */
    RpmMemberRole findMemberRole(int numUid) throws Exception;
}