package security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import security.entity.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

