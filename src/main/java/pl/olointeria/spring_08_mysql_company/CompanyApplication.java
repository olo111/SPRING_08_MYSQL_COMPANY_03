package pl.olointeria.spring_08_mysql_company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
//        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//        Employee2 employee21 = new Employee2("Main1", "Kowalski", 3000.0);
//        Employee2 employee2 = new Employee2("Main2", "Zalewska", 4000.0);
//        employeeRepository.save(employee21);
//        employeeRepository.save(employee2);
//
//
//
new Scanner(System.in).nextLine(); // po to, aby program zakończył swoje działanie dopiero po wciśnięciu entera.
    }

}
