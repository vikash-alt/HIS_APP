package ar.vikash.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "CITIZEN_APPS")
public class CitizenAppsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;
    private String fullName;
    private String email;
    private Long phNo;
    private Long ssn;
    private String gender;
    private String stateName;
    private LocalDate dob;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
    private String createdBy;
    private String updatedBy;
}
