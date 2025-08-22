package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "task_name", columnDefinition = "varchar(30)", nullable = false)
    private String taskName;

    @Size(max = 500)
    @NotNull
    @Column(name = "task_content", columnDefinition = "varchar(500)", nullable = false)
    private String taskContent;

    @NotNull
    @Column(name = "duration", columnDefinition = "Decimal(5,1) default 0.0", precision = 5, scale = 1, nullable = false)
    private Double duration;

    @Column(name = "task_date", columnDefinition = "date", nullable = false)
    private LocalDate taskDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private ProjectMember projectMember;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private List<TaskTagMap> taskTagMaps = new ArrayList<>();
}
