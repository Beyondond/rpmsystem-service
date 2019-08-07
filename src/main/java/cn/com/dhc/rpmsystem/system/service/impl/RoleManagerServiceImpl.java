package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.employefilter.service.impl.EmployeFilterServiceImpl;
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
    public int addRole(RpmRole rpmRole) {
        Integer count =  roleManagerDao.addRpmRole(rpmRole);
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
    public int deleteRoleByName(int id) {
        Integer result = roleManagerDao.deleteRpmRole(id);
        if (result != 0){
            LOGGER.debug("角色删除成功");
        }else{
            LOGGER.debug("角色删除失败");
        }
        return result;
    }

    /**
     *更新某个角色
     * @param id
     * @return  Boolean
     */
    @Override
    public Boolean updateRpmRole(int id) {
        Boolean flag = roleManagerDao.updateRpmRole(id);
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
    public List<RpmRole> findAllRole() {
        List<RpmRole> rpmRoleList = roleManagerDao.findAllRpmRole();
        if (!rpmRoleList.isEmpty()){
            LOGGER.debug("查询到角色");
        }else{
            LOGGER.debug("未查询到角色");
        }
        return rpmRoleList;
    }

    /**
     *查询某个角色
     * @param name
     * @return  RpmRole
     */
    @Override
    public RpmRole findRoleByName(String name) {
        RpmRole rpmRole = roleManagerDao.findOneRpmRole(name);
        if (rpmRole != null){
            LOGGER.debug("查询到角色");
        }else{
            LOGGER.debug("未查询到角色");
        }
        return rpmRole;
    }
}
