package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowDto;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowSetUpDto;


/**
 * @author zss
 * @date 2019-08-08
 */
public interface IMemberRoleService {

    /**
     * 获取员工首页列展示
     * @param numUid
     * @return
     * @throws BusinessException
     */
    ColumnShowDto getMemberRole(int numUid) throws BusinessException;

    /**
     * 设置员工首页设置列展示
     * @param req
     * @throws BusinessException
     */
    void setMemberRole(ColumnShowSetUpDto req) throws BusinessException;
}
