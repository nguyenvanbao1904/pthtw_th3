package com.nvb.configs;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import com.cloudinary.Cloudinary;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.nvb.controllers",
        "com.nvb.repositories",
        "com.nvb.services"
})
public class SpringSecurityConfigs {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/").authenticated()
                        .requestMatchers("/products/**").authenticated()
                        .requestMatchers("/add").authenticated()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/api/**").permitAll())
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true").permitAll())
        .logout(logout -> logout.logoutUrl("/logout").permitAll());

        return http.build();
    }

    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dxcux00kk",
                "api_key", "251671149248596",
                "api_secret", "DnT4qIXRKdXBh5qtbh4Sh6qMVoo",
                "secure", true));
        return cloudinary;
    }
}
