package com.mzbloc.demo.sample108.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author tanxw
 * @date 2019/7/2
 */
@Entity
@Data
public class Person extends BaseModel{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
