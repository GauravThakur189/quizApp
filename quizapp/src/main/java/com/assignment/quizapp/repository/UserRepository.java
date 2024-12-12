package com.assignment.quizapp.repository;


import com.assignment.quizapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}