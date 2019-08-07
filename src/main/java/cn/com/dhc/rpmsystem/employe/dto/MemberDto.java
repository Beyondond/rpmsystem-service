package cn.com.dhc.rpmsystem.employe.dto;

import cn.com.dhc.rpmsystem.entity.Order;
import cn.com.dhc.rpmsystem.entity.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
public class MemberDto extends ReqPage {

    private static final long serialVersionUID = -5392034203655686144L;

    /**
     * 检索姓名
     */
    private String searchName;

}
