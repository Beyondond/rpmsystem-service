package cn.com.dhc.rpmsystem.employefilter.dao;

import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.MenuEntity;
import cn.com.dhc.rpmsystem.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 雇员过滤数据持久层
 */
@Repository
public interface EmployeFilterDao
{
	/**
	 * 根据检索信息获取已入项/未入项信息
	 * @param employeFilterDto
	 * @return
	 */
	List<Member> getEmploysByFilter(EmployeFilterDto employeFilterDto);
	
	/**
	 * 根据角色获取所有的技能列表
	 * @param roleList
	 * @return
	 */
	List<String> getSkillsListByRoles(List<String> roleList);
	
	/**
	 * 根据用户名和密码获取人员信息
	 * @param userName
	 * @param password
	 * @return
	 */
	UserEntity getLoginUserInfo(@Param("userName") String userName,@Param("password") String password);
	
	/**
	 * 根据技能Id获取所有的Menu列表
	 * @param skillsList
	 * @return
	 */
	List<MenuEntity> getMenuEntityList(List<String> skillsList);
}
