package vikash.DC_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DC_EDUCATION")
@Data
public class DcEducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eduId;
    private Long CaseNum;
    private String highestEdu;
    private Integer graduationYear;
}