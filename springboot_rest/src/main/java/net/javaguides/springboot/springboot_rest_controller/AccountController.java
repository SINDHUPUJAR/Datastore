package net.javaguides.springboot.springboot_rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.springboot_rest_exception.ResourceNotFoundException;
import net.javaguides.springboot.springboot_rest_model.Account;
import net.javaguides.springboot.springboot_rest_model.User;
import net.javaguides.springboot.springboot_rest_repository.AccountRepository;
import net.javaguides.springboot.springboot_rest_repository.UserRepository;

@RestController
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	
	//create account
			@PostMapping("/createaccounts")
			public Account createAccount(@RequestBody Account account)
			{
				return accountRepository.save(account);
			}
			
	//create get all accounts  
			@GetMapping("/getaccounts")
			public List<Account> getAllAccounts()
			{
				return accountRepository.findAll();
				
			}
			
	//get account by id
			@GetMapping("/account/{id}/{owner}")
			public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") String accountId)throws ResourceNotFoundException
			{
				Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found forthis id :" + accountId));
				return ResponseEntity.ok().body(account);
			}
			
	//update account by id
			@PutMapping("/updateaccount/{id}")
			public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") String accountId, @RequestBody Account accountDetails)throws ResourceNotFoundException
			{
				Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found forthis id :" + accountId));
				account.setId(accountDetails.getId());
				account.setAccountName(accountDetails.getAccountName());
				account.setOwner(accountDetails.getOwner());
				account.setCreatedBy(accountDetails.getCreatedBy());
				account.setCreatedDate(accountDetails.getCreatedDate());
				account.setLastmodifiedBy(accountDetails.getLastmodifiedBy());
				account.setLastModifiedDate(accountDetails.getLastModifiedDate());
				accountRepository.save(account);
				return ResponseEntity.ok().body(account);
				
			}
			

	//delete user by id
			@DeleteMapping("/deleteaccount/{id}")
			public ResponseEntity deleteUser(@PathVariable(value = "id") String accountId)throws ResourceNotFoundException
			{
				Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found forthis id :" + accountId));
				accountRepository.deleteById(accountId);
				return ResponseEntity.ok().build();
			}
			
}
