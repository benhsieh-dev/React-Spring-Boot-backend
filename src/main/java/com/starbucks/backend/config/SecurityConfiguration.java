package com.starbucks.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
//    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
      private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("root").password(passwordEncoder().encode("password123")).authorities("USER", "ADMIN");
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private final UserAuthProvider userAuthProvider;


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().anyRequest().permitAll();
        http
//                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
//                .and()
                .addFilterBefore(new JwtAuthFilter(), BasicAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
//                        .anyRequest().authenticated());
        return   http
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll()
                .and().build();

//        http.authorizeRequests().anyRequest().authenticated();
//        http.formLogin();
    }


}
