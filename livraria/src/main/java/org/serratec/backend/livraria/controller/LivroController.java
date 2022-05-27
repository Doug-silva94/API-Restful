package org.serratec.backend.livraria.controller;

import java.util.List;

import org.serratec.backend.livraria.dto.LivroDTO;
import org.serratec.backend.livraria.exception.LivroException;
import org.serratec.backend.livraria.model.Livro;
import org.serratec.backend.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody LivroDTO livroDTO) throws LivroException {
		livroService.salvar(livroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<Livro> listaLivro) {
		livroService.salvarTodos(listaLivro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idCliente, RequestBody LivroDTO livroDTO) {
		livroService.atualizar(idLivro, livroDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{idLivro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idLivro) {
		livroService.delete(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Livro>> listaTodos() {return ResponseEntity.ok(livroService.listarTodos());}
	
	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Integer idLivro) throws LivroException {
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}

}