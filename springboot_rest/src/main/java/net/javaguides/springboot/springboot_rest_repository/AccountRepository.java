package net.javaguides.springboot.springboot_rest_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springboot_rest_model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
