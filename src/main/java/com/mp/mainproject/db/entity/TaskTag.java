package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "task_tags")
@NoArgsConstructor
@AllArgsConstructor
public class TaskTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "task_tag_name", columnDefinition = "varchar(20)", nullable = false)
    private String taskTagName;

    @NotNull
    @Column(name = "use_status", columnDefinition = "TINYINT(1) default 1", nullable = false)
    private Boolean useStatus;

    @OneToMany(mappedBy = "taskTag", fetch = FetchType.LAZY)
    @JoinColumn(name = "task_tag_id")
    private List<TaskTagMap> taskTagMaps = new ArrayList<>();
}
