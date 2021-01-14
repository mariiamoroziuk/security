package security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import security.entity.user.User;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class AnyController {
    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public String create() {
        return "created";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public String readAll() {
        return "get all";
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public String read() {
        return "get one";
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('developers:write')")
    public String update() {
        return "updated";
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public String delete() {
        return "deleted";
    }
}
