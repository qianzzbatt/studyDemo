package com.spring.study.dao;

import com.spring.study.entity.Account;

/**
 * @author admin
 */
public interface IAccountDao {
    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
    /**
     * 根据编号查询账户
     */
    Account findAccountByNum(String accountNum);
}


