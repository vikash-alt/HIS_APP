package vikash.DC_API.binding;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class PlanDTO {
    private String planName;
    private Integer planId;

    public PlanDTO (String name, Integer id) {
        this.planName = name;
        this.planId = id;
    }
}
