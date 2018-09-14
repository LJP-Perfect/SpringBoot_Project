package me.freelee.mybatisdruid.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.freelee.mybatisdruid.model.User;
import me.freelee.mybatisdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/*
    Description:
    Author:Lee
    Date:2018/9/11
*/
@Api(value = "用户Controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiIgnore
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model, @RequestParam(value="name",required = false,defaultValue = "World") String name){
        model.addAttribute("name",name);
        return "hello";
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id",value = "用户的ID",required = true,dataType = "Long")
    @GetMapping("/{id}")
    @ResponseBody
    public User selectUserById(@PathVariable("id") Long id){
        User user=userService.selectUserById(id);
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("")
    public String list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo
                , Model model){
        PageInfo<User> pageInfo=userService.queryPage(pageNo);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
//
//    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
//    @ApiImplicitParam(name="user",value="添加的用户实体",required = true,dataType = "User")
//    @PostMapping("/add")
//    public void insert(User user){
//        userService.insertUser(user);
//    }

//    @ApiOperation(value = "删除用户",notes = "根据ID删除对应用户")
//    @ApiImplicitParam(name = "id",value = "要删除的用户ID",required = true,dataType = "Long")
//    @DeleteMapping(value = "/{id}")
//    public void deleteById(@PathVariable("id") Integer id){
//        System.out.println("DELETE____________");
//        userService.deleteUserById(id);
//    }
//
//
//    @ApiOperation(value = "更新用户",notes = "根据用户ID和用户实体来更新")
//    @ApiImplicitParams(
//            {
//                    @ApiImplicitParam(name = "id",value = "要更新的用户ID",required = true,dataType = "Long"),
//                    @ApiImplicitParam(name = "user",value = "要更新的用户实体",required = true,dataType = "User")
//            }
//    )
//    @PutMapping("/")
//    public void updateUser(@RequestParam("user") User user){
//        userService.updateUser(user);
//    }
}
