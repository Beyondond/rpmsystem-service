package cn.com.dhc.rpmsystem.employefilter.controller;

import cn.com.dhc.rpmsystem.employefilter.service.EmployeFilterService;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.utils.OperateLogUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 雇员过滤控制层
 */
@RestController
@RequestMapping("/EmployeFilter")
public class EmployeFilterController
{
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeFilterController.class);
	
	@Autowired
	private EmployeFilterService employeFilterService;
	
	/**
	 * 测试接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/getEmployes", method = RequestMethod.GET)
	public String getEmployes(HttpServletRequest request)
	{
		Integer num = employeFilterService.getTestNum();
		
		ResultEntity result = new ResultEntity(1000, "Test Interface", num);
		
		LOGGER.info("getEmployes 请求参数：" + request.getParameter("uid"));
		
		OperateLogUtils.writeOperateLog(12, "工具类测试", 1, 1441);
		
		return JSON.toJSONString(result);
	}
}
