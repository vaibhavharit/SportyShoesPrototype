package com.api.sporty.config;

import java.io.Console;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
// ALLOWING ADMIN TO SET UP OWN ID PASSWORD IN CONSOLE: 	
	private static final Logger log = LogManager.getLogger();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Disabling CSRF, enabling basic authentication...");
        http
        .authorizeRequests()
            .antMatchers("/**").authenticated() // These urls are allowed by any authenticated user
        .and()
            .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        log.info("Setting in-memory security using the user input...");

        String username = null;
        String password = null;

        System.out.println("\nPlease set the Admin credentials to use this web application. It will be required when browsing to the web application.");
        Console console = System.console();

        if (console == null) {
            // Using scanner:
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Username: ");
                username = scanner.nextLine();
                System.out.print("Password: ");
                password = scanner.nextLine();
                System.out.print("Confirm Password: ");
                String inputPasswordConfirm = scanner.nextLine();

                if (username.isEmpty()) {
                    System.out.println("Error: User must be set. Please try again");
                } else if (password.isEmpty()) {
                    System.out.println("Error: Password must be set. Please try again");
                } else if (!password.equals(inputPasswordConfirm)) {
                    System.out.println("Error: Passwords do not match. Please try again");
                } else {
                    log.info("Setting the in-memory Security using the provided credentials...");
                    break;
                }
                System.out.println("");
            }
            scanner.close();
        } 
        // Using Console
        else {
            while (true) {
                username = console.readLine("Username: ");
                char[] passwordChars = console.readPassword("Password: ");
                password = String.valueOf(passwordChars);
                char[] passwordConfirmChars = console.readPassword("Confirm Password: ");
                String passwordConfirm = String.valueOf(passwordConfirmChars);

                if (username.isEmpty()) {
                    System.out.println("Error: Username must be set. Please try again");
                } else if (password.isEmpty()) {
                    System.out.println("Error: Password must be set. Please try again");
                } else if (!password.equals(passwordConfirm)) {
                    System.out.println("Error: Passwords do not match. Please try again");
                } else {
                    log.info("Setting the in-memory security using the provided credentials...");
                    break;
                }
                System.out.println("");
            }
        }

        // Set the inMemoryAuthentication object with the given credentials:
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        if (username != null && password != null) {
            String encodedPassword = passwordEncoder().encode(password);
            manager.createUser(User.withUsername(username).password(encodedPassword).roles("USER").build());
        }
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
