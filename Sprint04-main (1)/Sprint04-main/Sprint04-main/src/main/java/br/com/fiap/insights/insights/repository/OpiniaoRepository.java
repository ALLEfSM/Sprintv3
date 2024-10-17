package br.com.fiap.insights.insights.repository;


import br.com.fiap.insights.insights.model.Opiniao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao, Long> {

    List<Opiniao> findByComentarioContaining(String comentario);
    
}
