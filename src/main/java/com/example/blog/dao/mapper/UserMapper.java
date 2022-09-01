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
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;







@Mapper
public interface UserMapper {
  /**
   * 返回用户列表
   * @return 用户列表
   */
  @Select("SELECT * FROM user_t")
  @Results(
    id="resultUser",
    value = {@Result(property = "id", column = "id"),
    @Result(property = "userName", column = "user_name"),
    @Result(property = "password", column = "password"),
    @Result(property = "createDate", column = "create_date"),
    @Result(property = "updateDate", column = "update_date"),
    @Result(property = "delFlag", column = "del_flag"),
    @Result(property = "headImage", column = "head_image")
  }
  )
  List<User> getAll();
  /**
   * 根据ID查询用户数据
   * @param id 用户Id
   * @return 用户数据
   */
  // @Select("SELECT * FROM user_t WHERE id = #{id}")
  // @Results(
  //   id="resultUseInfor",
  //   value = {@Result(property = "id", column = "id"),
  //   @Result(property = "userName", column = "user_name"),
  //   @Result(property = "password", column = "password"),
  //   @Result(property = "createDate", column = "create_date"),
  //   @Result(property = "updateDate", column = "update_date"),
  //   @Result(property = "delFlag", column = "del_flag"),
  //   @Result(property = "headImage", column = "head_image")
  // }
  // )
  User getInfoById(Integer id);
  /**
   * 新增数据
   * @param user 用户数据
   * @return 受影响行数
   */
  @Insert({
    "INSERT INTO user_t(id, user_name,password,create_date,update_date,head_image)",
    "VALUES(#{id},#{userName},#{password},#{createDate},#{updateDate},#{headImage})"
  })
  int save(User user);

}
