package by.itacademy.config;

import by.itacademy.aspect.Log;
import by.itacademy.impl.UserServiceImpl;
import by.itacademy.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@EnableAspectJAutoProxy
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userServiceImpl;

    @Autowired
    public SecurityConfig(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        //http.addFilterAfter(filter, CsrfFilter.class);
        http.addFilterBefore(filter, CsrfFilter.class);

        http
                .authorizeRequests()
                .antMatchers("/Login").anonymous()
                .antMatchers("/Admin").hasAuthority("MODERATOR")
                .antMatchers("/registration", "/", "/firstPage").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/Login")
                .loginProcessingUrl("/customUrl")
                .defaultSuccessUrl("/UserPage", true)
                .usernameParameter("login")
                .passwordParameter("pass")
                .and()
                .userDetailsService(userServiceImpl);

        http
                .logout()
                //.logoutUrl("/logout")
                //.permitAll()
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true)
                .deleteCookies();
               // .and()
               // .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
