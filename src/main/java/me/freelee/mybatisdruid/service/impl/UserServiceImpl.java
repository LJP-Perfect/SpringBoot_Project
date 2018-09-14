package me.freelee.mybatisdruid.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.freelee.mybatisdruid.mapper.UserMapper;
import me.freelee.mybatisdruid.model.User;
import me.freelee.mybatisdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    Description:
    Author:Lee
    Date:2018/9/11
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users=userMapper.selectAllUser();
        return users;
    }

    @Override
    public PageInfo<User> queryPage(Integer pageNum) {
        //引入PageHelper分页插件
        //startPage方法后紧跟查询语句,这样才能实现分页查询
        PageHelper.startPage(pageNum,2);
        List<User> list=userMapper.selectAllUser();
        //PageInfo构造函数第二个参数是显示导航页的数量
        PageInfo<User> pageInfo=new PageInfo<>(list,2);
        return pageInfo;
    }

    /*
        因为是对数据库进行写操作，所以需要保持原子性。添加了事务的注解@Transactional
        Propagation.REQUIRED:存在事务就处于当前事务中，没有就才创建一个事务
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
