package dasturlash.uz.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter

public class CategoryDTO {
    private String id;
    private String categoryKey;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private LocalDateTime createdDate;
}
