package com.haowq.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private String pass;

    private static final long serialVersionUID = 1L;
}