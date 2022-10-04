package com.raferl.test.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author raferlyan
 * @date 2022/10/3 09:49
 **/
public class HttpClientDemo {

    public static void main(String[] args) {
        demo03();
    }

    /**
     * GET 请求（无参）
     */
    public static void demo01(){

        try(// 定义 httpclient
            CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            // 创建 httpGet
            HttpGet httpGet = new HttpGet("https://rqs.waterstone.top:1443/question/sample");
            // 定义返回结果
            CloseableHttpResponse execute;
            // 发送执行
            execute = httpClient.execute(httpGet);
            // 获取返回值
            HttpEntity entity = execute.getEntity();
            System.out.println("响应状态为:" + execute.getStatusLine());
            if (Objects.nonNull(entity)) {
                System.out.println("响应内容长度为:" + entity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(entity));
            }
            execute.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * GET 有参
     */
    public static void demo02(){
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            // 创建参数列表
            List<NameValuePair> valueParamsList = new ArrayList<>();
            valueParamsList.add(new BasicNameValuePair("productType","STAPLE_FOOD"));
            valueParamsList.add(new BasicNameValuePair("after",""));
            valueParamsList.add(new BasicNameValuePair("before",""));
            // 创建对应请求 Uri
            URI uri = new URIBuilder().setScheme("https")
                    .setHost("rqs.waterstone.top:1443")
                    .setPath("/record")
                    .setParameters(valueParamsList)
                    .build();
            // 根据 Uri 创建 httpGet
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse execute;
            // 发送执行
            execute = httpClient.execute(httpGet);
            // 获取返回值
            HttpEntity entity = execute.getEntity();
            System.out.println("响应状态为:" + execute.getStatusLine());
            if (Objects.nonNull(entity)) {
                System.out.println("响应内容长度为:" + entity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(entity));
            }
            execute.close();
        } catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }

    /**
     * POST
     */
    public static void demo03(){
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            // 创建Post请求
            HttpPost httpPost = new HttpPost("https://rqs.waterstone.top:1443/question");

            JsonDto jsonDto = new JsonDto();
            jsonDto.setOptionType("B");
            jsonDto.setQuestionId(11);
            jsonDto.setQuestionType("OPTION");

            String jsonString = JSON.toJSONString(jsonDto);
            StringEntity entity = new StringEntity(jsonString, "UTF-8");
            // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json;charset=utf8");
            // 响应模型
            CloseableHttpResponse response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
            System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
           }
           response.close();
        }  catch (IOException e){
            e.printStackTrace();
        }
    }
}
