package security.entity.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Set.*;

public enum Role {
    USER(Set.of(Permission.DEVELOPERS_READ)),
    MANAGER(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
