package ua.com.kneu.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kneu.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
        http.authenticationManager(authManagerBuilder.build());


        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorise) ->
                        authorise
                                .requestMatchers("/", "registration", "/registration*", "/registration/**")
                                .permitAll()
                                .requestMatchers("/user", "/user*", "/user/**")
                                .hasRole("user")
                                .requestMatchers("/admin", "/admin*", "/admin/**")
                                .hasRole("admin")
                                .anyRequest().authenticated()
                )
                .formLogin((form) ->
                        form
                                .loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/")
                )
                .logout((logout) ->
                        logout
                                .permitAll()
                                .logoutSuccessUrl("/"));
        return http.build();
    }
}