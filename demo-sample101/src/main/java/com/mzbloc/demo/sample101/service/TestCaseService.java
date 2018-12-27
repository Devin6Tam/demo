package com.mzbloc.demo.sample101.service;

import com.mzbloc.elasticsearch.entity.ClienteEntity;

/**
 * Created by tanxw on 2018/12/26.
 */
public interface TestCaseService {

    String say();

    ClienteEntity findCliente(String id);
}
