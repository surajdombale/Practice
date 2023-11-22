package com.example.springbootjpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<com.example.springbootjpa.entity.Student,Integer>{
	
}
