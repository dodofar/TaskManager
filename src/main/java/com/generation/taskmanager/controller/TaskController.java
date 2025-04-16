package com.generation.taskmanager.controller;
import com.generation.taskmanager.model.Task;
import com.generation.taskmanager.model.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//Clean architecture, Martin C. Fowler (uncle bob), le regole sono:
//1. Il verbo http deve rispecchiare l'azione, ossia => Get legge, post crea, put aggiorna, delete cancella;
//2. URL devono rappresentare perforza nomeclature di oggetti e non di azioni;
//ex. per aggiungere una task /aggiungiTask sarebbe errato, non sintatticamente ma semanticamente, meglio /tasks
//3. L'azione è determinata dal verbo HTTP non dal nome del path (ex. /getTasks/1, sarebbe sbagliato, il modo giusto sarebbe /tasks/1)

@RestController
@RequestMapping("/tasks")
public class TaskController
{
	@Autowired
	TaskDao taskDao;

	@GetMapping
	public List<Task> getAllTasks()
	{
		return taskDao.findAll();
	}

	@PostMapping
	public Task createTask(@RequestBody Task task)
	{
		return taskDao.save(task);
	}

	@DeleteMapping("/{id}")
	public void deleteTaskById(@PathVariable Long id)
	{
		taskDao.deleteById(id);
	}

	//TODO fare metodo chiamato getTaskById, che prende tramite pathvariabile id e restituisce la task con tale id
	//mappatura: /tasks/{id} GET
	//Fare metodo chiamato deleteAllTasks, void, che non prende variabili e cancella tutte le tasks
	//mappatura: /tasks DELETE

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id)
	{
		return taskDao.findById(id).orElse(null);
	}

	@DeleteMapping
	public void deleteAllTasks()
	{
		taskDao.deleteAll();
	}
}
