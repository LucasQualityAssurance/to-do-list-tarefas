package com.LucasQualityAssurance.plataforma.controllers;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import com.LucasQualityAssurance.plataforma.services.ITaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
