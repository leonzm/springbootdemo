# Spring Boot 笔记

## 创建一个简单的 Restful 应用
* 登陆http://start.spring.io初始化并下载项目 springbootdemo
* 构建 restful 服务，如：HelloController、HiController
* 测试，HelloControllerTest 演示了如何测试 restful 服务

## 配置详解
* Spring Boot 的默认配置文件位置为 src/main/resources/application.properties
> 注意中文配置需先转换为 unicode，否则会出现乱码
* Spring Boot 的配置文件还支持 YAML 文件
> 优点是：YAML 将属性加载到内存中是有序的；缺点是：无法通过 @PropertySource 注解来加载配置。参考：https://my.oschina.net/u/2278977/blog/807958
* 自定义参数
* 参数引用
* 使用随机数
* 命令行参数
> 连续的两个减号 -- 就是对 application.properties 中的属性值进行赋值的标识。如 java -jar xxx.jar --server.port=8888 命令，等价于在 application.properties 中添加属性 server.port=8888。
* 多环境配置
> 在 Spring Boot 中，多环境配置的文件名需要满足 application-{profile}.properties 的格式，其中 {profile} 对应环境标识。至于具体哪个配置文件会被加载，需要在 application.properties 文件中通过 spring.profiles.active 属性来设置，其值对应配置文件中的 {profile} 值，也可以执行 java -jar xxx.jar --spring.profiles.active={profile} 来设置环境，注意，命令行的方式会覆盖配置的方式。
* 加载顺序
> Spring Boot 对配置数据的加载顺序,优先级由高到低：<br/>1.在命令行中传入参数<br/>2.SPRING_APPLICATION_JSON 中的属性。SPRING_APPLICATION_JSON 是以 JSON 格式配置在系统环境变量中的内容。<br/>3.java:comp/env 中的 JNDI 属性。<br/>4.Java 的系统属性，可以通过 System.getProperties() 获取的内容。<br/>5.操作系统的环境变量。<br/>6.通过 random.* 配置的随机属性。<br/>7.位于当前应用 jar 包之外，针对不同 {profile} 环境的配置文件内容，例如 application-{profile}.properties 或是 YAML 定义的配置文件。<br/>8.位于当前应用 jar 包之内，针对不同 {profile} 环境的配置文件内容，例如 application-{profile}.properties 或是 YAML 定义的配置文件。<br/>9.位于当前应用 jar 包之外的 application.properties 和 YAML 配置内容。<br/>10.位于当前应用 jar 包之内的 application.properties 和 YAML 配置内容。<br/>11.在 @Configuration 注解修改的类中，通过 @PropertySource 注解定义的属性。<br/>12.应用默认配置，使用 SpringApplication.setDefaultProperties 定义的内容。

## 监控与管理
* 使用 actuator 获取应用的各项监控指标
* 根据监控的作用，分为三大类
> <br/>1.应用配置类（静态）：获取应用中加载的应用配置、环境变量、自动化配置报告等与 Spring Boot 应用密切相关的配置类信息。如：<br/>/autoconfig 用来获取应用的自动化配置报告；<br/>/beans 用来获取应用上下文中创建的所有 Bean；<br/>/configprops 用来获取应用中配置的属性信息报告；<br/>/env 用来获取应用中所有可用的环境属性报告；<br/>/mapping 用来获取所有 Spring MVC 的控制器映射关系报告；<br/>/info 用来返回一些应用自定义的信息
> <br/>2.度量指标类（动态）：提供了应用程序在运行过程中的一些快照信息，比如内存使用情况、HTTP 请求统计、外部资源指标等。如：<br/>/metrics 用来获取当前应用的各类重要度量指标，比如内存信息、线程信息、垃圾回收信息等；<br/>/health 用来获取应用的各类健康指标信息；<br/>/dump 用来暴露程序运行中的线程信息；<br/>/trace 用来获取基本的 HTTP 跟踪信息，始终保留最近的100条请求记录
> <br/>3.操作控制类：如：<br/>/shutdown 关闭应用，需要配置 endpoints.shutdown.enabled=true 来开启

# 统一异常处理
* 返回 Html 格式
> 1. 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。@ExceptionHandler用来定义
函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
> 2.实现error.html页面展示：在templates目录下创建error.html，将请求的URL和Exception对象的message输出

* 返回 Json 格式
> 1. 需在@ExceptionHandler之后加入@ResponseBody，就能让处理函数return的内容转换为JSON格式



