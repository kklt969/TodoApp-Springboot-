package com.webapp.webapp_kklt.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {


	@Bean
	public InMemoryUserDetailsManager createUserDetailManager() {

		UserDetails userDetails1 = createNewUser("koko", "123");
		UserDetails userDetails2 = createNewUser("lee", "2323");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);

	}

	private UserDetails createNewUser(String username, String password) {

		UserDetails userDetails = User.builder()
				.username(username)
				.password(passwordEncoder().encode(password))
				.roles("USER", "ADMIN")
				.build();
		return userDetails;

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		http.formLogin(withDefaults());


		/*

		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login", "/error").permitAll()  // Allow login page and error page
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/welcome", true) // Redirect to welcome after login
						.failureUrl("/login?error=true")
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login?logout=true")
						.permitAll()
				)
				.exceptionHandling(ex -> ex.accessDeniedPage("/error")); // Handle access denial

		return http.build();
	}*/
		return http.build();

	}
}
