package com.bonappetit.repo;

import com.bonappetit.model.entity.User;
import com.bonappetit.service.session.LoggedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
 Optional<User> findByUsernameOrId(String username, Long id);

    boolean existsByUsernameOrEmail(String username, String email);
}
