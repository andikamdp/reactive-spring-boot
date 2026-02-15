package id.co.practice.reactivespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private BigInteger departmentId;
    private Date birthdate;
    private Boolean status;
}
