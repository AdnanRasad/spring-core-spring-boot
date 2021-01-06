package code.security;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class mySecurity extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/home").access("hasRole('USER')")
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }

    // In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.

    //its also possible with Autowired, to autowire the bean AuthenticationManagerBuilder:
    //@Autowired
    //public void whatever_name(AuthenticationManagerBuilder auth) throws Exception {...}
    //@EnableWebSecurity is meta-annotated with @EnableGlobalAuthentication which  imports AuthenticationConfiguration where you'll see that an AuthenticationManagerBuilder bean is declared: @Bean public AuthenticationManagerBuilder authenticationManagerBuilder(
    //but if u override then:
    //you have 2 options: having one configuration class approach (in this case override configureGlobal()) or
    //specific configuration class for security approach in this case :...


    @Autowired
    private DataSource dataSource; //to do this we need spring-boot-starter-data-jpa and put the url username, password in application.properties

    /*if we wouldnot autowire DataSource bean, then we had to do :

    4 packages of jdbc helps: core (JdbcTemplate), datasource (DriverManagerDataSource), object, support
    @Bean
    public DataSource myDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

     */
   /*Some methods to query using jdbc
   JdbcTemplate jT =  new JdbcTemplate();
   int result = jT.queryForObject("", model.class);
   jT.update("INSERT INTO BLA BLA..");
   when having parameters:
   SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("myid" , 1);
   jT.queryForObject ("bla bla where id = :id",namedParameter, model.class );
   */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

        //to have your own search queries:
        /*
        * use .usersByUsernameQuery() and .authoritiesByUsernameQuery();
        * */

        //noop is a password encoder
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }



}
