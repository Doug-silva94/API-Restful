package org.serratec.backend.livraria.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.livraria.dto.LivroDTO;
import org.serratec.backend.livraria.exception.LivroException;
import org.serratec.backend.livraria.model.Livro;
import org.serratec.backend.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public Livro transformarLivroDTOEmLivroModel(LivroDTO clienteDTO, Livro livro) throws LivroException {
		
		if(livroDTO.getTitulo() == null)
			throw new LivroException("Titulo nao encontrado");
		
		if(livroDTO.getAutor() == null)
			throw new LivroException("Autor nao encontrado");
		
		livro.setTitulo(livroDTO.getTitulo());
		livro.setTipo(livroDTO.getTipo());
		livro.setAutor(livroDTO.getAutor());
		livro.setDataPublicacao(livroDTO.getDataPublicacao);
		
		return livro;
	}
	
	public LivroDTO transformarLivroModelEmLivroDTO (livroDTO, Livro livro) {
		
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setTipo(livro.getTipo());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataPublicacao(livro.getDataPublicacao());
		
		return livroDTO;
		
	}
	
	public void salvar(LivroDTO livroDTO) throws LivroException {
		
		Livro livro = new Livro();
		Livro livroSalvar = new Livro();
		livroSalvar = transformarLivroDTOEmLivroModel(livroDTO, livro);
		
		livroRepository.save(livroSalvar);
	}

	public void atualizar(Integer idLivro, LivroDTO livroDTO) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNoBanco = new Livro();
		
		if (livro.isPresent()) {
			livroNoBanco = livro.get();
			if (livroDTO.getTitulo() != null) {
			livroNoBanco.setTitulo(livroDTO.getTitulo());	
			}
			if (livroDTO.getTipo() != null) {
				livroNoBanco.setTipo(livroDTO.getTipo());
			}
			if (livroDTO.getAutor() != null) {
				livroNoBanco.setAutor(livroDTO.getAutor());
			}
			if (livroDTO.getDataPublicacao() != null) {
				livroNoBanco.setDataPublicacao(livroDTO.getDataPublicacao());
			}
			livroRepository.save(livroNoBanco);
		
		}
	}

	public void delete(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}

	public List<Livro> listarTodos() {
		return livroRepository.findAll();
	}
	
	public void salvarTodos(List<Livro> listaLivro) {
		livroRepository.saveAll(listaLivro);
	}
	
	public LivroDTO buscarPorId(Integer idLivro) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		
		Livro livroNoBanco = new Livro();
		
		LivroDTO livroDTO = new LivroDTO();
		
		if(livro.isPresent()) {
			livroNoBanco = livro.get();
			livroDTO = transformarLivroModelEmLivroDTO(livroDTO, livroNoBanco);
			
			return livroDTO;
		}
	
		throw new LivroException("Livro nao encontrado");
		
	}
	
}