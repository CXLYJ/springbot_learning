package com.lyj.repository;

import com.lyj.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lyj on 2018/11/2.
 * JPA接口
 * 创建UserJPA接口并且继承SpringDataJPA内的接口作为父类，UserJPA继承了JpaRepository接口
 * （SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、Serializable（序列化接口）。
 */
public interface OrderJPA extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order>{
}


//public interface TargetRepository extends CrudRepository<Order,Long> {
//
//}