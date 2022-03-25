package com.example.myrestcommerce.service;

import com.example.myrestcommerce.controller.model.UpdateUser;
import com.example.myrestcommerce.controller.model.UserResponse;
import com.example.myrestcommerce.dao.DaoFactory;
import com.example.myrestcommerce.dao.base.UserDao;
import com.example.myrestcommerce.dao.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public static UserDao userDao = DaoFactory.getUserDoa();

    public List<UserResponse> fetchAll(){
        return userDao.getAll().stream()
                .map(m -> m.toDTO())
                .collect(Collectors.toList());
    }

    public UserResponse fetchById(long id){
        return userDao.findById(id).toDTO();
    }

    public Long create(User cu){
         return userDao.add(cu);
    }

    public void update(Long id, UpdateUser uc){
        User u = new User(uc.getFirstName(), uc.getLastName(), uc.isSusbrib());
        u.setId(id);
        userDao.update(u);
    }

    public void delete(Long id){
        userDao.remove(id);
    }

    public void delete(User du){
        userDao.remove(du);
    }

}
