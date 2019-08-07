package cn.com.dhc.rpmsystem.employefilter.service;

import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.MenuEntity;
import cn.com.dhc.rpmsystem.entity.UserEntity;

import java.util.List;

/**
 * 雇员信息过滤服务层
 */
public interface EmployeFilterService
{
	/**
	 * 根据过滤条件获取雇员列表
	 * @param dto
	 * @return
	 */
	List<Member> getEmploysByFilter(EmployeFilterDto dto);
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userName
	 * @param password
	 * @return
	 */
	UserEntity getLoginUserInfo(String userName, String password);
	
	/**
	 * 根据角色获取功能信息列表
	 * @param role_ids
	 * @return
	 */
	List<MenuEntity> getUserMenuEntityList(String role_ids);
}
