/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-01 10:45:38
 * @modify date 2022-09-01 10:45:38
 * @desc [description]
 */
package com.example.blog.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;




@Slf4j
@Component
public class CostumIdGenerator implements IdentifierGenerator{
  private final AtomicLong al = new AtomicLong(1);
  @Override
  public Long nextId(Object entity) {
      MetaObject metaObject = SystemMetaObject.forObject(entity);
      String name = (String) metaObject.getValue("name");
      final long id = al.getAndAdd(1);
      log.info("为{}生成id->{}",name,id);
      return id;
  }
}
