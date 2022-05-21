package pl.olointeria.spring_08_mysql_company.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSCPS;

import java.util.ArrayList;
import java.util.List;

public interface ComponentPSCPSRepository extends JpaRepository<ComponentPSCPS, Long> {

}
