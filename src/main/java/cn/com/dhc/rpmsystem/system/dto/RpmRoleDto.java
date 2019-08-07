package cn.com.dhc.rpmsystem.system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author kmy
 * @title: RpmRole
 * @projectName rpmsystem
 * @description: TODO
 * @date 2019/8/713:43
 **/
@Data
public class RpmRoleDto {

    private int id;

    private String roleName;

    private String skills;

    private String createNumUid;

    private String columName;

    private Date created_time;

}
