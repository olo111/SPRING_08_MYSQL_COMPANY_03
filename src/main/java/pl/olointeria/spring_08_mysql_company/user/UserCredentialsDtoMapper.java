package pl.olointeria.spring_08_mysql_company.user;

import pl.olointeria.spring_08_mysql_company.user.dto.UserCredentialsDto;
import pl.olointeria.spring_08_mysql_company.user.User;
import java.util.Set;
import java.util.stream.Collectors;

class UserCredentialsDtoMapper {
    static UserCredentialsDto map(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(email, password, roles);
    }
}

