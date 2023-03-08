package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDataMongo {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private long mobile_number;
    private String address;
}
