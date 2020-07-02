package com.gwi.demotest.rest.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 调用禅道创建需求
 * 当前方案未使用
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CallZen {

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://139.9.53.111:8082/biz/";
    private String SID = "user-login.json?zentaosid=";
    private String GET_SID = "api-getsessionid.json";
    private String CREATE_STORY = "story-create-save-0-0.html?zentaosid=";

    @Value("${zentao.user}")
    private String user;

    @Value("${zentao.password}")
    private String password;

    private String getAccountString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("&account=").append(user);
        sb.append("&password=").append(password);
        return sb.toString();
    }

    public void createStory()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(URL).append(CREATE_STORY).append(SID);
        String createURL = sb.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = getMap();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ///  执行HTTP请求
        ResponseEntity<String> response = this.restTemplate.exchange(createURL, HttpMethod.POST, requestEntity, String.class);
        //  输出结果
        System.out.println("result" + response.getBody());

    }

    private MultiValueMap<String, String> getMap() {
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
        return params;
    }

    public String lognin()
    {
        StringBuffer sb = new StringBuffer();
        String loginURL = sb.append(URL)
                .append(SID)
                .append(getSessionId())
                .append(getAccountString()).toString();
        //String loginURL = URL + SID + getSessionId() + ACCOUNT;
        HttpEntity<String> request = new HttpEntity<String>("");

        String loginResult = this.restTemplate.postForObject(loginURL,request, String.class);
        JSONObject login = JSONObject.parseObject(loginResult);
        String loginStatus = login.getString("status");
        return  loginStatus;
    }

    public String getSessionId() {
        String result = this.restTemplate.getForObject(URL + GET_SID, String.class);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = (String)jsonObject.get("data");
        JSONObject dataObject = JSONObject.parseObject(data);
        String sessionId = (String) dataObject.get("sessionID");
        return sessionId;
    }

}
