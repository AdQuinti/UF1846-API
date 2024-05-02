package com.dominio.Seguridad3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLoginPersonalizado {
	@GetMapping("/formularioLogin")
	public String muestraLoginpresonalizado() {
		return "loginPersonalizado";
	}
}
