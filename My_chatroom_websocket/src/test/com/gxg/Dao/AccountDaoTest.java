package com.gxg.Dao;

import com.gxg.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    @Test
    public void userLogin() {
        User user = accountDao.userLogin("张三","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void userRegister() {
        User user = new User();
        user.setUserName("999");
        user.setPassword("520");
        boolean isSuccess = accountDao.userRegister(user);
        System.out.println(isSuccess);
    }
}