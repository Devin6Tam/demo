package com.mzbloc.demo.sample105.demo;

import com.mzbloc.demo.sample105.interceptor.ClientLoginInterceptor;
import com.mzbloc.demo.sample105.soap.DemoService;
import com.mzbloc.springboot.cxf.soap.helper.SoapHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tanxw on 2019/2/1.
 */
public class DemoServiceTest {

    @Test
    public void sayHelloTest(){
        String wsdl = "http://localhost:1890/soap/services/DemoService";

        ClientLoginInterceptor interceptor = new ClientLoginInterceptor("devintam","123456");
        DemoService demoService = SoapHelper.createClient(wsdl, DemoService.class,interceptor);
        String sayHello = demoService.sayHello("devintam");
        System.out.println(sayHello);
        Assert.assertNotNull(sayHello);
    }
}
