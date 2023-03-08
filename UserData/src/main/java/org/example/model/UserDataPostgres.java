package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDataPostgres {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String  id;
    private String first_name;
    private String last_name;
    private String email;
    private long mobile_number;
    private String address;
}
