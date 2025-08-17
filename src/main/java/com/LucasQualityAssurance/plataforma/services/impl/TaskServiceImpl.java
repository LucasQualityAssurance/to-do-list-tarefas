package com.LucasQualityAssurance.plataforma.services.impl;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import com.LucasQualityAssurance.plataforma.exceptions.TaskException;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import com.LucasQualityAssurance.plataforma.repositories.ITaskRepository;
import com.LucasQualityAssurance.plataforma.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public TaskResponseDto register(TaskDto data) {
        Optional<TaskModel> taskModelOptional = this.taskRepository.findByTitle(data.getTitle());
        if (taskModelOptional.isPresent()) {
            throw new TaskException("Tarefa com esse nome já existe");
        }

        TaskModel taskModel = new TaskModel(data);
        TaskModel taskSaved = this.taskRepository.save(taskModel);

        return new TaskResponseDto(taskSaved);
    }
}
