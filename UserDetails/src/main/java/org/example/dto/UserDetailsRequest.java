package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDetailsRequest {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String zip_code;
        private String email;

}
