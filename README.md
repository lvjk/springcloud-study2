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
eureka+config | com.zzw.microservice| com-zzw-eureka-config| com-zzw-parent| common|jar
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
eureka+config | 8761
其他服务 | 8087
后台 | 80
手机接口|81 


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