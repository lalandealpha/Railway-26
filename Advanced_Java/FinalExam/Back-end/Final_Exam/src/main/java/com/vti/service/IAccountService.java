package com.vti.service;

import com.vti.entity.Account;
import com.vti.form.account.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm);

    Account getAccountByID(int id);

    void createAccount(Account account);

    void updateAccount(Account account);

    boolean isAccountExistsByUsername(String username);

}
