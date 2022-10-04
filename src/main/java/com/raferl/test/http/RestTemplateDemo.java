package com.raferl.test.http;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * @author raferlyan
 * @date 2022/9/20 16:49
 **/
public class RestTemplateDemo {

    public static void main(String[] args) {
        String url = "https://api.bilibili.com/x/web-interface/view?aid=301916887";

        RestTemplate restTemplate = new RestTemplate();
        String responseObject = restTemplate.getForObject(url, String.class);
        JSONObject bilibiliResponse = JSONObject.parseObject(responseObject).getJSONObject("data");
        String bvid = bilibiliResponse.getString("bvid");
        System.out.println("https://www.bilibili.com/video/" + bvid);
        String title = bilibiliResponse.getString("title");
        System.out.println(title);
        String pic = bilibiliResponse.getString("pic");
        System.out.println(pic);
        JSONObject result = new JSONObject();
        result.put("title", title);
        result.put("pic", pic);
        result.put("linkVideo", "https://www.bilibili.com/video/" + bvid);
        System.out.println(result);
    }
}
