package com.Study_planner.TaskController;

import com.Study_planner.Model.Task;
import com.Study_planner.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task addTask(@RequestParam String title) {
        return service.addTask(title);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getTasks();
    }

    @PutMapping("/{id}/complete")
    public String completeTask(@PathVariable int id) {
        return service.completeTask(id)
                ? "Task completed"
                : "Task not found";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return service.deleteTask(id)
                ? "Task deleted"
                : "Task not found";
    }
}

