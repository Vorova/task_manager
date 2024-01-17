package com.vorova.task_manager.model.entity;

import com.vorova.task_manager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "task")
public class Task {

    @Id
    private Long id;

    @ManyToOne()
    private User userId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "last_change_date")
    private LocalDateTime lastChangeDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}
