package br.com.dio.estacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//será configurado aqui a autenticação em memória
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication()
				.withUser("user")
				.password(passwordEnconder().encode("mmg@13579"))
				.roles("USER")
				.and()
				.passwordEncoder(passwordEnconder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http.csrf().disable().authorizeRequests()
        	.antMatchers("/swagger-ui.html").permitAll()
        	.antMatchers("/swagger-resources/**").permitAll()
        	.antMatchers("/webjars/**").permitAll()
        	.antMatchers("/v2/api-docs/**").permitAll()
        	.antMatchers("/").permitAll()
        	.antMatchers("/csrf").permitAll()
        	.antMatchers("/*.js").permitAll()
        	.antMatchers("/*.css").permitAll()
        	.antMatchers("/*.ico").permitAll()
        	.antMatchers("/*.png").permitAll()
        	.anyRequest().authenticated()
        	.and().httpBasic()
        	.and()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
}
