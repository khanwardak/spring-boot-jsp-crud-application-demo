package com.practice2.practice2.repository;

import com.practice2.practice2.controller.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRespository extends JpaRepository<Todo, Integer> {
  public List<Todo> findByUsername(String username);
}
