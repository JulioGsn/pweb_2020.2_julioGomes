package br.com.juliogs.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.juliogs.agropopshop.model.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}
