package com.dominio.Seguridad3.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource seguridadDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*UserBuilder usuarios = User.withDefaultPasswordEncoder();
		//Crearemos los usuarios
		auth.inMemoryAuthentication().withUser(usuarios.username("Maria").password("123").roles("alumno", "administrador"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Juan").password("456").roles("alumno", "profesor"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Jesús").password("789").roles("alumno"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Darío").password("000").roles("alumno"));*/
		
		auth.jdbcAuthentication().dataSource(seguridadDataSource);
	}
	//MÉTODO PARA MOSTRAR EL FORMULARIO ANTE UN REQUEST NO AUTENTICADO
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//http.authorizeRequests().anyRequest().authenticated().and().formLogin()
			http.authorizeRequests()
			.antMatchers("/css/**").permitAll() // Permitir el acceso a los archivos CSS
			.antMatchers("/").hasRole("alumno")
			.antMatchers("/administradores/**").hasRole("administrador")
			.antMatchers("/profesores/**").hasRole("profesor")
			.and().formLogin()
			.loginPage("/formularioLogin")
			.loginProcessingUrl("/autenticacionUsuario")
			.permitAll()
			//configuración del logout
			.and().logout().permitAll()
			.and().exceptionHandling().accessDeniedPage("/error");
		}
}
