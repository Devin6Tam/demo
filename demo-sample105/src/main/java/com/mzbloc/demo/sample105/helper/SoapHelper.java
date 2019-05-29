package com.mzbloc.demo.sample105.helper;

import com.mzbloc.springboot.cxf.soap.util.PropsUtil;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanxw on 2019/2/18.
 */
public class SoapHelper {

    private static List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<Interceptor<? extends Message>>();
    private static List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<Interceptor<? extends Message>>();

    static {
        // 添加 Logging Interceptor
        Boolean isLog = PropsUtil.getBoolean(PropsUtil.loadProps("application.properties"),"mzbloc.soap.interceptorLogEnable");
        if (isLog) {
            LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
            inInterceptorList.add(loggingInInterceptor);
            LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
            outInterceptorList.add(loggingOutInterceptor);
        }
    }

    /**
     * 创建 SOAP 客户端
     */
    public static <T> T createClient(String wsdl, Class<? extends T> interfaceClass,
                                     Interceptor<? extends Message> outInterceptor) {
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setAddress(wsdl);
        factory.setServiceClass(interfaceClass);
        factory.setInInterceptors(inInterceptorList);
        if(outInterceptor!=null) {
            outInterceptorList.add(outInterceptor);
        }
        factory.setOutInterceptors(outInterceptorList);

        return factory.create(interfaceClass);
    }
}
