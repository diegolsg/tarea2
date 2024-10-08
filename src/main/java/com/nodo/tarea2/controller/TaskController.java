package com.nodo.tarea2.controller;

import com.nodo.tarea2.model.TaskModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task" )
public class TaskController {
    private final List<TaskModel> task = new ArrayList<>();

    @GetMapping("/get")
    public ResponseEntity<List<TaskModel>> getAllTasks(){
        return ResponseEntity.ok(task);
    }

    @PostMapping("/post")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task1){
        task.add(task1);
        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<TaskModel> completeTask(@PathVariable Long id){
        for (TaskModel task1 : task){
            if (task1.getId().equals(id)){
                task1.setCompleted(true);
                return ResponseEntity.ok(task1);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        for (TaskModel task1 : task) {
            if (task1.getId().equals(id)) {
                task.remove(task1);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
