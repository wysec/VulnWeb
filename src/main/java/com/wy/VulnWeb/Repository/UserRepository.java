package com.wy.VulnWeb.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.wy.VulnWeb.Model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

     List<User> findByName(String name);

     
     // nativeQuery = true表示使用sql自己的方言查询，想查什么查什么， 按照字段数据类型返回就行了
     @Query(value = "select count(1) from user u1 where u1.name = ?1 and u1.password = ?2", nativeQuery = true)
     Integer findNameAndPassword(String name, String password);
     
}
