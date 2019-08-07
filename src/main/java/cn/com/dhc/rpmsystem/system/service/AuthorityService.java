package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;

import java.util.List;

/**
 * @author kemeiyi
 * @description
 * @date 2019/8/7
 */
public interface AuthorityService {

    /**
     * 增加权限
     * @param rpmSkillInfo
     * @return
     */
    Integer addSkillInfo(RpmSkillInfo rpmSkillInfo);


    /**
     *删除权限
     * @param id
     * @return
     */
    Integer deleteSkillInfo(int id);


    /**
     *修改权限
     * @param id
     * @return
     */
    Boolean updateSkillInfo(int id);

    /**
     * 查询单个权限（根据id名称查询）
     * @param name
     * @return
     */

    RpmSkillInfo findOneSkillInfo(String name);


    /**
     * 查询所有权限
     * @return
     */
    List<RpmSkillInfo> findAllSkillInfo();

}
