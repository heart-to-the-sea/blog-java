/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-08-31 14:11:27
 * @modify date 2022-08-31 14:11:27
 * @desc [description]
 */
package com.example.blog.dao.mapper;
import com.example.blog.domain.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;







@Mapper
public interface UserMapper {
  /**
   * 返回用户列表
   * @return 用户列表
   */
  List<User> getAll();
  /**
   * 根据ID查询用户数据
   * @param id 用户Id
   * @return 用户数据
   */

  User getInfoById(Integer id);
  /**
   * 新增数据
   * @param user 用户数据
   * @return 受影响行数
   */
  int save(User user);

  int delete(Integer id);

}
