package com.vti.service;

import com.vti.entity.Account;
import com.vti.form.account.AccountFilterForm;
import com.vti.form.account.CreatingAccountForm;
import com.vti.form.account.UpdatingAccountForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm);

    List<Account> getAccountList();

    Page<Account> getAccountsByDepartmentIsNull(Pageable pageable);

    Account getAccountById(int id);

    void createAccount(CreatingAccountForm form);

    void updateAccount(int id, UpdatingAccountForm form);

    void deleteAccount(int id);

    boolean isAccountExistsByUsername(String username);

    void deleteAccounts(List<Integer> ids);
}
