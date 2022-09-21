/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-21 09:28:39
 * @modify date 2022-09-21 09:28:39
 * @desc [description]
 */
package com.example.blog.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blog.domain.entity.User;
/**
 * {@link FeignClient}参数说明
 *  name: 指定feign-client的名称,如果使用了Ribbon,则name表示为服务的名称,用于服务发现
 *  url:  url一般用于调试,可以手动指定 @FeignClient的调用地址
 *  decode404: 当发生404时,该字段为true,会调用decoder进行解码,否则抛出异常 {@link feign.FeignException}
 *  configuration: Feign配置类,可以定义Feign的 Encoder,Decoder,LogLevel,Contrat
 *  fallback: 定义容错处理类,当远程调用失败或超时时,会调用对应的容错逻辑,fallback指定的类必须实现@FeignClient标记的接口
 *  fallbackFactory: 工厂类，用于生成fallback类示例，通过这个属性我们可以实现每个接口通用的容错逻辑，减少重复的代码
 *  path:定义当前FeignClient的统一前缀
 * @author xingqiankun
 */
@Component
@FeignClient(name="stock",path="/user")
public interface UserFeign {
  /**
   * 获取user列表
   * @return
   */
  @RequestMapping(value="/all",method = RequestMethod.GET)
  public List<User> getUserAll();
}
