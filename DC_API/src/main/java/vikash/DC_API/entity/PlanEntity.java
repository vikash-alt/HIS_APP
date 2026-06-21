package vikash.DC_API.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "PLAN_MASTER")
@Data
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;
    private String planName;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private String activeSw;
    private Integer planCategoryID;
    private String createdBy;
    private String updatedBy;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
}
