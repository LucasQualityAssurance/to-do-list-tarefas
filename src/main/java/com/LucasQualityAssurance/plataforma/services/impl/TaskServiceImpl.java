package com.LucasQualityAssurance.plataforma.services.impl;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.dtos.TaskResponseDto;
import com.LucasQualityAssurance.plataforma.exceptions.TaskException;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import com.LucasQualityAssurance.plataforma.repositories.ITaskRepository;
import com.LucasQualityAssurance.plataforma.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public List<TaskResponseDto> findAll() {
        List<TaskModel> taskModelList = this.taskRepository.findAll();
        return taskModelList.stream().map(TaskResponseDto::new).toList();
    }

    @Override
    public TaskResponseDto findById(UUID taskId) {
        Optional<TaskModel> taskModelOptional = this.taskRepository.findById(taskId);
        if (taskModelOptional.isEmpty()) {
            throw new TaskException("Task with this id not found.");
        }

        return new TaskResponseDto(taskModelOptional.get());
    }

    @Override
    public void delete(UUID taskId) {
        Optional<TaskModel> taskModelOptional = this.taskRepository.findById(taskId);
        if (taskModelOptional.isEmpty()) {
            throw new TaskException("Task with this id not found.");
        }

        this.taskRepository.delete(taskModelOptional.get());
    }
}
