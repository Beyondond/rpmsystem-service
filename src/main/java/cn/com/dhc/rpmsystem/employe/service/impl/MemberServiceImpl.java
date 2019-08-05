package cn.com.dhc.rpmsystem.employe.service.impl;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import cn.com.dhc.rpmsystem.employe.dao.MemberDao;
import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.exception.BusinessException;
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

    @Override
    public Member get(int numUid) throws BusinessException {
        try {
            Map<String, Object> params = new HashMap<>(2);
            params.put("numUid", numUid);
            params.put("status", CommonConstant.DataStatus.EXIST.getValue());

            return memberDao.findMember(params);

        } catch (Exception e) {
            logger.error("查询人员详情错误！");
            throw new BusinessException("500", "系统异常");
        }

    }
}
