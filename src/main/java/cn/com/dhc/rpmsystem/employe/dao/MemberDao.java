package cn.com.dhc.rpmsystem.employe.dao;

import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    /**
     * 根据条件查询总记录数
     * @param params
     * @return
     * @throws Exception
     */
    Integer selectMemberListTotal(@Param("params") Map<String, Object> params) throws Exception;

    /**
     * 根据条件查询当前页数据
     * @param params
     * @param order
     * @param currIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Member> selectMemberList(@Param("params") Map<String, Object> params, @Param("order") Order order, @Param("currIndex") Integer currIndex, @Param("pageSize") Integer pageSize) throws Exception;
}
