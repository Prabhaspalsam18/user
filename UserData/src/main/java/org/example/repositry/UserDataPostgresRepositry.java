package org.example.repositry;
import org.example.model.UserDataPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDataPostgresRepositry extends JpaRepository<UserDataPostgres, String> {
}
