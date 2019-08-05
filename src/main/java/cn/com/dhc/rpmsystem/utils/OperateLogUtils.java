package cn.com.dhc.rpmsystem.utils;

import cn.com.dhc.rpmsystem.common.dao.SystemDao;
import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作日志工具类
 * @author Sunli
 */
@Component
public class OperateLogUtils
{
	// 日志记录器
	private static Logger LOGGER = LoggerFactory.getLogger(OperateLogUtils.class);
	
	//设置日期格式
	private static SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private SystemDao systemDao;
	
	private static OperateLogUtils operateLogUtils;
	
	public OperateLogUtils()
	{
		operateLogUtils = this;
		operateLogUtils.systemDao = this.systemDao;
	}
	
	public static void writeOperateLog(Integer skill, String content, Integer result, Integer uid)
	{
		OperateLogEntity entity = new OperateLogEntity();
		
		entity.setSkill(skill);
		entity.setOperate_content(content);
		entity.setOperate_result(result);
		entity.setOperate_num_uid(uid);
		entity.setOperate_time(DF.format(new Date()));
		
		operateLogUtils.systemDao.insertOperateLog2DB(entity);
	}
}
