package cn.com.dhc.rpmsystem.system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author kmy
 * @title: MemberRole
 * @projectName rpmsystem
 * @description: TODO
 * @date 2019/8/815:13
 **/
@Data
public class MemberRole {
    private int id;
    private String roleName;
    private String skills;
    private String createNumUid;
    private String columName;
    private Date created_time;
    private int numUid;
    private String  memName;
    private String roleIds;
    private String password;
    private String columnShow;
    private String createdNumUid;
    private Date createdTime;
}
