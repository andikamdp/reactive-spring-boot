package id.co.practice.reactivespringboot.model;

import com.github.f4b6a3.uuid.UuidCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "reactive_db", name = "tbl_users_tm")
public class UserEntity implements Persistable<UUID> {

    @Id
    private UUID id;
    private String username;
    private String password;
    private BigInteger departmentId;
    private LocalDate birthdate;
    private ZonedDateTime lastLoginDate;
    private Boolean status;

    @Version
    private Integer version;

    @Transient
    @Builder.Default
    private boolean isNew = false;

    @Override
    public boolean isNew() {
        return isNew || id == null;
    }

    // Helper method to generate ID before saving
    public void generateId() {
        if (this.id == null) {
            this.id = UuidCreator.getTimeOrderedEpoch();
            this.isNew = true;
        }
    }
}
