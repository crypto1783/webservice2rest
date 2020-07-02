package com.gwi.demotest.webservice.api;


import com.gwi.demotest.webservice.vo.TaskDetail;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.jws.WebService;

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://api.webservice.demotest.gwi.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    public String createTask(TaskDetail detail) throws UnirestException;

}
