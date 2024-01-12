package example.cashcard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // use this class to configure Spring and Spring Boot itself
public class SecurityConfig {

    @Bean // Spring Security expects a Bean to configure its Filter Chain
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/cashcards/**")
                        .hasRole("CARD-OWNER")) // enable RBAC
                        // Replace .authenticated()) // All HTTP requests to cashcards/ endpoints are required to be authenticated
                                          // using HTTP Basic Authentication security (username and password).
                // CSRF, or "sea-surf"
                // is an important aspect of HTTP-based APIs used by web-based applications.
                // If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection.
                // when to use csrf protection : https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/csrf.html#when-to-use-csrf-protection
                .csrf(csrf -> csrf.disable()) // do not require CSRF security.
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // UserDetailsService for only test
    @Bean
    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder();
        UserDetails sarah = users
                .username("sarah1")
                .password(passwordEncoder.encode("abc123"))
                .roles("CARD-OWNER") // implement Role-Based Access Control (RBAC)
                .build();
        UserDetails hankOwnsNoCards = users
                .username("hank-owns-no-cards")
                .password(passwordEncoder.encode("qrs456"))
                .roles("NON-OWNER")
                .build();
        return new InMemoryUserDetailsManager(sarah, hankOwnsNoCards);
    }

}
