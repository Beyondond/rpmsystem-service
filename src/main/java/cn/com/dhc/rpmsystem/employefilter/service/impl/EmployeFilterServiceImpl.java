package cn.com.dhc.rpmsystem.employefilter.service.impl;

import cn.com.dhc.rpmsystem.employefilter.dao.EmployeFilterDao;
import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.employefilter.service.EmployeFilterService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.MenuEntity;
import cn.com.dhc.rpmsystem.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 雇员信息过滤服务层实现类
 */
@Service
public class EmployeFilterServiceImpl implements EmployeFilterService
{
	// 日志记录器
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeFilterServiceImpl.class);
	
	@Resource
	EmployeFilterDao employeFilterDao;
	
	/**
	 * 根据过滤条件获取雇员列表
	 * @param dto
	 * @return
	 */
	@Override
	public List<Member> getEmploysByFilter(EmployeFilterDto dto)
	{
		LOGGER.info("Service getEmploysByFilter Start!");
		
		List<Member> resultList = employeFilterDao.getEmploysByFilter(dto);
		
		// 后续应该会对对象进行操作，因此留此代码
		if (CollectionUtils.isEmpty(resultList))
		{
			LOGGER.info("Service getEmploysByFilter, the resultList is empty!");
		}
		
		LOGGER.info("Service getEmploysByFilter End!");
		return resultList;
	}
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userName
	 * @param password
	 * @return
	 */
	@Override
	public UserEntity getLoginUserInfo(String userName, String password)
	{
		return employeFilterDao.getLoginUserInfo(userName, password);
	}
	
	/**
	 * 根据角色获取功能信息列表
	 * @param role_ids
	 * @return
	 */
	@Override
	public List<MenuEntity> getUserMenuEntityList(String role_ids)
	{
		// 将所有角色分隔为
		List<String> roleList = Arrays.asList(role_ids.split(","));
		
		// 如果角色列表为空，则说明没有技能，则直接返回
		if (CollectionUtils.isEmpty(roleList))
		{
			return null;
		}
		
		// 根据角色列表获取所有的技能列表
		List<String> strSkillList = employeFilterDao.getSkillsListByRoles(roleList);
		
		List<String> skillsList = new ArrayList<String>();
		
		for (String strSkill : strSkillList)
		{
			String[] skills = strSkill.split(",");
			
			for (String skill : skills)
			{
				if (!skillsList.contains(skill))
				{
					skillsList.add(skill);
				}
			}
		}
		
		// 如果技能列表为空，则直接返回空
		if (CollectionUtils.isEmpty(skillsList))
		{
			return null;
		}
		
		return employeFilterDao.getMenuEntityList(skillsList);
	}
}
