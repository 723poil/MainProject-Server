package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import com.mp.mainproject.db.entity.enums.ProjectStatus;
import com.mp.mainproject.db.entity.enums.SocialProvider;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "project_name", columnDefinition = "varchar(100)", nullable = false)
    private String projectName;

    @Size(max = 500)
    @Column(name = "project_description", columnDefinition = "varchar(500)", nullable = true)
    private String projectDescription;

    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    @Column(name = "project_status", columnDefinition = "varchar(10) default 'ACTIVE'", nullable = false)
    private ProjectStatus projectStatus;

    @Column(name = "start_date", columnDefinition = "date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "date", nullable = true)
    private LocalDate endDate;
}
