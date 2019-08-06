package cn.com.dhc.rpmsystem.employe.service.impl;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import cn.com.dhc.rpmsystem.common.ErrorCode;
import cn.com.dhc.rpmsystem.employe.dao.MemberDao;
import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.utils.OperateLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zss
 * @date 2019-08-05
 */
@Service
public class MemberServiceImpl implements IMemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberDao memberDao;


    /**
     * 根据员工卡号查询员工详情
     * @param numUid
     * @return
     * @throws BusinessException
     */
    @Override
    public Member getMember(int numUid) throws BusinessException {
        try {
            Map<String, Object> params = new HashMap<>(2);
            params.put("numUid", numUid);
            params.put("status", CommonConstant.DataStatus.EXIST.getValue());

            Member member = memberDao.findMember(params);
            if (null == member) {
                logger.warn("人员数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            return member;

        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("查询人员详情错误！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            OperateLogUtils.writeOperateLog(2, "查询用户id为" + numUid +"的用户详情", true, numUid);
        }

    }

    /**
     * 添加员工
     *
     * @param req
     * @return
     */
    @Override
    public Integer saveMember(Member req) {
        try {

            memberDao.insertSelective(req);

            return req.getNumUid();

        } catch (Exception e) {
            logger.error("添加员工系统异常！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            OperateLogUtils.writeOperateLog(5, "添加用户", true, req.getNumUid());
        }

    }
}
