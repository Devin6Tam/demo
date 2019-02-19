package com.mzbloc.demo.sample105.demo;

import com.mzbloc.demo.sample105.helper.SoapHelper;
import com.mzbloc.demo.sample105.interceptor.ClientLoginInterceptor;
import com.mzbloc.demo.sample105.soap.DemoService;
import com.mzbloc.springboot.cxf.soap.param.ClientRequestParamVo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tanxw on 2019/2/1.
 */
public class DemoServiceTest {

    @Test
    public void sayHelloTest(){
        ClientRequestParamVo clientRequestParamVo = new ClientRequestParamVo();
        String wsdl = "http://localhost:1890/soap/services/DemoService";
        clientRequestParamVo.setAddress(wsdl);
        clientRequestParamVo.setUsername("devintam");
        clientRequestParamVo.setPassword("123456");
        ClientLoginInterceptor interceptor = new ClientLoginInterceptor(clientRequestParamVo);
        DemoService demoService = SoapHelper.createClient(clientRequestParamVo.getAddress(), DemoService.class,interceptor);
        String sayHello = demoService.sayHello("devintam");
        System.out.println(sayHello);
        Assert.assertNotNull(sayHello);
    }
}
