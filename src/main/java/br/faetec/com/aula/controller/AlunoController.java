package br.faetec.com.aula.controller;

import br.faetec.com.aula.model.Aluno;

import java.util.List;

import br.faetec.com.aula.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	private final AlunoRepository alunoRepository;

	public AlunoController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@GetMapping("/novo")
	public String novoAlunoForm(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "alunos/novo";
	}

	@PostMapping("/salvar")
	public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		aluno.setCreatedAt(LocalDateTime.now());
		alunoRepository.save(aluno);
		return "redirect:/alunos/novo";
	}

	@GetMapping
	public String listarAlunos(Model model) {
		List<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("alunos", alunos);
		return "alunos/listar";
	}

	@GetMapping("/alunos")
	public String listarAlunos0(Model model) {
		List<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("alunos", alunos);
		return "alunos/listar"; // HTML: templates/alunos/listar.html
	}

	@GetMapping("/editar/{id}")
	public String editarAluno(@PathVariable Long id, Model model) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
		model.addAttribute("aluno", aluno);
		return "alunos/novo"; // Reutiliza o formulário de criação
	}

	@PostMapping("/deletar/{id}")
	public String deletarAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
		return "redirect:/alunos/alunos"; // Atualiza a listagem
	}

	 // Mostra o formulário
    @GetMapping("/pesquisarpessoa")
    public String formPesquisa() {
        return "alunos/pesquisar";
    }

    // Processa a pesquisa e mostra o resultado
    @GetMapping("/resultado")
    public String resultadoPesquisa(@RequestParam("nome") String nome, Model model) {
        List<Aluno> alunos = alunoRepository.findByNomeAlunoContainingIgnoreCase(nome);
        model.addAttribute("alunos", alunos);
        model.addAttribute("nomePesquisado", nome);
        return "alunos/resultado";
    }
	
	

}
