package com.gwi.demotest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



public class DemotestApplicationTests {

    private static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoads() {
        /*System.out.println("aaa");
        String url = "http://139.9.53.111:8082/biz/";
        String sid = "user-login.json?zentaosid=";
        String account = "&account=admin&password=gwi123456";
        //this.restTemplate.
        String result = this.restTemplate.getForObject(url+"api-getsessionid.json", String.class);
        //System.out.println(responseEntity.getBody());ResponseEntity<String> responseEntity =
        System.out.println("sid result ===" + result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = (String)jsonObject.get("data");
        System.out.println("data = " + data);
        JSONObject dataObject = JSONObject.parseObject(data);
        String sessionId = (String) dataObject.get("sessionID");

        System.out.println("sessionId = " + sessionId);
        String loginURL = url + sid + sessionId + account;
        HttpEntity<String> request = new HttpEntity<String>("");

        String loginResult = this.restTemplate.postForObject(loginURL,request, String.class);
        JSONObject login = JSONObject.parseObject(loginResult);
        String loginStatus = login.getString("status");
        System.out.println("==" +  loginStatus);

        if ("success".equals(loginStatus))
        {
            String createStory = "story-create-save-0-0.html?zentaosid=";
            String createURL = url + createStory + sessionId;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
            params.add("depart","创新项目组");
            params.add("customer", "刘岩");
            params.add("title", "任务1441");
            params.add("productType", "yy");
            params.add("module", "25");
            params.add("product","11");
            params.add("RDDepart[]","cxxmz");
            params.add("RMDescribe","测试接口");
            params.add("RMPrice","<p>1.aaa</p>\\r\\n<p>2.bbb</p>");
            params.add("currentProblem","描述客户痛点及想解决的问题：666");
            params.add("Senario","测试接口");
            params.add("FunctionRequest","无");
            params.add("estimate","");
            params.add("TimeRequest","无");
            params.add("priority","low");
            params.add("remark","");
            params.add("files[]","");
            params.add("toList[]","");
            params.add("\"uid\"","\"5eec2b21db4e2\"");
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            *///  执行HTTP请求
            //ResponseEntity<String> response = this.restTemplate.exchange(createURL, HttpMethod.POST, requestEntity, String.class);
            //  输出结果
            //System.out.println("body 1===" + response.getBody());


      //  }

    }
}