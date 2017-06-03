#Spring Boot 要点

##创建一个简单的 Restful 应用
* 登陆http://start.spring.io初始化并下载项目 springbootdemo
* 构建 restful 服务，如：HelloController、HiController
* 测试，HelloControllerTest 演示了如何测试 restful 服务

## 配置详解
* Spring Boot 的默认配置文件位置为 src/main/resources/application.properties
> 注意中文配置需先转换为 unicode，否则会出现乱码
* Spring Boot 的配置文件还支持 YAML 文件
> 优点是：YAML 将属性加载到内存中是有序的；缺点是：无法通过 @PropertySource 注解来加载配置。参考：https://my.oschina.net/u/2278977/blog/807958

* 自定义参数


## 监控与管理


