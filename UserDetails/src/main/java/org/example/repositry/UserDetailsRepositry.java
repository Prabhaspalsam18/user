package org.example.repositry;

import org.example.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDetailsRepositry extends JpaRepository<UserDetails, Long> {

}
