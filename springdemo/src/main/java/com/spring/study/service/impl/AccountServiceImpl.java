package com.spring.study.service.impl;

import com.spring.study.dao.IAccountDao;
import com.spring.study.entity.Account;
import com.spring.study.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceAccount, String targetAccount, Integer money) {

        Account source = accountDao.findAccountByNum(sourceAccount);
        Account target = accountDao.findAccountByNum(targetAccount);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        int a =2/0;
        accountDao.updateAccount(target);
        System.out.println("转账完毕");

    }
}