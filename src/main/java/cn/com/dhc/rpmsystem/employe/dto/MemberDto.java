package cn.com.dhc.rpmsystem.employe.dto;

import cn.com.dhc.rpmsystem.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
public class MemberDto implements Serializable {

    private static final long serialVersionUID = -5392034203655686144L;

    /**
     * 查询当前页数
     */
    private Integer currPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 检索姓名
     */
    private String searchName;

    /**
     * 排序条件
     */
    private Order order;
}
