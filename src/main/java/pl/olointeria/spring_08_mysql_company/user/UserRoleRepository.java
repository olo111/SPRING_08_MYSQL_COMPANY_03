package pl.olointeria.spring_08_mysql_company.user;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Optional<UserRole> findByName(String name);
}
