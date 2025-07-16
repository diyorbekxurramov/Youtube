package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "visible", nullable = false)
    private Boolean visible = true;

    @Column(name = "tag_key")
    private String tagKey;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;


}
