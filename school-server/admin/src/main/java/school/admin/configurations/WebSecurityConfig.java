package school.admin.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomAuthProvider authProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/user").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authProvider)
                .httpBasic();
        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.authenticationProvider(authProvider);
//        return authenticationManagerBuilder.build();
//    }
}
