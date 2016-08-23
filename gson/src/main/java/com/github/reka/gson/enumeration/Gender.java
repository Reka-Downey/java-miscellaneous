package com.github.reka.gson.enumeration;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 15:50
 * @description :
 */
public enum Gender implements GsonEnum<Gender> {

    MALE("男"), FEMALE("女");

    private final String type;

    Gender(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Gender parse(String type) {
        switch (type) {
            case "男":
                return Gender.MALE;
            case "女":
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException("There is not enum names with [" + type + "] of type Gender exists! ");
        }
    }

    @Override
    public Gender deserialize(String jsonEnum) {
        return Gender.parse(jsonEnum);
    }

    @Override
    public String serialize() {
        return this.getType();
    }

}
