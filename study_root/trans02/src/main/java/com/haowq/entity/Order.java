package com.haowq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class Order implements Serializable {
    private Integer id;

    private String orderName;

    private static final long serialVersionUID = 1L;
}