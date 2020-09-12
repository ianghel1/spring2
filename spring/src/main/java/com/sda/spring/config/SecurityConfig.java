package com.sda.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * IMPORTANT - daca vrem sa securizam HTTP-ul pe baza de roluri atunci nu vom mai atribui authorities,
     * altfel intra in conflict rolurile cu authorities.
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // CREATE ADMIN USER
                .withUser("admin")
                .password(passwordEncoder().encode("pass1"))
                .roles(String.valueOf(CustomUserRoleTypes.ADMIN) ,String.valueOf(CustomUserRoleTypes.USER) )
//                .authorities("READ", "WRITE")
                // CREATE SIMPLE USER
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("pass"))
                .roles(String.valueOf(CustomUserRoleTypes.USER));
//                .authorities("READ");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure all request

        /**
         * autorizam toate request-urile de la orice tip de user autentificat
         */
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

        /**
         * autorizam toate request-urile pe baza de rol
         */
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/companies/**").hasRole(String.valueOf(CustomUserRoleTypes.ADMIN))
                .anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and().httpBasic();


        /**
         * autorizam toate request-urile pe baza de authorities
         */
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/v1/employees/**").hasAnyAuthority("WRITE")
//                .antMatchers(HttpMethod.POST, "/api/v1/companies/**").hasAnyAuthority("WRITE")
//                .antMatchers(HttpMethod.GET, "/api/v1/employees/**").hasAnyAuthority("READ")
//                .antMatchers(HttpMethod.GET, "/api/v1/companies/**").hasAnyAuthority("READ")
//                .anyRequest().authenticated()
//                .and().httpBasic();


        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
