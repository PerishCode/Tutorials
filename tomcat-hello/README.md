# Tomcat 学习杂记

## Tomcat 基础

### Web 基础概念

- web架构：
  - 客户端/服务器(Client/Server)
  - 浏览器/服务器(Browser/Server)

- 资源分类
  - 静态资源(html/img/...)：直接返回给客户端(或浏览器，以下统称客户端)
  - 动态资源(jsp/php/asp/...)：通过解析生成静态资源后返回给客户端

- 网络通信三要素
  - IP
  - 端口
  - 协议


## Tomcat 架构

### Tomcat 基础架构

- HTTP 服务器负责解析/封装 HTTP 数据报文，以及和 Servlet 容器通信
- Servlet 容器加载特定的业务类用于解析 HTTP 请求
- 因此所有业务类都需要实现 Servlet 接口

### Tomcat 整体架构

- 连接器(Connector)：处理 Socket 请求，进行网络字节流到 Request/Response 的转化
- 容器(Container)：加载和管理 Servlet，处理 Request

### 连接器(Connector$\Rightarrow$Coyote) & 容器(Container$\Rightarrow$Catalina)

- 接收请求流程：客户端HTTP请求报文 $\rightarrow$ Request 对象 $\rightarrow$ ServletRequest 对象 $\rightarrow$ 业务类
- 返回请求流程：业务类 $\rightarrow$ ServletResponse 对象 $\rightarrow$ Response 对象 $\rightarrow$ 服务器HTTP响应报文
- 连接器：负责报文到 Request/Response 的转化
- 容器：负责 Request/Response 到 ServletRequest/ServletResponse 的转化以及业务类的调用
- 一个容器可以与多个连接器通信，并作为一个整体提供服务(Service)

#### IO模型 & 协议

- NIO/NIO2/APR
- HTTP1.1/AJP/HTTP2.0

#### 连接器组件(Endpoint 和 Processor 统称 ProtoHandler)

- Endpoint：解析 TCP/IP 数据报
- Processor：解析应用层协议报文
- Adaptor：负责 Request/Response 到 ServletRequest/ServletResponse 的双向转化

#### 容器组件

- Engine：一个 Container 一个 Engine
- Host：一个 Engine 多个 Host(可以近似地理解成一个网站)
- Context：一个 Host 多个 Context(可以近似地理解成一个服务)
- Wrapper(Servlet)：一个 Context 多个 Wrapper (可以近似地理解成一个特定 URL 对应的解析逻辑/业务类)

### Tomcat 启动流程

- startup.sh
- Bootstrap 类的 main 方法
- 加载 Catalina 
- 初始化 Server
- 初始化 Service
  - 初始化 子容器(Engine/Host/Context/Wrapper)
  - 初始化 Connector[]
    - 初始化 ProtoHandler[] (Endpoint & Processor)
  - 初始化 Executor(线程池)
- 初始化完成后调用start方法
- 按照初始化的顺序启动

*注：源码启动需要进行额外的配置和目录结构调整*

#### 一些源码

- LifeCycle：组件的顶层接口，定义了一系列生命周期
- Service/Server/...：业务组件的接口
- StandardService/StandardServer/...：业务组件的默认实现类