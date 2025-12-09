package br.faetec.com.aula.repository;

import br.faetec.com.aula.model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Pode criar métodos customizados aqui, se quiser
	
	
	List<Aluno> findByNomeAlunoContainingIgnoreCase(String nomeAluno);


	
}
