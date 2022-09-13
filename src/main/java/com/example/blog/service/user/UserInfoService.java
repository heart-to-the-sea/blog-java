/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-08-31 14:11:18
 * @modify date 2022-08-31 14:11:18
 * @desc [description]
 */
package com.example.blog.service.user;

import com.example.blog.dao.mapper.UserMapper;
import com.example.blog.domain.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserInfoService {
  @Autowired
  private UserMapper userMapper;
  public List<User> getAllUserInfo() throws InterruptedException{
    Thread.sleep(2000);
    return userMapper.getAll();
  }
  public User getUserById(Integer id) {
    return userMapper.getInfoById(id);
  }
  public Integer saveUserInfo(User user){
    return userMapper.save(user);
  }
  public Integer deleteUserInfo(Integer id){
    return userMapper.delete(id);
  }
}
