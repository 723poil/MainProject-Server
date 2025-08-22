package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import com.mp.mainproject.db.entity.enums.MemberRole;
import com.mp.mainproject.db.entity.enums.MemberStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "project_members")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Integer projectMemberId;

    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    @Column(name = "member_status", columnDefinition = "varchar(10) default 'ACTIVE'", nullable = false)
    private MemberStatus memberStatus;

    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    @Column(name = "member_role", columnDefinition = "varchar(10) default 'MEMBER'", nullable = false)
    private MemberRole memberRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}
