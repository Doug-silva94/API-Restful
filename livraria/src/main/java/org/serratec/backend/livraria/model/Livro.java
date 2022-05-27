package org.serratec.backend.livraria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="livro_cd_id")
	private Integer idLivro;
	
	@Column(name="livro_tx_titulo")
	private String titulo;
	
	@Column(name="livro_tx_tipo")
	private String tipo;
	
	@Column(name="livro_tx_autor")
	private String autor;
	
	@Column(name="livro_dt_publicacao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;
	
	public Livro() {
		
	}
	
	public Integer getIdLivro() {return idLivro;}
	public void setIdLivro(Integer idLivro) {this.idLivro = idLivro;}
	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public Date getDataPublicacao() {return dataPublicacao;}
	public void setDataPublicacao(Date dataPublicacao) {this.dataPublicacao = dataPublicacao;}
	
}
