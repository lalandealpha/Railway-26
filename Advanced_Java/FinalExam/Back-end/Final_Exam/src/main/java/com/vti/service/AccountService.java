package com.vti.service;

import com.vti.entity.Account;
import com.vti.form.account.AccountFilterForm;
import com.vti.repository.IAccountRepository;
import com.vti.specification.account.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm) {
        Specification<Account> where = AccountSpecification.buildWhere(search, filterForm);
        return repository.findAll(where, pageable);
    }

    @Override
    public Account getAccountByID(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void createAccount(Account account) {
        repository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        repository.save(account);
    }

    @Override
    public boolean isAccountExistsByUsername(String username) {
        return repository.existsAccountByUsername(username);
    }
}
