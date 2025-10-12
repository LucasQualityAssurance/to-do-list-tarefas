package com.LucasQualityAssurance.plataforma.dtos;

import com.LucasQualityAssurance.plataforma.enums.TaskStatus;
import com.LucasQualityAssurance.plataforma.models.TaskModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @NotBlank(message = "O título não pode ser nullo")
    private String title;

    @NotBlank(message = "A descrição não pode ser nulla")
    private String description;

    @NotNull(message = "O status não pode ser nullo")
    private TaskStatus status;

    public TaskDto(TaskModel taskModel) {
        BeanUtils.copyProperties(taskModel, this);
    }
}
