package vikash.DC_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DC_CASES")
public class DcCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseNum;
    private Integer appId;
    private Integer planId;
}
