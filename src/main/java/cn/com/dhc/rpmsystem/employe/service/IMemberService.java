package cn.com.dhc.rpmsystem.employe.service;

import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.exception.BusinessException;

/**
 * @author zss
 * @date 2019-08-05
 */
public interface IMemberService {

    /**
     * 根据员工卡号查询员工详情
     * @param numUid
     * @return
     * @throws BusinessException
     */
    Member getMember(int numUid) throws BusinessException;

    /**
     * 添加员工
     * @param req
     * @return
     */
    Integer saveMember(Member req);

    /**
     * 根据员工卡号删除员工
     * @param req
     * @return
     */
    Integer delMember(Member req);
}
