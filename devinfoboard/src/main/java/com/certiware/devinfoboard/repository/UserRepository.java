package com.certiware.devinfoboard.repository;

import java.util.ArrayList;

import com.certiware.devinfoboard.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//하나의 테이블이라고 생각해라. CrudRepository인터페이스를 상속받으며
//제네릭 타입중 첫번째는 테이블의 컬럼이 매핑되어있는 클래스, 두번째는 user테이블의 기본키 타입을 넣는다.,\

public interface UserRepository extends JpaRepository<User, Integer>{
    //DAO랑 같은 역할 ,,
    ArrayList<User> findByNameContaining(String name);
}