package cn.com.dhc.rpmsystem.employefilter.service.impl;

import cn.com.dhc.rpmsystem.employefilter.dao.EmployeFilterDao;
import cn.com.dhc.rpmsystem.employefilter.service.EmployeFilterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class EmployeFilterServiceImpl implements EmployeFilterService
{
	@Resource
	EmployeFilterDao employeFilterDao;
	
	@Override
	public Integer getTestNum()
	{
		return employeFilterDao.getTestNum();
	}
}
