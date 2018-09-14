package me.freelee.mybatisdruid.service;

import com.github.pagehelper.PageInfo;
import me.freelee.mybatisdruid.model.User;

import java.util.List;

/*
    Description:
    Author:Lee
    Date:2018/9/11
*/
public interface UserService {

    User selectUserById(Long id);
    List<User> selectAllUser();
    PageInfo<User> queryPage(Integer pageNum);
    void insertUser(User user);
    void deleteUserById(Integer id);
    void updateUser(User user);
}
