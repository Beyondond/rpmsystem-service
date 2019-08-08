package cn.com.dhc.rpmsystem.system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RpmMemberRole {
    private Integer numUid;

    private String memName;

    private String roleIds;

    private String password;

    private String columnShow;

    private Integer createdNumUid;

    private Date createdTime;

}