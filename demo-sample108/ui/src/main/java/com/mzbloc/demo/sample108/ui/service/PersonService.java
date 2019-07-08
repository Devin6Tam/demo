package com.mzbloc.demo.sample108.ui.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tanxw
 * @date 2019/6/28
 */
@FeignClient("person")
public interface PersonService {

    @RequestMapping(method = RequestMethod.POST, value = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Object save(@RequestBody String  name);

    @RequestMapping(method = RequestMethod.POST, value = "/savePerson",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Object savePerson(@RequestBody String  name);
}
