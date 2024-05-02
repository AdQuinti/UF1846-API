package com.dominio.Seguridad3.Config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.dominio.Seguridad3") 
@PropertySource("classpath:persistencia-mysql.properties")
public class App 
{
	@Autowired
	private Environment environment;
	
	//Sistema de log de errores
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//definir un método para seguridad
	@Bean
	public DataSource seguridadDataSource(){
		//crear el pool de conexiones
		ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();
		//establecer el driver JDBC
		try {
			seguridadDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// log de propiedades de conexión
		logger.info("URL de la BBDD: " + environment.getProperty("jdbc.url"));
		logger.info("Usuario conectado a BBDD: " + environment.getProperty("jdbc.user"));
		
		//conexión a BBDD: url, usuario y contraseña del la BBDD
		seguridadDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		seguridadDataSource.setUser(environment.getProperty("jdbc.user"));
		seguridadDataSource.setPassword(environment.getProperty("jdbc.password"));
		
		//pool de conexiones
		seguridadDataSource.setInitialPoolSize(getpropiedadesPool("connection.pool.initialPoolSize"));
		seguridadDataSource.setMinPoolSize(getpropiedadesPool("connection.pool.minPoolSize"));
		seguridadDataSource.setMaxPoolSize(getpropiedadesPool("connection.pool.maxPoolSize"));
		seguridadDataSource.setMaxIdleTime(getpropiedadesPool("connection.pool.maxIdleTime"));
		
		return seguridadDataSource;
	}
	
	//metodo que pasa de string a int el valor de las propiedades del pool
	private int getpropiedadesPool(String nombreProp){
		String propiedadesPoll = environment.getProperty(nombreProp); 
		int propiedadIntPool = Integer.parseInt(propiedadesPoll);
		
		return propiedadIntPool;
	}
	
   @Bean
   public ViewResolver viewResolver(){
	  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	  
	  viewResolver.setPrefix("/WEB-INF/view/");
	  
	  viewResolver.setSuffix(".jsp");
	  
	  viewResolver.setViewClass(JstlView.class); //para vincular archivo hoja de style
	  
	  return viewResolver;
   }
   // para estilo CSS
   @Configuration
   public class WebConfig implements WebMvcConfigurer {

       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/css/**").addResourceLocations("/css/");
       }
   
   }

}
