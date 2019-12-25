package com.lyj.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by lyj on 2018/11/2.
 */
@Data
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private String age;

}
