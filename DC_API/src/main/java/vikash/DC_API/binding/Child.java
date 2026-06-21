package vikash.DC_API.binding;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Child {
    private Integer childId;
    private Long caseNum;
    private LocalDate childDOB;
    private Long childSSN;
}
