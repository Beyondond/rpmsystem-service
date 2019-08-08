package cn.com.dhc.rpmsystem.employefilter.controller;

import cn.com.dhc.rpmsystem.common.Constants;
import cn.com.dhc.rpmsystem.employefilter.dto.EmployeFilterDto;
import cn.com.dhc.rpmsystem.employefilter.service.EmployeFilterService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.MenuEntity;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.entity.UserEntity;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 雇员过滤控制层
 */
@RestController
@RequestMapping(value = "/EmployeFilter", produces="application/json; charset=utf-8")
public class EmployeFilterController
{
	// 日志记录器
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeFilterController.class);
	
	// 默认头像路径
	private static final String defaultIconPath = "E:/test.PNG";
	
	@Autowired
	private EmployeFilterService employeFilterService;
	
	/**
	 * 获取已入项或非入项人员列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/getEmployes", method = RequestMethod.GET)
	public String getEmployes(HttpServletRequest request)
	{
		LOGGER.info("Controller getEmployes Start!");
		
		// 返回对象
		ResultEntity result = null;
		
		// 检索类型 0：已入项 1：未入项
		Integer searchType = Integer.parseInt(StringUtils.isEmpty(request.getParameter("searchType")) ? "0" : request.getParameter("searchType"));
		
		// 过滤内容
		String searchValue = request.getParameter("searchValue");
		
		// 过滤种类
		Integer searchKind = Integer.parseInt(StringUtils.isEmpty(request.getParameter("searchKind")) ? "0" : request.getParameter("searchKind"));
		
		// 过滤信息收集
		EmployeFilterDto searchDto = buildEmployeFilterDto(searchKind, searchValue, searchType);
		
		try
		{
			List<Member> resultList = employeFilterService.getEmploysByFilter(searchDto);
			
			result = new ResultEntity(Constants.SUCCESS, StringUtils.EMPTY, resultList);
		}
		catch (Exception e)
		{
			LOGGER.error("Controller getEmployes has Exception:", e);
			
			result = new ResultEntity(Constants.FAILURE, e.getMessage(), new ArrayList<Member>());
		}
		
		LOGGER.info("Controller getEmployes End!");
		return JSON.toJSONString(result);
	}
	
	/**
	 * 组装雇员信息过滤检索对象
	 * @param searchKind
	 * @param searchValue
	 * @param searchType
	 * @return
	 */
	private EmployeFilterDto buildEmployeFilterDto(Integer searchKind, String searchValue, Integer searchType)
	{
		EmployeFilterDto resultDto = new EmployeFilterDto();
		
		resultDto.setSearchType(searchType);
		
		switch (searchKind)
		{
			case 0:
				resultDto.setSearchName(searchValue);
				break;
			case 1:
				resultDto.setSearchUid(searchValue);
				break;
			case 2:
				resultDto.setSearchPosition(searchValue);
				break;
			default:
				LOGGER.info("buildEmployeFilterDto the searchKind is correct, searchKind is:" + searchKind);
				break;
		}
		
		return resultDto;
	}
	
	/**
	 * 获取雇员头像信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getEmployeIconByPath", method = RequestMethod.GET)
	public String getEmployeIconByPath(HttpServletRequest request, HttpServletResponse response)
	{
		
		FileInputStream fileStream = null;
		
		// 定义输出流
		OutputStream out = null;
		
		String filePath = request.getParameter("filePath");
		
		File file = null;
		
		try
		{
			file = new File(filePath);
			
			if (!file.exists())
			{
				file = new File(defaultIconPath);
			}
		}
		catch (Exception e)
		{
			file = new File(defaultIconPath);
		}
		
		try
		{
			fileStream = new FileInputStream(file);
			
			out = response.getOutputStream();
			
			byte[] bs = new byte[2048];
			
			// 将图片流写入返回对象中
			while (fileStream.read(bs) != -1)
			{
				out.write(bs);
			}
			
			out.flush();
			out.close();
			out = null;
		}
		catch (Exception e)
		{
			LOGGER.error("getEmployeIconByPath has Exception:", e);
		}
		finally
		{
			if (null != fileStream)
			{
				try
				{
					// 关闭文件流
					fileStream.close();
				}
				catch (IOException e)
				{
					LOGGER.error("getEmployeIconByPath close fileStream has Exception:", e);
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 用户登陆系统
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request)
	{
		LOGGER.info("Controller login Start!");
		
		// 返回对象
		ResultEntity result = null;
		
		String userName = request.getParameter("userName");
		
		String password = request.getParameter("password");
		
		UserEntity userEntity = employeFilterService.getLoginUserInfo(userName, password);
		
		if (null == userEntity)
		{
			// 如果通过用户名和密码获取到的用户信息为空，则说明用户名或密码错误
			result = new ResultEntity(Constants.FAILURE, "Username or password is incorrect!");
		}
		else
		{
			// 获取该用户的所有menu列表
			List<MenuEntity> menuResource = employeFilterService.getUserMenuEntityList(userEntity.getRoleIds());
			
			// 设置该用户的所有menu资源信息
			userEntity.setMenuResource(menuResource);
			
			result = new ResultEntity(Constants.SUCCESS, StringUtils.EMPTY, userEntity);
		}
		
		LOGGER.info("Controller login End!");
		return JSON.toJSONString(result);
	}
}
