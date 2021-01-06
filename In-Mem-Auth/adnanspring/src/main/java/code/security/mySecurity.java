package code.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class mySecurity extends WebSecurityConfigurerAdapter {




    // In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.

    //its also possible with Autowired, to autowire the bean AuthenticationManagerBuilder:
    //@Autowired
    //public void whatever_name(AuthenticationManagerBuilder auth) throws Exception {...}
    //@EnableWebSecurity is meta-annotated with @EnableGlobalAuthentication which  imports AuthenticationConfiguration where you'll see that an AuthenticationManagerBuilder bean is declared: @Bean public AuthenticationManagerBuilder authenticationManagerBuilder(
    //but if u override then:
    //you have 2 options: having one configuration class approach (in this case override configureGlobal()) or
    //specific configuration class for security approach in this case :...
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("adnan").password("{noop}1234").roles("USER");
        //noop is a password encoder
    }


}
