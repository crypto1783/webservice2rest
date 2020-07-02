package com.gwi.demotest.webservice.api;

import com.alibaba.fastjson.JSONObject;
import com.gwi.demotest.jenkins.service.JenkinsClient;
import com.gwi.demotest.webservice.vo.TaskDetail;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.client.RestTemplate;
import javax.jws.WebService;

@WebService(serviceName = "DemoService", // 与接口中指定的name一致
        targetNamespace = "http://api.webservice.demotest.gwi.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.gwi.demotest.webservice.api.DemoService"// 接口地址
)
public class DemoServiceImpl implements DemoService {

    private String JENKIN_URL = "http://192.168.28.231:6080/generic-webhook-trigger/invoke";

    private static RestTemplate restTemplate = new RestTemplate();
    @Override
    public String createTask(TaskDetail detail) throws UnirestException {

        String busiType = detail.getBusiType();
        System.out.println("==" + busiType);

        JenkinsClient jc = new JenkinsClient();
        jc.callJenKins(JSONObject.toJSONString(detail));

        return "success";
    }
}
