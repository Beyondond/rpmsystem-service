package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import cn.com.dhc.rpmsystem.common.ErrorCode;
import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.system.dao.RpmMemberRoleDao;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowDto;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import cn.com.dhc.rpmsystem.system.service.IMemberRoleService;
import cn.com.dhc.rpmsystem.utils.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author zss
 * @date 2019-08-08
 */
@Service
public class MemberRoleServiceImpl implements IMemberRoleService {

    private static final Logger logger = LoggerFactory.getLogger(MemberRoleServiceImpl.class);

    @Autowired
    private RpmMemberRoleDao rpmMemberRoleDao;

    /**
     * 获取员工首页列展示
     *
     * @param numUid
     * @return
     * @throws BusinessException
     */
    @Override
    public ColumnShowDto getMemberRole(int numUid) throws BusinessException {
        try {
            RpmMemberRole rpmMemberRole = rpmMemberRoleDao.findMemberRole(numUid);

            if (null == rpmMemberRole) {
                logger.info("数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            ColumnShowDto result = new ColumnShowDto();

            String cs = rpmMemberRole.getColumnShow();
            if (!StringUtils.isEmpty(cs)) {
                final String[] csArr = cs.split(",");
                List<String> columnShowList = new ArrayList<>(Arrays.asList(csArr));

                result.setColumnShow(columnShowList);
            }
            Map<Integer,String> columnAllMap = new HashMap<>();
            Arrays.asList(CommonConstant.ColumnShow.values()).stream().forEach( element -> {
                columnAllMap.put(element.getValue(), element.getDesc());
            });

            result.setColumnAll(columnAllMap);

            return result;
        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("查询员工首页列展示异常:{}", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(2, "查询用户id为" + numUid +"的员工首页列展示", true, numUid);
        }
    }
}
