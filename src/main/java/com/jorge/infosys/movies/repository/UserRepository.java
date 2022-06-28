package com.jorge.infosys.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.infosys.movies.entity.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity,String> {
	

}
