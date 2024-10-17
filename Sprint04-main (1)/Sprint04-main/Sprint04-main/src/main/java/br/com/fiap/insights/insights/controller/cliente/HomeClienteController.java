package br.com.fiap.insights.insights.controller.cliente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeClienteController {

    @GetMapping("/homeCliente")
    public String home(){
        return "/cliente/clientehome";
    }

    @GetMapping("/homeLogin")
    public String home1() {
        return "login/loginhome";
    }
}
