# 准备
1. 编辑 C:\Windows\System32\drivers\etc\hosts
2. 127.0.0.1       localhost
3. 127.0.0.1       www.zzw.com

# 微服务模块

模块名 | group Id |Artifact Id | parent Artifact Id | 模块间依赖| packaging
---|---|---|---|---|---
总聚合 | com.zzw.microservice| com-zzw-parent| 无|无 |pom
公共代码 | com.zzw.microservice| com-zzw-common| com-zzw-parent| 无|jar
基础数据 | com.zzw.microservice| com-zzw-basedata-service| com-zzw-parent| common|jar
安防服务 | com.zzw.microservice| com-zzw-safety.service| com-zzw-parent| common|jar
门禁服务 | com.zzw.microservice| com-zzw-entrance-guard-service| com-zzw-parent| common|jar
资讯服务 | com.zzw.microservice| com-zzw-information-service| com-zzw-parent| common|jar
设备管理 | com.zzw.microservice| com-zzw-device-service| com-zzw-parent| common|jar
注册中心 | com.zzw.microservice| com-zzw-eureka| com-zzw-parent| common|jar
配置中心 | com.zzw.microservice| com-zzw-config| com-zzw-parent| common|jar
其他服务 | com.zzw.microservice| com-zzw-other| com-zzw-parent| common|jar
后台 | com.zzw.microservice| com-zzw-web| com-zzw-parent| 基础数据,安防服务,门禁服务,资讯服务,设备管理|jar
手机接口 | com.zzw.microservice| com-zzw-api| com-zzw-parent| 基础数据,安防服务,门禁服务,资讯服务,设备管理|jar

# 端口规划

模块名 | 端口
---|---
总聚合 | 无
公共代码 | 无
基础数据 | 8081
安防服务 | 8082
门禁服务 | 8083
资讯服务 | 8084
设备管理 | 8086
注册中心 | 8761
配置中心 | 8001
其他服务 | 8087
后台 | 8080
手机接口|8090 

# 微服务模块简介

模块名 | 描述
---|---
总聚合 | 实现maven的聚合与继承的parent
公共代码 | 微服务-公共代码-比如工具类和序列化bean
基础数据 | 微服务-基础数据模块
安防服务 | 微服务-安防模块
门禁服务 | 微服务-门禁服务模块
资讯服务 | 微服务-资讯服务模块
设备管理 | 微服务-设备管理
注册中心 | 微服务-包括注册中心-server侧
配置中心 | 微服务-配置中心-server侧
其他服务 | 目前包括工单，第三方微信，推送，短信，邮件等功能
后台 | 后台支撑thymeleaf+shiro+redis
手机接口|手机接口支撑json+shiro+redis


# 步骤
1. 搭建好公共代码，支持eureka+config，周1有时间在考虑HA
2. 基础模块建立表，包结构划分，公布服务
3. web后台调用服务

# 参考
- http://git.oschina.net/zhangxd/spring-boot-cloud
- http://git.oschina.net/lostad/spring-cloud-app/tree/master
- spring cloud 体系学习范例--简洁参考
- http://git.oschina.net/handsomeho/spring-cloud-study
- Spring Cloud的微服务系统-完美参考
- http://git.oschina.net/qinqiang2000/spring-cloud-base

# 生成代码
# 写ppt