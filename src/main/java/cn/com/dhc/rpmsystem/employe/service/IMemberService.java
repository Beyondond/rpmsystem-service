package cn.com.dhc.rpmsystem.employe.service;

import cn.com.dhc.rpmsystem.employe.dto.MemberDto;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.PageBean;
import cn.com.dhc.rpmsystem.entity.ReqPage;
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
     * @throws BusinessException
     */
    Integer saveMember(Member req) throws BusinessException;

    /**
     * 根据员工卡号删除员工
     * @param req
     * @return
     * @throws BusinessException
     */
    Integer delMember(Member req) throws BusinessException;

    /**
     * 编辑员工
     * @param req
     * @return
     * @throws BusinessException
     */
    Integer updateMember(Member req) throws BusinessException;

    /**
     * 员工分页(支持姓名检索 字段排序)查询
     * @param req
     * @return
     * @throws BusinessException
     */
    PageBean<Member> pageMemberList(MemberDto req) throws BusinessException;
}
