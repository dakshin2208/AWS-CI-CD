package com.Study_planner.Repository;



import com.Study_planner.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private int counter = 1;

    public Task save(String title) {
        Task task = new Task(counter++, title);
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public boolean complete(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .map(t -> {
                    t.markCompleted();
                    return true;
                })
                .orElse(false);
    }

    public boolean delete(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }
}

