package cn.com.dhc.rpmsystem.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouyongzhou
 * @description
 * @date 2019/8/7
 */
@Getter
@Setter
public class OperateLogDto implements Serializable {

    /**
     * 检索操作对象
     */
    private String operateTarget;

    /**
     * 检索操作人工号
     */
    private Integer operateAccount;

    /**
     * 检索起始时间
     */
    private Date startTime;

    /**
     * 检索结束时间
     */
    private Date endTime;

    /**
     * 检索操作人姓名
     */
    private String operateName;

    /**
     * 检索操作结果
     */
    private Integer operateResult;

    /**
     * 检索类型 0-operateTarget（操作对象） 1--operateAccount（操作人工号 int）
     *          2--operateName (操作人名字) 3--operateResult（操作结果 int）
     */
    private Integer searchType;
}
