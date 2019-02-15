package com.mzbloc.demo.sample105.soap;

import com.mzbloc.springboot.cxf.soap.annotation.Soap;
import org.springframework.stereotype.Service;

/**
 * Created by tanxw on 2019/1/30.
 */
@Soap
@Service
public class DemoServiceImpl implements DemoService{

    @Override
    public String sayHello(String word){
        return "hello,"+word;
    }
}
