package com.example.To_Do.App.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.To_Do.App.Repository.ToDoRepo;
import com.example.To_Do.App.model.ToDo;

@Service
public class TodoService {

	@Autowired
	public ToDoRepo todorepo;

	public List<ToDo> getAllToDoItems() {
		ArrayList<ToDo> todoList = new ArrayList<>();
		todorepo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}

	public ToDo getToDoItemById(Long id) {
		return todorepo.findById(id).get();
	}

	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedObj = todorepo.save(todo);
		if (getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}
		return false;

	}

	public boolean updateStatus(Long id) {
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Completed");
		return saveOrUpdateToDoItem(todo);

	}

	public boolean deleteToDoItem(Long id) {
		todorepo.deleteById(id);
		if (todorepo.findById(id).isEmpty()) {
			return true;
		}
		return false;

	}
}
