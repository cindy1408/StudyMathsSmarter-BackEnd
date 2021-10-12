package com.StudyMathsSmarter.StudyMathsSmarter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.StudyMathsSmarter.StudyMathsSmarter.security.AppUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/", "/study_maths_smarter/quiz/start", "/study_maths_smarter/quiz/{\\d+}",
                        "study_maths_smarter/user/rank").permitAll()
                .antMatchers("/study_maths_smarter/question").hasRole(ADMIN.name())
                .antMatchers("/study_maths_smarter/user").hasRole(ADMIN.name())
                .antMatchers("/study_maths_smarter/user/{\\d+}").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/study_maths_smarter/quiz/start");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails yulinUser = User.builder()
                .username("admin@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMIN.name())
                .build();

        UserDetails studentUser = User.builder()
                .username("student@gmail.com")
                .password(passwordEncoder.encode("student"))
                .roles(STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(
                yulinUser,
                studentUser
        );
    }
}
