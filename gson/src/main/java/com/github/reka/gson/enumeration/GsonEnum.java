package com.github.reka.gson.enumeration;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 15:46
 * @description :
 */
public interface GsonEnum<E extends Enum<E>> {

    String serialize();

    E deserialize(String jsonEnum);

}
