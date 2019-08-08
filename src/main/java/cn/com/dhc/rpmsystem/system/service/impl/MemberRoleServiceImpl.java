package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import cn.com.dhc.rpmsystem.common.ErrorCode;
import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.system.dao.RpmMemberRoleDao;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowDto;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowSetUpDto;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import cn.com.dhc.rpmsystem.system.service.IMemberRoleService;
import cn.com.dhc.rpmsystem.utils.SystemUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


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
                List<Integer> csIds = Arrays.asList(csArr).stream().map(a -> Integer.valueOf(a)).collect(Collectors.toList());

                result.setColumnShow(csIds);
            }

            List<ColumnShowDto.Inside> columnAll = new ArrayList<>();
            Arrays.asList(CommonConstant.ColumnShow.values()).stream().forEach( element -> {
                ColumnShowDto.Inside inside = new ColumnShowDto().new Inside();
                inside.setId(element.getValue());
                inside.setName(element.getDesc());
                columnAll.add(inside);
            });

            result.setColumnAll(columnAll);

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

    /**
     * 设置员工首页列展示
     *
     * @param req
     * @throws BusinessException
     */
    @Override
    public void setMemberRole(ColumnShowSetUpDto req) throws BusinessException {
        try {

            RpmMemberRole rpmMemberRole = rpmMemberRoleDao.findMemberRole(req.getNumUid());

            if (null == rpmMemberRole) {
                logger.info("数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            StringBuilder sb = new StringBuilder();
            req.getColumnShow().stream().forEach( element -> sb.append(element).append(","));
            String cs = sb.deleteCharAt(sb.length() - 1).toString();
            logger.info("存入员工展示列的标识columnShow：{}", JSON.toJSON(sb));

            RpmMemberRole rpmMemberRole1 = new RpmMemberRole();
            rpmMemberRole1.setNumUid(req.getNumUid());
            rpmMemberRole1.setColumnShow(cs);

            rpmMemberRoleDao.updateRpmMemberRole(rpmMemberRole1);

        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("设置员工首页列展示异常:{}", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(2, "设置用户id为" + req.getNumUid() +"的员工首页列展示", true, req.getNumUid());
        }
    }
}
