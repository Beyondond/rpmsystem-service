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

    /**
     * 根据员工卡号获取详情
     * @param params
     * @return
     * @throws Exception
     */
    Member findMember(@Param("params") Map<String, Object> params) throws Exception;

    /**
     * 新增员工
     * @param req
     * @return
     */
    void insertSelective(Member req) throws Exception;

    /**
     * 根据员工卡号删除员工
     * @param req
     * @throws Exception
     */
    void updateMemberByKey(Member req) throws Exception;
}
