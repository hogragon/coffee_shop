package edu.mum.coffee.config;

import edu.mum.coffee.controller.RestURIConstant;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {
        webSecurity
            .ignoring()
                // All of Spring Security will ignore the requests
                .antMatchers("/person/public/**","/product/public/**");
                
    }
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http            
            .authorizeRequests()
                .antMatchers("/", "/home", "/index","/registerUser","/createNewUser").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.permitAll()
                .successHandler(new LoginSuccessHandler())
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/")
                .permitAll();
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
                auth.userDetailsService(inMemoryUserDetailsManager());
	}
        
        @Bean
        public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
            final Properties users = new Properties();
            users.put("super","pw,ADMIN,enabled"); //add whatever other user you need
            return new InMemoryUserDetailsManager(users);
        }
        
        

}