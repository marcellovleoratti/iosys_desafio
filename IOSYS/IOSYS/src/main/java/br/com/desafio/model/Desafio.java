package br.com.desafio.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;



@Entity
public class Desafio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotEmpty(message = "O titulo do Filme deve ser Digitado")
	private String titulo_filme;
	
	@NotEmpty(message = "O Genero do FIlme deve ser Digitado")
	private String genero_filme;
	
	@NotNull(message = "A duração do do FIlme deve ser Informada")
	@NumberFormat(pattern="#,##0.00")
	@DecimalMin(value="0.45", message="Valor minimo deve ser maior ou igual")
	private BigDecimal duracao;
	
	@NotEmpty(message="Os nomes dos Atores devem ser digitados")
	private String atores;
	
	@NotEmpty(message="Os nomes dos Diretores dos Filmes devem ser Digitados")
	private String diretores_filme;
	
	@ManyToOne
	private Usuario id_usuario;
	
	private String observacoes;
	
	public Desafio(Long id, @NotEmpty(message = "O titulo do Filme deve ser Digitado") String titulo_filme,
			@NotEmpty(message = "O Genero do FIlme deve ser Digitado") String genero_filme,
			@NotNull(message = "A duração do do FIlme deve ser Informada") @DecimalMin(value = "0.45", message = "Valor minimo deve ser maior ou igual") BigDecimal duracao,
			@NotEmpty(message = "Os nomes dos Atores devem ser digitados") String atores,
			@NotEmpty(message = "Os nomes dos Diretores dos Filmes devem ser Digitados") String diretores_filme,
			Usuario id_usuario, String observacoes) {
		super();
		this.id = id;
		this.titulo_filme = titulo_filme;
		this.genero_filme = genero_filme;
		this.duracao = duracao;
		this.atores = atores;
		this.diretores_filme = diretores_filme;
		this.id_usuario = id_usuario;
		this.observacoes = observacoes;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitulo_filme() {
		return titulo_filme;
	}



	public void setTitulo_filme(String titulo_filme) {
		this.titulo_filme = titulo_filme;
	}



	public String getGenero_filme() {
		return genero_filme;
	}



	public void setGenero_filme(String genero_filme) {
		this.genero_filme = genero_filme;
	}



	public BigDecimal getDuracao() {
		return duracao;
	}



	public void setDuracao(BigDecimal duracao) {
		this.duracao = duracao;
	}



	public String getObservacoes() {
		return observacoes;
	}



	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}



	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	

	public String getAtores() {
		return atores;
	}



	public void setAtores(String atores) {
		this.atores = atores;
	}



	public String getDiretores_filme() {
		return diretores_filme;
	}



	public void setDiretores_filme(String diretores_filme) {
		this.diretores_filme = diretores_filme;
	}



	@Override
	public String toString() {
		return "Desafio [id=" + id + ", titulo_filme=" + titulo_filme + ", genero_filme=" + genero_filme + ", duracao="
				+ duracao + ", id_usuario=" + id_usuario + ", observacoes=" + observacoes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desafio other = (Desafio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
