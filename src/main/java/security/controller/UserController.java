package security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.entity.user.User;
import security.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u) {
        return ResponseEntity.ok(service.create(u));
    }

    @GetMapping
    public List<User> readAll() {
        return service.readAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
