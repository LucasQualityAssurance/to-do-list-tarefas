package com.LucasQualityAssurance.plataforma.repositories;

import com.LucasQualityAssurance.plataforma.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    Optional<TaskModel> findByTitle(String title);
}
