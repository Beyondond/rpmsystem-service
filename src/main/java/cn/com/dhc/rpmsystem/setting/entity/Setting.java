package cn.com.dhc.rpmsystem.setting.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Setting implements Serializable {
    private static final long serialVersionUID = -8326563674883615209L;

    private Long id;

    private String settingName;

    private String settingValue;

    private Integer enableStatus;

    private String skill;


}