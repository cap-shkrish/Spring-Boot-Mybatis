package Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
*/
@Configuration
//@EnableWebSecurity // only optional if you are overriding default behavior

public class SecurityConfig //extends WebSecurityConfigurerAdapter 
{


/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println("\n\n\n\n\n\nconfigure\n\n\n\n\n");
		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.POST, "/books").permitAll()
				.antMatchers(HttpMethod.POST, "/books/**").permitAll()
				.antMatchers(HttpMethod.GET, "/books").permitAll()
				.antMatchers(HttpMethod.GET, "/books/**").permitAll()
				.anyRequest().authenticated();
	}
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // Note: 
	        // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
	        // Note that the CSRf token is disabled for all requests (change it as you wish...)
	        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
*/
}