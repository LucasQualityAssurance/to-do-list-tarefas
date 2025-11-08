package com.LucasQualityAssurance.plataforma.controllers;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import com.LucasQualityAssurance.plataforma.services.ITaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarefa")
public class TaskController {

    @Autowired
    private ITaskService service;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<Object> registerTask(@RequestBody @Valid TaskDto data) {
        try {
            TaskResponseDto taskResponseDto = this.service.register(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(taskResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/buscarTodos")
    @Transactional
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> taskResponseDtoList = this.service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDtoList);
    }

    @GetMapping("/buscarPorTarefa/{taskId}")
    @Transactional
    public ResponseEntity<TaskResponseDto> getOneTask(@PathVariable(value = "taskId") UUID taskId) {
        return ResponseEntity.ok(this.service.findById(taskId));
    }

    @DeleteMapping("/deletar/{taskId}")
    @Transactional
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "taskId") UUID taskId) {
        try {
            this.service.delete(taskId);
            return ResponseEntity.status(HttpStatus.OK).body("Task successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
