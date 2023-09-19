package Student.Skill.Assessment.Security;

import Student.Skill.Assessment.Entity.User;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@NoArgsConstructor
public class UserPrinciple implements UserDetails {
    @Autowired
    private User user;

    public UserPrinciple(User user) {
        this.user = user;
    }

    public ObjectId getUserId(){
        return user.getId();
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActiveIndex();
    }
}
