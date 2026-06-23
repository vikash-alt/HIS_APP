package vikash.DC_API.binding;

import lombok.Data;
import java.util.List;

@Data
public class ChildRequest {
    private Long caseNum;
    private List<Child> children;
}
