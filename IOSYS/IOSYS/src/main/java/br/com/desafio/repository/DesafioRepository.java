package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.desafio.model.Desafio;
import br.com.desafio.model.Titulo;

import java.util.List;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Long>{
	
	public List<Desafio> findByNomeFilme(String filme);
	public List<Desafio> findByAtor(String ator);
	public List<Desafio> findByDiretorFilme(String diretor);
	public List<Desafio> findByGenero (String genero);
	public List<Desafio> findByTitulo(Titulo titulo);
	
}
