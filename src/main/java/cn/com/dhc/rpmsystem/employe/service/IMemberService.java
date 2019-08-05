package cn.com.dhc.rpmsystem.employe.service;

import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.exception.BusinessException;

/**
 * @author zss
 * @date 2019-08-05
 */
public interface IMemberService {
    Member get(int numUid) throws BusinessException;
}
