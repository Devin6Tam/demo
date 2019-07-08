package com.mzbloc.demo.sample108.ui.service;

import com.mzbloc.demo.sample108.ui.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanxw
 * @date 2019/6/28
 */
@Service
public class PersonHystrixService {

    @Autowired
    private PersonService personService;


    @HystrixCommand(fallbackMethod = "fallbackSave")
    public Object save(String name) {
        return personService.save(name);
    }

    @HystrixCommand(fallbackMethod = "fallbackSavePerson")
    public Object savePerson(String name) {
        return personService.savePerson(name);
    }

    public Object fallbackSave(String name){
        return new Person(name+"没有保存成功，Person Service 故障");
    }

    public Object fallbackSavePerson(String name){
        return new Person(name+"没有保存成功，Person Service 故障");
    }
}
