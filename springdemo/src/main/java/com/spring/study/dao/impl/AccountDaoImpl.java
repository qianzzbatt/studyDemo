package com.spring.study.dao.impl;

import com.spring.study.dao.IAccountDao;
import com.spring.study.entity.Account;
import com.spring.study.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    /**
     * dbutils工具类的查询方法
     */
    @Resource
    private QueryRunner runner;
    //连接的工具类

    @Resource
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }


    @Override
    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set accountNum=?,money=? where id=?",account.getAccountNum(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByNum(String accountNum) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where accountNum = ? ",new BeanListHandler<Account>(Account.class),accountNum);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}