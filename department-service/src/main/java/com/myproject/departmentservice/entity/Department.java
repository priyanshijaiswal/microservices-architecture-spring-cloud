package com.myproject.departmentservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
