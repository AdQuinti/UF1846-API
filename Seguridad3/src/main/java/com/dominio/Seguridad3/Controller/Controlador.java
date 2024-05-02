package com.dominio.Seguridad3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
//método para mapear el archivo que debe devolver
	@GetMapping("/")
	public String mostarInicio(){
		return"inicio";
	}
	//mapeo a zona de administradores
	@GetMapping("/administradores")
	public String mostarZonaAdministradores(){
		return"zonaAdministradores";//esta será nuestra página jsp de administradores
	}
	//mapeo a zona de profesores
		@GetMapping("/profesores")//contextPath
		public String mostarZonaProfesores(){
			return"profesores";//esta será nuestra página jsp profesores.jsp
		}
	//mapeo a error
	@GetMapping("/error")
	public String mostarError(){
		return"error";//esta será nuestra página de error
	}
}
