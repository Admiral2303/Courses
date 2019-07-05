package com.gmail.vadimv41.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;


  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
    configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors().and().csrf().disable();

    http.authorizeRequests()//
            .antMatchers("/signin").permitAll()//
            .antMatchers("/signup").permitAll()//
            .anyRequest().authenticated();
    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
//    http.exceptionHandling().accessDeniedPage("/users");
//    // Optional, if you want to test the API from a browser
//     http.httpBasic();
  }


//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    // Allow swagger to be accessed without authentication
//    web.ignoring().antMatchers("/v2/api-docs")//
//        .antMatchers("/swagger-resources/**")//
//        .antMatchers("/swagger-ui.html")//
//        .antMatchers("/configuration/**")//
//        .antMatchers("/webjars/**")//
//        .antMatchers("/public")
//
//        // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
//        .and()
//        .ignoring()
//        .antMatchers("/h2-console/**/**");;
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

}



