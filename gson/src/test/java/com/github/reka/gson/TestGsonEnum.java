package com.github.reka.gson;

import com.github.reka.gson.domain.Person;
import com.github.reka.gson.enumeration.Faction;
import com.github.reka.gson.enumeration.Gender;
import com.github.reka.gson.type.adapater.GsonEnumTypeAdapter;
import com.github.reka.gson.type.adapater.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 16:23
 * @description :
 */
public class TestGsonEnum {

    @Test
    public void testGson() throws Exception {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(Gender.class, new GsonEnumTypeAdapter<>(Gender.FEMALE))
                .registerTypeAdapter(Faction.class, new GsonEnumTypeAdapter<>(Faction.ABNEGATION))
                .create();

        Person p1 = new Person("雷卡", Gender.MALE, Faction.DAUNTLESS, LocalDate.of(1994, 10, 11));
        System.out.println("调用 toString 方法：\n" + p1);
        String jsonText = gson.toJson(p1);
        System.out.println("将 person 转换成 json 字符串：\n" + jsonText);

        System.out.println("-------------------");

        Person p2 = gson.fromJson(jsonText, Person.class);
        assert p2 != p1;
        System.out.println("根据 json 字符串生成 person 实例：\n" + p2);

    }

    @Test
    public void testDefault() throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
        Person p1 = new Person("莉莉安", Gender.FEMALE, Faction.AMITY, LocalDate.of(1990, 10, 11));

        String x = gson.toJson(p1);
        System.out.println(x);

        System.out.println(gson.fromJson(x, Person.class));

    }


    @Test
    public void testExtends() throws Exception {
        List<Number> numberList = new ArrayList<>();
        numberList.add(12);
        numberList.add(12.4);
        this.show(numberList);
        this.show2(numberList);

        List<Integer> integerList = new ArrayList<>();
        this.show(integerList);
        //this.show2(integerList);
    }

    private void show(List<? extends Number> list) {
        // extends 之后变成只能读，无法写的情况，读的时候必须大于等于指定泛型
        Number a = list.get(0);
        Number d = list.get(1);
        //list.set(1, 12);
    }

    private void show2(List<Number> list) {
        Number a = list.get(1);
    }

    @Test
    public void testSuper() throws Exception {
        List<? super Number> numbers = new ArrayList<>();

        // super 之后可以写入比指定泛型更小的类型，但读取时只能读取出 Object，其他类型需要强制类型转换
        numbers.add(12);
        numbers.add(12.4);
        System.out.println(numbers.size());
        double d = (double) numbers.get(1);
        int a = (int) numbers.get(0);
        Object o = numbers.get(0);
        System.out.println(d);
        System.out.println(a);
    }


    static class Census {

        public static void addRegistry(Map<String, ? extends Person> registry) {
        }

    }

    @Test
    public void testCensus() throws Exception {
        Map<String, Driver> allDrivers = new HashMap<>();

        Census.addRegistry(allDrivers);
    }

    class Driver extends Person {

    }
}
