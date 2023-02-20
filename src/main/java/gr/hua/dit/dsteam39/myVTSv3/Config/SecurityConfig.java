package gr.hua.dit.dsteam39.myVTSv3.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {

        UserDetails seller = User.withUsername("seller")
                .password(passwordEncoder.encode("sellerpwd"))
                .roles("SELLER")
                .build();

        UserDetails buyer = User.withUsername("buyer")
                .password(passwordEncoder.encode("buyerpwd"))
                .roles("BUYER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("adminpwd"))
                .roles("BUYER", "SELLER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(seller, buyer, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/offices").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/notification").hasRole("BUYER")
                .antMatchers("/sell").hasRole("SELLER")
                .antMatchers("/cars/**").permitAll()
                .antMatchers("/mycar").hasRole("SELLER")
                .antMatchers("/buyers/**").hasRole("ADMIN")
                .antMatchers("/sellers/**").hasRole("ADMIN")
                .antMatchers("/adminpanel/**").hasRole("ADMIN")
                .antMatchers("/profile").hasAnyRole("BUYER", "SELLER", "ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll().logoutSuccessUrl("/");

        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    //Exclude FrontEnd files
   @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/static/**","/css/**", "/image/**", "/js/**");
    }


        // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

}
