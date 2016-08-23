package com.github.reka.gson.type.adapater;

import com.github.reka.gson.enumeration.GsonEnum;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 16:17
 * @description :
 */
public class GsonEnumTypeAdapter<E extends Enum<E>> implements JsonSerializer<E>, JsonDeserializer<E> {

    private final GsonEnum<E> gsonEnum;

    public GsonEnumTypeAdapter(GsonEnum<E> gsonEnum) {
        this.gsonEnum = gsonEnum;
    }

    @Override
    public JsonElement serialize(E src, Type typeOfSrc, JsonSerializationContext context) {
        if (null != src && src instanceof GsonEnum) {
            return new JsonPrimitive(((GsonEnum) src).serialize());
        }
        return null;
    }

    @Override
    public E deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (null != json) {
            return gsonEnum.deserialize(json.getAsString());
        }
        return null;
    }

}
