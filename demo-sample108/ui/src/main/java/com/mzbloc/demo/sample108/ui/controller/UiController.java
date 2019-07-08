package com.mzbloc.demo.sample108.ui.controller;

import com.mzbloc.demo.sample108.ui.service.PersonHystrixService;
import com.mzbloc.demo.sample108.ui.service.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UI 控制器
 *
 * @author tanxw
 * @date 2019/6/28
 */
@RestController
public class UiController {

    @Autowired
    private SomeHystrixService someHystrixService;

    @Autowired
    private PersonHystrixService personHystrixService;

    @RequestMapping("/dispatch")
    public Object save(@RequestBody String personName) {
        return personHystrixService.save(personName);
    }

    @RequestMapping("/savePerson")
    public Object savePerson(@RequestBody String personName) {
        return personHystrixService.savePerson(personName);
    }


    @RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
    public String getSome(){
        return someHystrixService.getSome();
    }
}
