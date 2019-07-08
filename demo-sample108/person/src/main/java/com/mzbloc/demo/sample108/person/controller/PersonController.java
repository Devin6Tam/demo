package com.mzbloc.demo.sample108.person.controller;

import com.mzbloc.demo.sample108.person.dao.PersonRepository;
import com.mzbloc.demo.sample108.person.model.Person;
import com.mzbloc.demo.sample108.person.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户控制器
 *
 * @author tanxw
 * @date 2019/6/27
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseResult<Object> save(@RequestBody String  personName){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("abc","123456");
        modelMap.put("edf","147258");
        modelMap.put("ghi","159357");
        String randNum = UUID.randomUUID().toString().replace("-","");
        modelMap.put(randNum.substring(0,3),personName);
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS,"",modelMap);
    }

    @RequestMapping(value = "savePerson",method = RequestMethod.POST)
    public ResponseResult<Object> savePerson(@RequestBody String  personName){
        Person person = new Person();
        person.setName(personName);
        personRepository.save(person);
        List<Person> personList = personRepository.findAll();
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS,"",personList);
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponseResult<Object> list(int pageNum,int pageSize){

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(pageNum,pageSize,sort);
        Page<Person> pageInfo = personRepository.findAll(pageable);
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS,"",pageInfo);
    }

}
