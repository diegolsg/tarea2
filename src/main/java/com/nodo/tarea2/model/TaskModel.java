package com.nodo.tarea2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    private Long id;
    private String description;
    private boolean completed;
}
