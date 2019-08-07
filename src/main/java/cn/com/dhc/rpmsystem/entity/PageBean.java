package cn.com.dhc.rpmsystem.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类PageBean
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = -7877845715124492334L;


    /**
     * 当前页数
     */
    private int page;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 每页显示的记录数
     */
    private int limit;

    /**
     * 每页显示数据记录的集合
     */
    private List<T> list;

}
