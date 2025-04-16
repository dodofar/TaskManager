package com.generation.taskmanager.model.dao;

import com.generation.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository <Task, Long>
{
}
