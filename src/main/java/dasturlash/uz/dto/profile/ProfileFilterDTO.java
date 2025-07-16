package dasturlash.uz.dto.profile;

import dasturlash.uz.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileFilterDTO {
    private String query; // name, surname, username
    private ProfileRole role;
    private LocalDate createdDateFrom;
    private LocalDate createdDateTo;
}
