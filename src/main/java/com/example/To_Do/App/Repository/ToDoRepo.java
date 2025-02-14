package com.example.To_Do.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.To_Do.App.model.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
