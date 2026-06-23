package vikash.DC_API.binding;

import lombok.Data;
import java.util.List;

@Data
public class CreateCaseResponse {
    private Boolean status;
    private String message;
    private Long caseNum;
    private List<PlanDTO> allPlans;
}
