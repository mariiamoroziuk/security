package security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import security.entity.user.User;
import security.repo.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    public User create(User u) {
        return repo.save(u);
    }

    public User read(Long id) {
        return repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<User> readAll() {
        return repo.findAll();
    }

    public Long delete(Long id) {
        repo.deleteById(id);
        return id;
    }
}

