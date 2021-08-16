package br.com.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.Desafio;
import br.com.desafio.model.Titulo;
import br.com.desafio.repository.DesafioRepository;

@RestController
@RequestMapping("/api/desafio")
public class APIDesafioController {
	
	@Autowired
	DesafioRepository desafioRepository;
	
	@GetMapping()
	public Titulo[] listarTitulo() {
		return Titulo.values();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Desafio getDesafioById(@PathVariable Long id) {
		
		Optional<Desafio> desafio = desafioRepository.findById(id);
		
		return desafio.get();
	}
	
	@GetMapping("/{diretor}")
	public List<Desafio> ListarDiretor(String diretor){
		return desafioRepository.findByDiretorFilme(diretor);
	}
	
	
	@GetMapping("/{nome}")
	public List<Desafio> ListarNomeFilme(String nome){
		return desafioRepository.findByNomeFilme(nome);
	}
	
	@GetMapping("/{genero}")
	public List<Desafio> ListarFilmePorGenereo(String genero){
		return desafioRepository.findByGenero(genero);
	}
	
	@GetMapping("/{ator}")
	public List<Desafio> ListarAtor(String ator){
		return desafioRepository.findByAtor(ator);
	}
	
	@PostMapping()
	public void desafio(@RequestBody Desafio desafio) {
		desafioRepository.save(desafio);
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Desafio desafio, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        desafio.setId(id);
	        return "update-user";
	    }
	        
	    desafioRepository.save(desafio);
	    return "redirect:/index";
	}
	
	
	@PostMapping()
	public void desafioDelete(long id) {
		desafioRepository.deleteById(id);
	}
	
	@GetMapping("/titulo/{titulo}")
	public List<Desafio> getDesafioPorTitulo(@PathVariable Titulo titulo){
		
		List<Desafio> desafio = desafioRepository.findByTitulo(titulo);
		return desafio;
	}
	
	
}
