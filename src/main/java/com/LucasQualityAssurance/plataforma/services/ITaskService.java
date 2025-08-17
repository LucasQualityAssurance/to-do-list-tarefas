package com.LucasQualityAssurance.plataforma.services;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import jakarta.validation.Valid;

public interface ITaskService {
    TaskResponseDto register(@Valid TaskDto data);
}
