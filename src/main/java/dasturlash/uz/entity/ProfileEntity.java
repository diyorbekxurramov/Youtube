package dasturlash.uz.entity;

import dasturlash.uz.enums.ProfileRole;
import dasturlash.uz.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "main_photo", length = 500)
    private String mainPhoto;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "verification_token", length = 255)
    private String verificationToken;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "token_expiry_date")
    private LocalDateTime tokenExpiryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProfileStatus status = ProfileStatus.ACTIVE;

    @OneToMany(mappedBy = "profile")
    private List<ProfileRoleEntity> roleList;

    @Column(name = "visible", nullable = false)
    private Boolean visible = true;


    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    public String getFullName() {
        return name + " " + surname;
    }
}

/*private String name;
    private String surname;
    private String email;
    private String mainPhoto; // URL sifatida

    private boolean isVerified = false;

    private String verificationToken;
    private LocalDateTime tokenExpiry;

    private LocalDateTime createdAt;
* */



