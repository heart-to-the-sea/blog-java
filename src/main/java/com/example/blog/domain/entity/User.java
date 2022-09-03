package com.example.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("user_t")
public class User {
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  @TableField("username")
  private String username;
  @TableField("password")
  private String password;
  @TableField("create_date")
  private Integer createDate;
  @TableField("update_date")
  private Integer updateDate;
  @TableField("del_flag")
  private Byte delFlag;
  @TableField("head_image")
  private String headImage;
}
