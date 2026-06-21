package vikash.DC_API.binding;

import lombok.Data;

import java.util.List;

@Data
public class DcSummary {
    private Income income;
    private Education education;
    private List<Child> children;
    private String planName;
}
