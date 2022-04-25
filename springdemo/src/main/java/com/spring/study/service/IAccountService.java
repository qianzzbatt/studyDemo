package com.spring.study.service;

/**
 * @author admin
 */ //业务接口
public interface IAccountService {
    /**
     * 转账
     * @param sourceAccount        转出账户名称
     * @param targetAccount        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceAccount, String targetAccount, Integer money);

}

