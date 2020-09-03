package practices.springsecurity.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import practices.registration.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUser implements UserDetails {

   private String userName;
   private String password;
   //private boolean active;
    private List<GrantedAuthority> authorities;

    public ApplicationUser(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        //this.active = user.isActive;
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return true;
    }


    //-------------------------------------------



    //    private final String username;
//    private final String password;
//    private final Set<? extends GrantedAuthority> grantedAuthorities;
//    private final boolean isAccountNonExpired;
//    private final boolean isAccountNonLocked;
//    private final boolean isCredentialsNonExpired;
//    private final boolean isEnabled;
//
//    public ApplicationUser(String username,
//                           String password,
//                           Set<? extends GrantedAuthority> grantedAuthorities,
//                           boolean isAccountNonExpired,
//                           boolean isAccountNonLocked,
//                           boolean isCredentialsNonExpired,
//                           boolean isEnabled) {
//        this.username = username;
//        this.password = password;
//        this.grantedAuthorities = grantedAuthorities;
//        this.isAccountNonExpired = isAccountNonExpired;
//        this.isAccountNonLocked = isAccountNonLocked;
//        this.isCredentialsNonExpired = isCredentialsNonExpired;
//        this.isEnabled = isEnabled;
//    }
//
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return grantedAuthorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isAccountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
}