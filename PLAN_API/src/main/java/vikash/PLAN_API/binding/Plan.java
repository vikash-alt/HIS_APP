package vikash.PLAN_API.binding;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Plan {
    private Integer planId;
    private String planName;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private String activeSw;
    private Integer planCategoryID;
    private String createdBy;
    private String updatedBy;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
