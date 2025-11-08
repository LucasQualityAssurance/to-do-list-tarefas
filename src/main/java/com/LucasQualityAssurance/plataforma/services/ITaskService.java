package com.LucasQualityAssurance.plataforma.services;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    TaskResponseDto register(@Valid TaskDto data);

    List<TaskResponseDto> findAll();

    TaskResponseDto findById(UUID taskId);

    void delete(UUID taskId);
}
