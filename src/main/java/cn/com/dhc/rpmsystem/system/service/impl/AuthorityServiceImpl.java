package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.employefilter.service.impl.EmployeFilterServiceImpl;
import cn.com.dhc.rpmsystem.system.dao.AuthorityDao;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;
import cn.com.dhc.rpmsystem.system.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouyongzhou
 * @description
 * @date 2019/8/5
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{

    // 日志记录器
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeFilterServiceImpl.class);


    @Autowired
    private AuthorityDao authorityDao;

    /**
     *增加权限
     * @param rpmSkillInfo
     * @return  Integer
     */
    @Override
    public Integer addSkillInfo(RpmSkillInfo rpmSkillInfo) {

        Integer count = authorityDao.addSkillInfo(rpmSkillInfo);

        if (count != 0){
            LOGGER.debug("权限增加成功");
        }else{
            LOGGER.debug("权限增加失败");
        }
        return count;
    }
    /**
     *删除某个权限
     * @param id
     * @return  Integer
     */
    @Override
    public Integer deleteSkillInfo(int id) {

        Integer result = authorityDao.deleteSkillInfo(id);
        if (result != 0){
            LOGGER.debug("权限删除成功");
        }else{
            LOGGER.debug("权限删除失败");
        }
        return result;
    }
    /**
     *更新某个权限
     * @param id
     * @return  Boolean
     */
    @Override
    public Boolean updateSkillInfo(int id) {

        Boolean flag = authorityDao.updateSkillInfo(id);
        if (flag != false){
            LOGGER.debug("权限更新成功");
        }else{
            LOGGER.debug("权限更新失败");
        }
        return flag;
    }

    /**
     *查询某个权限
     * @param name
     * @return  RpmSkillInfo
     */
    @Override
    public RpmSkillInfo findOneSkillInfo(String name) {

        RpmSkillInfo rpmSkillInfo= authorityDao.findOneSkillInfo(name);
        if (rpmSkillInfo != null){
            LOGGER.debug("查询到权限");
        }else{
            LOGGER.debug("未查询到权限");
        }
        return rpmSkillInfo;
    }
    /**
     *查询所有权限
     * @param
     * @return  rpmRoleList
     */
    @Override
    public List<RpmSkillInfo> findAllSkillInfo() {
        List<RpmSkillInfo> rpmSkillInfoList = authorityDao.findAllSkillInfo();
        if (!rpmSkillInfoList.isEmpty()){
            LOGGER.debug("查询到权限");
        }else{
            LOGGER.debug("未查询到权限");
        }
        return rpmSkillInfoList;
    }
}
