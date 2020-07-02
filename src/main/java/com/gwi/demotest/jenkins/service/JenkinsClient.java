package com.gwi.demotest.jenkins.service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Jenkins接口调用11
 * 此代码是从postman中生成的
 * 调用的是jenkins的一个插件generic-webhook-trigger暴露的接口
 */
public class JenkinsClient {

    public void callJenKins (String json) throws UnirestException
    {

        HttpResponse<String> response = Unirest.post("http://192.168.28.231:6080/generic-webhook-trigger/invoke")
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46YWRtaW5jY2pyMjAyMA1==")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "709ae29d-0a88-42c0-9165-c7c20d63a1081")
                .body(json)
                .asString();
        response.getBody();
    }
}
