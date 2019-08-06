package cn.com.dhc.rpmsystem.utils;

import cn.com.dhc.rpmsystem.common.dao.SystemDao;
import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作日志工具类
 * @author Sunli
 */
@Component
public class SystemUtils
{
	//设置日期格式
	private static SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private SystemDao systemDao;
	
	private static SystemUtils systemUtils;
	
	/**
	 * 构造方法
	 */
	public SystemUtils()
	{
		systemUtils = this;
		systemUtils.systemDao = this.systemDao;
	}
	
	/**
	 * 记录操作日志
	 * @param skill
	 * @param content
	 * @param result
	 * @param uid
	 */
	public static void writeOperateLog(Integer skill, String content, boolean result, Integer uid)
	{
		// 操作日志实体对象
		OperateLogEntity entity = new OperateLogEntity();
		
		entity.setSkill(skill);											// 技能Id
		entity.setOperate_content(content);								// 操作内容
		entity.setOperate_result(true == result ? 1 : 0);				// 操作结果
		entity.setOperate_num_uid(uid);									// 操作人Id
		entity.setOperate_time(DF.format(new Date()));					// 操作时间
		
		// 将操作日志写入数据库中
		systemUtils.systemDao.insertOperateLog2DB(entity);
	}
}
