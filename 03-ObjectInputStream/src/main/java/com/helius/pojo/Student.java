package com.helius.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author jcf
 * @Create 2020-01-03-21:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private String name;
    private Integer age;
}
