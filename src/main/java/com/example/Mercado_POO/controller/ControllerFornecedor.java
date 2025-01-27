package com.example.Mercado_POO.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.fachada.Mercado;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/fornecedor")
public class ControllerFornecedor {
	
	@Autowired
	private Mercado mercado;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarFornecedor(@RequestBody Fornecedor fornecedor) throws JSONException, ParseException{
		if(mercado.saveFornecedor(fornecedor) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	//@PutMapping("/editar")
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ResponseEntity<Object> atualizarFornecedor(@RequestBody Fornecedor novoFornecedor) {
        //return mercado.updateFornecedor(novoFornecedor);
        if(mercado.updateFornecedor(novoFornecedor) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("/listarTodos")
	public List<Fornecedor> listarFornecedores(){
		return mercado.listAllFornecedor();
	}
	
	@GetMapping("/fornecedor{idFornecedor}")
	public Optional<Fornecedor> findByIdFornecedor(@PathVariable long idFornecedor){
		return mercado.findByIdFornecedor(idFornecedor);
	}
	
	@GetMapping("nomeFornecedor")
	public Optional<Fornecedor> findByNomeFornecedor(@RequestBody String nome){
		return mercado.findByNomeFornecedor(nome);
	}
	
	@GetMapping("cnpj")
	public Optional<Fornecedor> findByCnpjFornecedor(@RequestBody String cnpj){
		return mercado.findByCnpjFornecedor(cnpj);
	}
	
	@DeleteMapping("/fornecedor{idFornecedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdFornecedor(@PathVariable long idFornecedor) {
		mercado.deleteByIdFornecedor(idFornecedor);
	}
	
	@DeleteMapping("Fornecedor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFornecedor(Fornecedor fornecedor) {
		mercado.deleteFornecedor(fornecedor);
	}
	

}
