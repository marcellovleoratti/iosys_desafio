package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Usuario;

@Repository
public interface DesafioUsuario extends JpaRepository<Usuario, Long>{

	public List<Usuario> findByNome(String nome);
	public List<Usuario> findByTitulo(String titulo);
}
