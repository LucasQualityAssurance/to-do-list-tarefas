package com.LucasQualityAssurance.plataforma.models;

import com.LucasQualityAssurance.plataforma.dtos.TaskDto;
import com.LucasQualityAssurance.plataforma.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tarefa")
@Entity(name = "TaskModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String title;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "data_criacao")
    private LocalDateTime createdAt;

    @Column(name = "data_atualizacao")
    private LocalDateTime updatedAt;

    public TaskModel(TaskDto data) {
        BeanUtils.copyProperties(data, this);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
