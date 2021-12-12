package com.semo.kvokka.config;

import com.semo.kvokka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/login", "/api/register", "/api/logout").permitAll()
                .antMatchers("/api").hasRole("USER")
                .anyRequest().authenticated();
        http.formLogin()
                .loginProcessingUrl("/api/login")
                .successHandler((req, res, ex) -> res.setStatus(200))
                .failureHandler((req, res, ex) -> res.setStatus(401));
        http.logout()
                .logoutUrl("/api/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler((req, res, authentication) -> res.setStatus(200));
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("unknown username"));
    }
}
