package pl.olointeria.spring_08_mysql_company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/register", "/confirmation").permitAll()
                .mvcMatchers("/secured").hasRole("USER")
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().mvcMatchers(
                "/img/**",
                "/styles/**"
        );
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(requests -> requests
//                .mvcMatchers("/").permitAll()
//                .mvcMatchers("/secured").hasAnyRole("USER", "ADMIN")
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//        );
//        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().mvcMatchers(
//                "/img/**",
//                "/styles/**"
//        );
//    }
//}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(requests -> requests
//                .mvcMatchers("/").permitAll()
//                .mvcMatchers("/secured").hasAnyRole("USER", "ADMIN")
//                .anyRequest().authenticated()
//        );
//        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().mvcMatchers(
//                "/img/**",
//                "/styles/**"
//        );
//    }
//}

//@Configuration
//class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(requests -> requests
//                .mvcMatchers("/secured").hasAnyRole("USER", "ADMIN")
//                .anyRequest().authenticated()
//        );
//        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().mvcMatchers(
//                "/img/**",
//                "/styles/**"
//        );
//    }
//}
    ///*Co można przetłumaczyć tak:
//
//konfiguruj żądania, które wymagają uwierzytelnienia - authorizeRequests(),
//wszystkie żądania - anyRequest(),
//wymagają, aby użytkownik był uwierzytelniony - authenticated(),
//możemy zalogować się korzystając z formularza - formLogin(),
//albo wykorzystując metodę basic - httpBasic().
//Dzięki wywołaniu metody formLogin() do łańcucha filtrów dodawany jest m.in. filtr DefaultLoginPageGeneratingFilter obsługujący żądania GET wysyłane pod adres /login i odpowiedzialny za wygenerowanie domyślnego formularza.
//
//W najnowszych wersjach Springa za autoryzację domyślnie odpowiada filtr o nazwie FilterSecurityInterceptor, ale jest on wykorzystywany ze względu na utrzymanie kompatybilności wstecznej. Podczas definiowania własnej konfiguracji rekomendowane jest zarejestrowanie filtra o nazwie AuthorizationFilter, który zastąpi FilterSecurityInterceptor. W praktyce różnica jest taka, że w metodzie configure() zamiast metody:
//
//http.authorizeRequests(...);file_copy
//będziemy wywoływali:
//
//http.authorizeHttpRequests(...);file_copy
//Działaniem klasy AuthorizationFilter zajmiemy się w lekcji poświęconej autoryzacji.
//
//To, co chcemy teraz osiągnąć to efekt taki sam jak domyślny, ale z naszym własnym formularzem. Najpierw wskazujemy, że do obsługi każdego żądania wymagane jest uwierzytelnienie:
//
//http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());file_copy
//Wskazujemy też, że logowanie ma się odbywać z wykorzystaniem formularza. Formularz znajduje się pod adresem /login, do którego dostęp ma każdy, nawet nieuwierzytelniony użytkownik:
//
//http.formLogin(login -> login.loginPage("/login").permitAll());*/

