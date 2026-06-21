package vikash.DC_API.binding;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenApps {
    private String fullName;
    private String email;
    private Long phNo;
    private Long ssn;
    private String gender;
    private LocalDate dob;
}

