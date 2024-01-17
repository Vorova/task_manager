package com.vorova.task_manager.model.dto;

import com.vorova.task_manager.model.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private Long id;

    private User userId;

    private String title;

    private String description;

    private LocalDateTime createDate;

    private LocalDateTime lastChangeDate;

    private String taskStatus;

}
