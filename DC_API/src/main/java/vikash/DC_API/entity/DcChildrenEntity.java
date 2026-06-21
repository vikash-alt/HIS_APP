package vikash.DC_API.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "DC_CHILDREN")
@Data
public class DcChildrenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer childId;
    private Long caseNum;
    private LocalDate childDOB;
    private Long childSSN;
}
