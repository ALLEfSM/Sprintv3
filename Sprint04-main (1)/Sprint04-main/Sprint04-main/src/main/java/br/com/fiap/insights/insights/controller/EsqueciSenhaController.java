package br.com.fiap.insights.insights.controller;

import br.com.fiap.insights.insights.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EsqueciSenhaController {

    @Autowired
    private ClienteRepository loginRepository;

    @GetMapping("/esqueci-senha")
    public String mostrarFormularioEsqueciSenha(Model model) {
        model.addAttribute("username", "");
        return "login/esqueci-senha";
    }

    @PostMapping("/esqueci-senha")
    public String enviarEmailRecuperacao(String nome, Model model) {
        model.addAttribute("message", "Instruções de recuperação de senha foram enviadas para " + nome);
        return "login/esqueci-senha";
    }
}
