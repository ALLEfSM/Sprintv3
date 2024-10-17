package br.com.fiap.insights.insights.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="CLIENTE")
public class Cliente  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cliente_id")
    private Long id;

    @NotBlank
    @Size(min=3)
    @Column(name="nome")
    private String nome;

    @NotNull
    @CPF
    @Column(name = "clie_cpf", unique=true)
    private String cpf;

    @Past
    @NotNull
    @Column(name = "clie_nascimento")
    private LocalDate dataNascimento;

    @Email
    @NotBlank
    @Column(name="email")
    private String email;

    @NotBlank
    @Size(min=3 ,max=8)
    @Column(name="senha")
    private String senha;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Opiniao> opiniaoList;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Produto> produtoList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cliente_roles",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public void setRole(HashSet<Role> userRoles) {
    }
}

