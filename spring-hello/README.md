# Spring 学习杂记

## Spring 生态圈

- Spring Boot (用于整合不同的子框架)
- Spring Framework
- ...

## Spring Boot

### 优势

- 内置 Tomcat
- 自动解析依赖，简化配置
- 生产级别监控
- 避免大量 xml

### 可能的缺陷

- 迭代超快
- 门槛低，精通难

## 微服务架构

- 拆分业务逻辑，一个逻辑单元(微服务)一个进程
- 服务间通过 HTTP 协议通信
- 异构+分布式

### 分布式设计引入的挑战

- 服务发现
- 负载均衡
- 服务容错
- 配置管理
- 资源监控
- ...

### Spring 的解决方案

- Spring Boot + Spring Cloud + Spring Cloud + DataFlow