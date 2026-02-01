package com.Study_planner.Service;

import com.Study_planner.Model.Task;
import com.Study_planner.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(String title) {
        return repository.save(title);
    }

    public List<Task> getTasks() {
        return repository.findAll();
    }

    public boolean completeTask(int id) {
        return repository.complete(id);
    }

    public boolean deleteTask(int id) {
        return repository.delete(id);
    }
}

