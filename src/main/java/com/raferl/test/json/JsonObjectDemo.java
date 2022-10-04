package com.raferl.test.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author raferlyan
 * @date 2022/9/6 21:16
 **/
public class JsonObjectDemo {
    public static void main(String[] args) {
        test03();
    }

    /**
     * 生成JSONObject对象
     */
    public static void test01(){
        JSONObject jsonObject01 = new JSONObject();
        jsonObject01.put("name","yjc");

        JSONObject jsonObject02 = new JSONObject();
        jsonObject02.put("table_name","yjc");
        String table_name = jsonObject01.getString("table_name");
        System.out.println(table_name);
        List<JSONObject> jsonObjects = new ArrayList<>();
        jsonObjects.add(jsonObject01);
        jsonObjects.add(jsonObject02);
        List<JSONObject> data =
                jsonObjects.stream().filter(jsonObject ->
                        Objects.equals(jsonObject.getString("table_name"), "yjc"))
                        .collect(Collectors.toList());
        System.out.println(data.size());
    }

    /**
     * 爬取JSON对象信息
     */
    public static void test02(){
        JSONObject jsonObject = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("data01");
        list.add("data02");

        jsonObject.put("name",list);
        System.out.println(jsonObject);
        String json = jsonObject.toString();
        System.out.println(json);

        JSONArray name = JSONObject.parseObject(json).getJSONArray("name");
        List<String> result = name.toJavaList(String.class);
        System.out.println(result);
    }

    /**
     * String转JSONObject
     */
    public static void test03(){
        String modelData = "{\"DEV_ID\": \"8000000020012784\", \"DATA_DATE\":  \"2022-07-26\", \"COLL_TIME\":  \"2022-08-19 01:01:10\", " +
                "\"PHASE_FLAG\": \"1\", \"VOLT_TR\": \"1.0\", \"U0000\": \"2.2\", \"U0015\": \"2.3\", \"U0030\": \"2.3\", \"U0045\": \"\", \"U0100\": \"2.1\"}";
        JSONObject modelJson = JSONObject.parseObject(modelData);
        String timePoint1 = modelJson.getString("U0100");
        String timePoint2= modelJson.getString("U0115");
        String timePoint3= modelJson.getString("U0045");
        System.out.println(timePoint1);
        System.out.println(timePoint2);

        System.out.println(timePoint3);
        if (timePoint3.isEmpty()){
            System.out.println("empty");
        }
    }
}
