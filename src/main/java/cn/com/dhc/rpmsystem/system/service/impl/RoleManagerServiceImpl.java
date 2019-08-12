package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.employefilter.service.impl.EmployeFilterServiceImpl;
import cn.com.dhc.rpmsystem.exception.BusinessException;
import cn.com.dhc.rpmsystem.system.dao.RoleManagerDao;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.service.RoleManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kemeiyi
 * @description 角色配置管理
 * @date 2019/8/7
 */
@Service
public class RoleManagerServiceImpl implements RoleManagerService {

    // 日志记录器
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeFilterServiceImpl.class);

    @Resource
    private RoleManagerDao roleManagerDao;
    /**
     *增加一个角色
     * @param rpmRole
     * @return  Integer
     */
    @Override
    public int addRole(RpmRole rpmRole) throws BusinessException {
        Integer count = null;
        try {
            count = roleManagerDao.addRpmRole(rpmRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count != 0){
            LOGGER.debug("角色增加成功");
        }else{
            LOGGER.debug("角色增加失败");
        }
        return count;
    }
    /**
     *删除某个角色
     * @param id
     * @return  Integer
     */
    @Override
    public int deleteRoleByName(int id) throws BusinessException {
        Integer result = null;
        try {
            result = roleManagerDao.deleteRpmRole(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != 0){
            LOGGER.debug("角色删除成功");
        }else{
            LOGGER.debug("角色删除失败");
        }
        return result;
    }

    /**
     *更新某个角色
     * @param rpmRole
     * @return  Boolean
     */
    @Override
    public Boolean updateRpmRole(RpmRole rpmRole) throws BusinessException {
        Boolean flag = null;
        try {
            flag = roleManagerDao.updateRpmRole(rpmRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag != false){
            LOGGER.debug("角色更新成功");
        }else{
            LOGGER.debug("角色更新失败");
        }
        return flag;
    }
    /**
     *查询所有角色
     * @param
     * @return  rpmRoleList
     */
    @Override
    public List<RpmRole> findAllRole() throws BusinessException{
        List<RpmRole> rpmRoleList = null;
        try {
            rpmRoleList = roleManagerDao.findAllRpmRole();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!rpmRoleList.isEmpty()){
            LOGGER.debug("查询到角色");
        }else{
            LOGGER.debug("未查询到角色");
        }
        return rpmRoleList;
    }

    /**
     *查询某个角色
     * @param roleName
     * @return  RpmRole
     */
    @Override
    public RpmRole findRoleByName(String roleName) throws BusinessException{
        RpmRole rpmRole = null;
        try {
            rpmRole = roleManagerDao.findOneRpmRole(roleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rpmRole != null){
            LOGGER.debug("查询到角色");
        }else{
            LOGGER.debug("未查询到角色");
        }
        return rpmRole;
    }
}
