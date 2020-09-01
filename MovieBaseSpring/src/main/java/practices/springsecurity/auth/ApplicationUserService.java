package practices.springsecurity.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practices.registration.model.User;
import practices.registration.repository.UserRepository;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final practices.springsecurity.auth.ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(@Qualifier("proper") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(ApplicationUser::new).get();
    }
}