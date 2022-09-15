package com.example.Mercado_POO.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")
public class ControllerFornecedor {
	
	@Autowired
	private Mercado mercado;
	
	@PostMapping("fornecedor")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
		return mercado.saveFornecedor(fornecedor);
	}
	
	@PutMapping("/{id}")
    public Fornecedor atualizarFornecedor(@RequestBody Fornecedor antigoFornecedor, Fornecedor novoFornecedor) {
        return mercado.updateFornecedor(antigoFornecedor, novoFornecedor);
    }
	
	@GetMapping("fornecedor")
	public List<Fornecedor> listarFornecedores(){
		return mercado.listAllFornecedor();
	}
	
	@GetMapping("/{id}")
	public Optional<Fornecedor> findById(@PathVariable long id){
		return mercado.findByIdFornecedor(id);
	}
	
	@GetMapping("fornecedor")
	public Optional<Fornecedor> findByNomeFornecedor(@RequestBody String nome){
		return mercado.findByNomeFornecedor(nome);
	}
	
	@GetMapping("fornecedor")
	public Optional<Fornecedor> findByCnpjFornecedor(@RequestBody String cnpj){
		return mercado.findByCnpjFornecedor(cnpj);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		mercado.deleteByIdCompra(id);
	}
	
	@DeleteMapping("Fornecedor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFornecedor(Fornecedor fornecedor) {
		mercado.deleteFornecedor(fornecedor);
	}
	

}