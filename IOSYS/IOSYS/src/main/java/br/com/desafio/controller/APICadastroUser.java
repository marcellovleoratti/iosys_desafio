package br.com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.Usuario;
import br.com.desafio.repository.DesafioUsuario;

@RestController
@RequestMapping("/api/usuario")
public class APICadastroUser {
	
	@Autowired
	DesafioUsuario user;
	
	@PostMapping()
	public void getCadastarUsuario(@RequestBody Usuario usuario) {
		user.save(usuario);
	}
	
	@GetMapping("/{usuario}")
	public List<Usuario> ListarAtor(String usuario){
		return user.findByNome(usuario);
	}
}
