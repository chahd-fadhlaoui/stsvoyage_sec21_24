package com.chahd.voyage.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .csrf(csrf -> csrf.disable())
            
        	.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
        		@Override
        		public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        		CorsConfiguration cors = new CorsConfiguration();
        		cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        		cors.setAllowedMethods(Collections.singletonList("*"));
        		cors.setAllowedHeaders(Collections.singletonList("*"));
        		cors.setExposedHeaders(Collections.singletonList("Authorization"));
        		return cors;
        		}
        		}))
        		
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/voyage/api/all/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/voyage/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.PUT, "/voyage/api/updatevoya/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/voyage/api/delvoya/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/voyage/api/addvoya/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
