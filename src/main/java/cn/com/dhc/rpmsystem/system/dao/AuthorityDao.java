package cn.com.dhc.rpmsystem.system.dao;

import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kemeiyi
 * @description
 * @date 2019/8/7
 */
@Repository
@Mapper
public interface AuthorityDao {

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
     * 查询单个权限（根据name名称查询）
     * @param id
     * @return
     */

    RpmSkillInfo findOneSkillInfo(int id);


    /**
     * 查询所有权限
     * @return
     */
    List<RpmSkillInfo> findAllSkillInfo();

}
