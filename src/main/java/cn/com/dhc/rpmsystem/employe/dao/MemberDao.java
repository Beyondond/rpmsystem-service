package cn.com.dhc.rpmsystem.employe.dao;

import cn.com.dhc.rpmsystem.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author zss
 * @date 2019-08-05
 */
@Repository
public interface MemberDao {
    Member findMember(@Param("params") Map<String, Object> params) throws Exception;
}
