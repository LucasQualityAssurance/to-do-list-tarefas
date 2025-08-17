package com.LucasQualityAssurance.plataforma.dtos;

import com.LucasQualityAssurance.plataforma.enums.TaskStatus;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskResponseDto(TaskModel taskSaved) {
        BeanUtils.copyProperties(taskSaved,  this);
        this.createdAt = taskSaved.getCreatedAt();
        this.updatedAt = taskSaved.getUpdatedAt();
    }
}
