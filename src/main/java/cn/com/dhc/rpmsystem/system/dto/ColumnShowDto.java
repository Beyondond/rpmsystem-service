package cn.com.dhc.rpmsystem.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zss
 * @date 2019-08-08
 */
@Getter
@Setter
public class ColumnShowDto implements Serializable {
    private static final long serialVersionUID = 2470326299471120979L;

    /**
     * 全部列
     */
    private Map<Integer, String> columnAll;

    /**
     * 要展示的列
     */
    private List<String> columnShow;
}
