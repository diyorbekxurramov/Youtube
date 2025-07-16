package dasturlash.uz.dto;

import dasturlash.uz.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtDTO {
    private String username;
    private List<ProfileRole> roles;
    private Integer code;

    public JwtDTO() {

    }

    public JwtDTO(String username, List<ProfileRole> roles) {
        this.username = username;
        this.roles = roles;
    }
}
