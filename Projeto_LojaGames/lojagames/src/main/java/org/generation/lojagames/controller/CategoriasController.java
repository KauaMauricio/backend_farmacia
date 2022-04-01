package org.generation.lojagames.controller;

import java.util.List;

import org.generation.lojagames.model.Categorias;
import org.generation.lojagames.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*", allowedHeaders ="*")
public class CategoriasController {

	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());		
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Categorias>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Categorias> post (@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@PutMapping
	public ResponseEntity <Categorias> put (@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
		
	
	}
}
