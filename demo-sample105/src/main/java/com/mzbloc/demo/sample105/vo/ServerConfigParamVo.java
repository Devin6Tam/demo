package com.mzbloc.demo.sample105.vo;

/**
 * Created by tanxw on 2019/2/1.
 */
public class ServerConfigParamVo extends AbstractInterceptorParamVo{

    /**
     * 接口地址
     */
    private String address;

    /**
     * 服务接口
     */
    private Class<?> interfaceClass;

    /**
     * 服务接口实现类
     */
    private Object implementInstance;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public Object getImplementInstance() {
        return implementInstance;
    }

    public void setImplementInstance(Object implementInstance) {
        this.implementInstance = implementInstance;
    }
}
