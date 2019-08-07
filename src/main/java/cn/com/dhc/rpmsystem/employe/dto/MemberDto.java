package cn.com.dhc.rpmsystem.employe.dto;

import cn.com.dhc.rpmsystem.entity.ReqPage;
import lombok.Getter;
import lombok.Setter;


/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
public class MemberDto extends ReqPage {


    /**
     * 检索姓名
     */
    private String searchName;

}
