package cn.com.dhc.rpmsystem.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 操作日志实体对象
 * @author Sunli
 */
@Setter
@Getter
public class OperateLogEntity
{
	// 日志Id
	private Integer id;
	
	// 操作对象技能
	private Integer skill;
	
	// 操作内容
	private String operate_content = StringUtils.EMPTY;
	
	// 操作结果 默认成功
	private Integer operate_result = 1;
	
	// 操作人
	private Integer operate_num_uid;
	
	// 操作时间
	private String operate_time = StringUtils.EMPTY;
}
