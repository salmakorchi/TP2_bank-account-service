package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
        // so we dont call the methode by its name everyime we use restresource
        @RestResource(path="/byType")
        List<BankAccount> findByType(@Param("t") AccountType type);
}
//Link before rest resource
//http://localhost:8081/bankAccounts/search/findByType?type=SAVING_ACCOUNT
//Link after rest resource
//http://localhost:8081/bankAccounts/search/byType?t=SAVING_ACCOUNT
