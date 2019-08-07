package cn.com.dhc.rpmsystem.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
public class ReqPage implements Serializable {
    private static final long serialVersionUID = 434634798496091234L;

    /**
     * 查询当前页数
     */
    private Integer currPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 排序条件
     */
    private Order order;

}
