package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDataRequest {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private long mobile_number;
    private String address;
}
