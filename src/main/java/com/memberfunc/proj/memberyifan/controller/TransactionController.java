package com.memberfunc.proj.memberyifan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memberfunc.proj.memberyifan.entity.Transaction;
import com.memberfunc.proj.memberyifan.service.TransactionService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Transaction transaction, BindingResult bindingResult) {
		List<String> errors = null;
		if (bindingResult.hasErrors()) {
			errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
				
		try {
			Integer key = transactionService.create(transaction);
			return ResponseEntity.ok(key);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(errors);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			List<Transaction> result = transactionService.getAll();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("false");
		}
	}

	@PutMapping("/update/{transactionid}")
	public ResponseEntity<?> update(@PathVariable("transactionid") int transactionid,
			@RequestBody Transaction transaction, BindingResult bindingResult) {
		List<String> errors = null;
		if (bindingResult.hasErrors()) {
			errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}

		try {
			Boolean result = transactionService.update(transaction);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{transactionid}")
	public ResponseEntity<?> delete(@PathVariable("transactionid") int transactionid) {
		try {
			Boolean result = transactionService.delete(transactionid);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("false");
		}
	}
}
