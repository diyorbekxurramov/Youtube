package dasturlash.uz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String mainPhoto;
    private String fullName;
    private String role;
    private String status;
    private String createdDate;


}

/*private String Id;

    @NotBlank(message = "Isim bo'sh bo'lmasligi kerak")
    private String name;

    @NotBlank(message = "Familiya bo'sh bo'lmasligi kerak ")
    private String surname;

    @NotBlank(message = "Emal bo'sh bo'lmasligi kerak ")
    private String email;

    @NotBlank(message = "Rasim bo'sh bo'lmasligi kerak ")
    private String main_photo;

    @NotBlank(message = "Kod 8 ta belgidan bo'lmasligi kerak")
    private String password;
    private String role;
    private String status;*/
