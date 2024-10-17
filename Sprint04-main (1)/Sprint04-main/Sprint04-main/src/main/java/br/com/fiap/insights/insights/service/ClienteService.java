package br.com.fiap.insights.insights.service;

import br.com.fiap.insights.insights.model.Cliente;

import br.com.fiap.insights.insights.model.Role;
import br.com.fiap.insights.insights.repository.ClienteRepository;
import br.com.fiap.insights.insights.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RoleRepository roleRepository;


    public  void saveUser(String nome, String senha, List<String> roles) {
        Cliente user = new Cliente();
        user.setNome(nome);
        user.setSenha(senha);

        HashSet<Role> userRoles = new HashSet<>();
        for (String roleName : roles) {
            Role role = roleRepository.findByName(roleName);
            if (role != null) {
                userRoles.add(role);
            }
        }
        user.setRole(userRoles);
        clienteRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Cliente cliente = (Cliente) clienteRepository.findByNome(nome);
        if (cliente == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        Set<SimpleGrantedAuthority> authorities = cliente.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new User(
                cliente.getNome(),
                cliente.getSenha(),
                authorities);
    }

}
