package com.github.reka.gson.enumeration;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 16:08
 * @description :
 */
public enum Faction implements GsonEnum<Faction> {

    ABNEGATION("无私派"), AMITY("和平派"), DAUNTLESS("无畏派"), CANDOR("诚实派"), ERUDITE("博学派");

    private final String name;

    Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Faction parse(String faction) {
        switch (faction) {
            case "无私派":
                return Faction.ABNEGATION;
            case "和平派":
                return Faction.AMITY;
            case "无畏派":
                return Faction.DAUNTLESS;
            case "诚实派":
                return Faction.CANDOR;
            case "博学派":
                return Faction.ERUDITE;
            default:
                throw new IllegalArgumentException("There is not enum names with [" + faction + "] of type Faction exists! ");
        }
    }

    @Override
    public Faction deserialize(String jsonEnum) {
        return Faction.parse(jsonEnum);
    }

    @Override
    public String serialize() {
        return this.getName();
    }

}
