package cn.com.dhc.rpmsystem.employefilter.service.impl;

import cn.com.dhc.rpmsystem.employefilter.controller.EmployeFilterController;
import cn.com.dhc.rpmsystem.employefilter.dao.EmployeFilterDao;
import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.employefilter.service.EmployeFilterService;
import cn.com.dhc.rpmsystem.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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
}
