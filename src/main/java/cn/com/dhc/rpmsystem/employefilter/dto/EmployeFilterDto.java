package cn.com.dhc.rpmsystem.employefilter.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description 雇员信息过滤检索对象
 * @Date 2019/8/6 10:41
 * @Created by Sunli
 */
@Getter
@Setter
public class EmployeFilterDto
{
	// 检索姓名
	private String searchName = StringUtils.EMPTY;
	
	// 检索工号
	private String searchUid = StringUtils.EMPTY;
	
	// 职位
	private String searchPosition = StringUtils.EMPTY;
	
	// 搜索类型 0:已入项 1:未入项
	private Integer searchType = 0;
}
