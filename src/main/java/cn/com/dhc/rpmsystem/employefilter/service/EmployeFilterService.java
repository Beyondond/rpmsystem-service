package cn.com.dhc.rpmsystem.employefilter.service;

import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.entity.Member;

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
}
