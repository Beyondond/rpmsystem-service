package cn.com.dhc.rpmsystem.system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhouyongzhou
 * @description 部门实体
 * @date 2019/8/6
 */
@Getter
@Setter
public class Department {
    /**
     * 主键id
     */
    private int id;
    /**
     * 部门名称
     */
    private String dp_name;
    /**
     * 上级部门id  为空表明没有上级部门
     */
    private int paternal_id;
    /**
     * 创建人工号
     */
    private int created_num_uid;
    /**
     * 创建时间
     */
    private Date created_time;

}
