package com.gxg.Dao;

import com.gxg.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class AccountDao  extends BaseDao{
    //用户登录
    public User userLogin(String userName,String password){
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            String sql = "select * from myuser where username = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = getUserInfo(resultSet);
            }
        }catch (Exception e){
            System.err.println("查询用户信息出错");
            e.printStackTrace();
        }finally {
            closeResources(connection,statement,resultSet);
        }
        return user;
    }
    //用户注册
    public boolean userRegister(User user){
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String sql = "INSERT INTO myuser(username, password)" +
                    " VALUES(?,?) ";
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            isSuccess = (statement.executeUpdate() == 1);
        }catch (Exception e) {
            System.err.println("用户注册失败");
            e.printStackTrace();
        }finally {
            closeResources(connection,statement);
        }
        return isSuccess;
    }

    //将数据表信息封装到User类中
    public User getUserInfo(ResultSet resultSet) throws SQLException {
        User user =new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
