package cn.com.dhc.rpmsystem.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zss
 * @date 2019-08-08
 */
@Getter
@Setter
public class ColumnShowSetUpDto implements Serializable {
    private static final long serialVersionUID = 1403145683998099240L;

    /**
     * 员工工号
     */
    private Integer numUid;

    private List<String> columnShow;
}
