package cn.com.dhc.rpmsystem.employe.service.impl;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import cn.com.dhc.rpmsystem.common.ErrorCode;
import cn.com.dhc.rpmsystem.employe.dao.MemberDao;
import cn.com.dhc.rpmsystem.employe.dto.MemberDto;
import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.Order;
import cn.com.dhc.rpmsystem.entity.PageBean;
import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.system.dao.RpmMemberRoleDao;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import cn.com.dhc.rpmsystem.utils.DateUtils;
import cn.com.dhc.rpmsystem.utils.SystemUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zss
 * @date 2019-08-05
 */
@Service
@Transactional
public class MemberServiceImpl implements IMemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);


    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RpmMemberRoleDao rpmMemberRoleDao;

    /**
     * 根据员工卡号查询员工详情
     * @param numUid
     * @return
     * @throws BusinessException
     */
    @Override
    public Member getMember(int numUid) throws BusinessException {
        try {

            Member member = this.commonFindMember(numUid);

            if (null == member) {
                logger.info("人员数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            return member;

        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("查询人员详情异常:{}", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(2, "查询用户id为" + numUid +"的用户详情", true, numUid);
        }

    }

    /**
     * 添加员工
     *
     * @param req
     * @return
     * @throws BusinessException
     */
    @Override
    public Integer saveMember(Member req) throws BusinessException {
        try {

            req.setStatus(CommonConstant.DataStatus.EXIST.getValue());
            req.setCreatedTime(DateUtils.getTimestamp());
            memberDao.insertSelective(req);

            return req.getNumUid();

        } catch (Exception e) {
            logger.error("添加员工系统异常！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(5, "添加用户", true, req.getNumUid());
        }

    }

    /**
     * 根据员工卡号删除员工
     *
     * @param req
     * @return
     * @throws BusinessException
     */
    @Override
    public Integer delMember(Member req) throws BusinessException{
        try {

            Member member = this.commonFindMember(req.getNumUid());
            if (null == member) {
                logger.info("人员数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            req.setStatus(CommonConstant.DataStatus.DELETE.getValue());
            req.setDeleteTime(DateUtils.getTimestamp());
            memberDao.updateMemberByKey(req);

            return req.getNumUid();
        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("删除员工系统异常！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(5, "删除用户", true, req.getNumUid());
        }
    }

    /**
     * 编辑员工
     *
     * @param req
     * @return
     * @throws BusinessException
     */
    @Override
    public Integer updateMember(Member req) throws BusinessException {
        try {

            Member member = this.commonFindMember(req.getNumUid());
            if (null == member) {
                logger.info("人员数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            req.setStatus(CommonConstant.DataStatus.EXIST.getValue());
            memberDao.updateMemberByKey(req);

            return req.getNumUid();
        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("编辑员工系统异常！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(5, "编辑用户", true, req.getNumUid());
        }
    }

    /**
     * 员工分页(支持姓名检索 字段排序)查询
     *
     * @param req
     * @return
     * @throws BusinessException
     */
    @Override
    public PageBean<Member> pageMemberList(MemberDto req) throws BusinessException {
        try {

            Map<String, Object> params = new HashMap<>(2);
            params.put("status", CommonConstant.DataStatus.EXIST.getValue());
            params.put("searchName", req.getSearchName());

            //查询总条数
            Integer total = memberDao.selectMemberListTotal(params);
            logger.debug("根据条件查询总记录数total:{}", total);

            Integer currIndex = req.getCurrPage() <=1 ? 0 : (req.getCurrPage() - 1) * req.getPageSize();
            Integer pageSize = req.getPageSize();

            Order order;
            if (null == req.getOrder()) {
                order = new Order("num_uid");
            } else {
                order = req.getOrder();
            }

            //查询当前页数据
            List<Member> list = memberDao.selectMemberList(params, order, currIndex, pageSize);
            logger.info("员工列表查询list:{}", JSON.toJSONString(list));

            PageBean<Member> result = new PageBean<>();
            result.setTotalCount(total);
            result.setLimit(pageSize);
            result.setList(list);

            return result;
        } catch (Exception e) {
            logger.error("员工列表查询系统异常！", e);
            throw new BusinessException(ErrorCode.ERROR);
        } finally {
            SystemUtils.writeOperateLog(5, "用户列表查询", true, 0);
        }
    }

    /**
     * 员工首页列表展示列
     *
     * @param req
     * @return
     * @throws BusinessException
     */
    @Override
    public Map<String, Integer> getMemberColumnShow(Member req) throws BusinessException {
        try {

            RpmMemberRole memberRole = rpmMemberRoleDao.findMemberRole(req.getNumUid());

            if (null == memberRole) {
                logger.info("数据不存在");
                throw new BusinessException(ErrorCode.DATA_NOT_EXISTS);
            }

            final List<Integer> list = Arrays.asList(memberRole.getColumnShow().split(",")).stream().map(a -> Integer.valueOf(a)).collect(Collectors.toList());

            Map<String, Integer> result = new HashMap<>();

            Arrays.asList(CommonConstant.ColumnShow.values()).stream().forEach( element -> {
               Integer value = list.contains(element.getValue()) ? CommonConstant.SHOW : CommonConstant.NOT_SHOW;
               result.put(element.name(), value);
            });

            return result;
        } catch (BusinessException e) {
            logger.error("BusinessException异常:{}", e);
            throw new BusinessException(e.getErrorCode(), e.getBusinessMsg());
        } catch (Exception e) {
            logger.error("查询人员详情异常:{}", e);
            throw new BusinessException(ErrorCode.ERROR);
        }
    }

    /**
     * 封装公共根据员工卡号查询员工方法
     * @param numUid
     * @return
     * @throws Exception
     */
    private Member commonFindMember(Integer numUid) throws Exception {
        Map<String, Object> params = new HashMap<>(2);
        params.put("numUid", numUid);
        params.put("status", CommonConstant.DataStatus.EXIST.getValue());

        return memberDao.findMember(params);
    }

}
