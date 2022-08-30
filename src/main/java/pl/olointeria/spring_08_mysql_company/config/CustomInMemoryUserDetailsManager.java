package pl.olointeria.spring_08_mysql_company.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.user.UserService;
import pl.olointeria.spring_08_mysql_company.user.dto.UserCredentialsDto;

import javax.annotation.PostConstruct;
@Service
class CustomInMemoryUserDetailsManager implements UserDetailsService {
    private final UserService userService;

    public CustomInMemoryUserDetailsManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .roles(credentials.getRoles().toArray(String[]::new))
                .build();
    }
}
//@Service
//class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {
//
//    @PostConstruct
//    public void initUsers() {
//        User.UserBuilder userBuilder = User.builder();
//        //superadmin / hard
//        String password1 = "{bcrypt}" + new BCryptPasswordEncoder().encode("hard");
//        System.out.println(password1);
//        UserDetails admin = userBuilder.username("superadmin").password(password1).roles("ADMIN").build();
//
//        //john / dog.8
//        String password2 = "{MD5}" + new MessageDigestPasswordEncoder("MD5").encode("dog.8");
//        System.out.println(password2);
//        UserDetails user1 = userBuilder.username("john").password(password2).roles("USER").build();
//
//        //java_lover / javaiscool
//        String password3 = "{argon2}" + new Argon2PasswordEncoder().encode("javaiscool");
//        System.out.println(password3);
//        UserDetails user2 = userBuilder.username("java_lover").password(password3).roles("USER").build();
//
//        createUser(admin);
//        createUser(user1);
//        createUser(user2);
//    }
//}
