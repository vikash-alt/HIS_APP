package vikash.DC_API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DC_INCOME")
public class DcIncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeId;
    private Long caseNum;
    private Double empIncome;
    private Double propertyIncome;
}
