package com.project.authenticate.SecurityConfig;
import com.project.authenticate.filter.JwtFilter;
import com.project.authenticate.customAuthenticationProvider.*;
import com.project.authenticate.CustomerService;
import com.project.authenticate.JWTUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.project.authenticate.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                csrf(csrf -> csrf.disable()).
                authorizeHttpRequests(auth -> {
                    auth.requestMatchers( "/authenticate/login").permitAll();
                    and()
                    .anyRequest()
        .authenticated();


                }).
                logout(logout -> logout
                        .logoutUrl("/logout"))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling().and().sessionManagement()

                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .build();

        
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider();
        return customAuthenticationProvider;
    }

}