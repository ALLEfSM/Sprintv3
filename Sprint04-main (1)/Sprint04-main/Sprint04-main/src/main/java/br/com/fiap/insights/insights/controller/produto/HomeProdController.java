package br.com.fiap.insights.insights.controller.produto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeProdController {

    @GetMapping("/homeProduto")
    public String home(){
        return "produto/prodhome";
    }
}
