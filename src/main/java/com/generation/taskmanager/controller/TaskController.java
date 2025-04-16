package com.generation.taskmanager.controller;
import com.generation.taskmanager.model.Task;
import com.generation.taskmanager.model.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
