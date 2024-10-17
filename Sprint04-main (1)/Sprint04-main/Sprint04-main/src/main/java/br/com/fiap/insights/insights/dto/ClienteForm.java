package br.com.fiap.insights.insights.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteForm {

    private String username;
    private String password;
    private List<String> roles;
}
