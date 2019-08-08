package cn.com.dhc.rpmsystem.common;

/**
 * 常量类
 * @author zss
 * @date 2019-08-05
 */
public class CommonConstant  {


    /**
     * 数据状态常量
     */
    public enum DataStatus implements EnumInterface {
        EXIST(1, "存在"),
        DELETE(0, "删除");

        Integer value;
        String desc;

        DataStatus(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }

    /**
     * setting是否启用
     */
    public enum EnableSetting implements EnumInterface {
        ENABLE(1, "启用"),
        NOT_ENABLE(2, "未启用");

        Integer value;
        String desc;

        EnableSetting(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }


    /**
     * 员工首页展示列
     */
    public enum ColumnShow implements EnumInterface {
        numUid(1, "工号"),
        memName(2, "姓名"),
        memGender(3, "性别"),
        memLevel(4, "级别"),
        positon(5, "职位"),
        education(6, "学历"),
        major(7, "专业"),
        engLevel(8, "英语等级"),
        graSchool(9, "毕业学校"),
        graTime(10, "毕业时间"),
        initPositionTime(11, "入职时间"),
        initProjectTime(12, "入项时间"),
        technologyType(13, "技术类型"),
        platformSystem(14, "平台系统"),
        phoneNum(15, "电话号码"),
        identityId(16, "身份证号"),
        mailbox(17, "个人邮箱"),
        technologyYears(18, "技术年限"),
        hwExp(19, "是否有华为经验"),
        pastCorp(20, "过往公司"),
        projectExp(21, "项目经验"),
        inputNumUid(22, "录入人员工号"),
        inputTime(23, "录入时间"),
        positionStatus(24, "是否在职");


        Integer value;
        String desc;

        ColumnShow(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }

}
