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
public class ColumnShowDto implements Serializable {
    private static final long serialVersionUID = 2470326299471120979L;

    /**
     * 全部列
     */
    private List<Inside> columnAll;

    /**
     * 要展示的列
     */
    private List<Integer> columnShow;

    @Getter
    @Setter
    public class Inside {

        private Integer id;

        private String name;

    }
}
