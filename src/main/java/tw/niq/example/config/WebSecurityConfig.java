package tw.niq.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import tw.niq.example.security.KeyclockRoleConverter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyclockRoleConverter());
		
		http
			.authorizeHttpRequests(authorizeHttpRequests -> 
				authorizeHttpRequests
					.anyRequest().authenticated())
			.oauth2ResourceServer(oauth2ResourceServer -> 
				oauth2ResourceServer
					.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));
		
		return http.build();
	}
	
}
