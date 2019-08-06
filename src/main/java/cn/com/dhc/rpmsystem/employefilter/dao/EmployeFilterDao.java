package cn.com.dhc.rpmsystem.employefilter.dao;

import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.entity.Member;
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
}
