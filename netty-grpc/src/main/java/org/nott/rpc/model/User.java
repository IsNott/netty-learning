package org.nott.rpc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nott
 * @date 2024-7-23
 */

@Data
public class User implements Serializable {

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private String id;

    private String name;

    private Integer age;

}
