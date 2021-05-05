# MySQL 学习杂记

## 安装和配置

- 直接使用 Docker 镜像
- WSL2 安装 mysql-client
- 调用命令连接 MySQL 服务
  ```shell
  mysql -P 3306 -h localhost -u root -pking
  ``` 

## 数据库

- 创建数据库

  - 名称 
  - 字符集[可选] 
  - 校验规则[可选]

  ```sql
  CREATE DATABASE [name] CHARSET(?) [charset] COLLATE(?) [collate]; 
  ```

- 查看数据库
  
  ```sql
  SHOW DATABASES;
  ```

- 删除数据库

  - 名称
  
  ```sql
  DROP DATABASES [name];
  ```

- 备份数据库

  ```shell
  mysqldump -u root -pking -B hello > /root/sql/backup.sql
  ```

- 恢复数据库(执行sql文件)
  
  ```sql
  SOURCE /root/sql/backup.sql
  ```
## 表

### 创建表
### 删除表
### 修改表

- 添加列
- 修改列(等价于删除+添加)
- 删除列
- 修改字符集/校对规则/存储引擎

## 数据类型

### 数值类型

#### 整型

- tinyint[1字节]
- smallint[2字节]
- mediumint[3字节]
- int[4字节]
- bigint[8字节]

#### 小数型

- float
- double
- decimal[M,D]

### 文本类型

- char[0~255] 字符数
- varchar[0~65535] 字符数(65535为字节数上限，根据选择字符集的不同，字符数上限会变化，例如 utf-8:(65535-3)/3 = 21844)
- text[0~65535]
- longtext[0~$2^{32}$-1]

#### utf-8字符集的特殊性

使用 utf-8 字符集需要统一所有的字符集设置(可能某几个不需要统一，这个还得再研究研究)

```shell
mysql> show variables like 'char%';
+--------------------------+----------------------------+
| Variable_name            | Value                      |
+--------------------------+----------------------------+
| character_set_client     | utf8                       |
| character_set_connection | utf8                       |
| character_set_database   | utf8                       |
| character_set_filesystem | binary                     |
| character_set_results    | latin1                     |
| character_set_server     | utf8                       |
| character_set_system     | utf8                       |
| character_sets_dir       | /usr/share/mysql/charsets/ |
+--------------------------+----------------------------+

mysql> set character_set_results=utf8 ;
```

### 二进制类型

- blob[0~$2^{16}-1$]
- longblob[0~$2^{32}-1$]

### 日期类型

- date[年月日]
- time[时分秒]
- datetime[年月日时分秒]
- timestamp(用于自动更新操作记录的时间)

## CRUD

### insert 语句

- mysql 引擎会尝试对 int 类型字段插入的数据进行强制类型转换

### update 语句

### delete 语句

### select 语句(单表/多表)

- count(列名) 会自动筛除值为 null 的行
- 默认情况下两张表的查询会直接做笛卡尔积
- group by 必须结合 min max sum avg 等聚合计算函数使用

### 蠕虫复制

### 表去重

### 合并查询

## 函数

### 统计函数
### 字符串函数
### 数学函数
### 时间日期
### 加密函数
### 流程控制

## 内连接

## 外连接

- 左外连接：左侧的表完全显示（即使在右侧表中没有匹配的行）
- 右外连接：右侧的表完全显示（即使在左侧表中没有匹配的行）

## 约束

- primary key：不可重复，不能为空，至多设置一个，可以使用多个字段复合
- unique：不可重复，允许存在多个null值
- not null：不能为空
- foreign key：只能从链接到的表中已存在的primary key或unique字段中取值
  - 主表插入数据受约束
  - 从表删除数据受约束
- check：mysql5.7 校验但是不影响插入
- auto_increment：自增长，可以设定初始值，和 unique 或 primary key 结合使用，仅支持数值型数据(但是一般没人用浮点数和定点数，都直接用int)

## 索引

- 主键索引：主键自动成为索引
- 唯一索引：unique 字段作为索引
- 普通索引
- 全文索引：Solr / Elastic Search 效率更高

### 注意事项

- 频繁查询的字段适合建立索引
- 更新频繁的字段不适合建立索引
- 重复内容多的字段不适合建立索引
- where子句用不上就不用建立索引

## 事务
- 基本概念
  为了保证数据一致性需要确保同时成功和失败的一组 DML(Data Manipulation Language) 语句,
  事务机制需要特定的数据库引擎支持，比如 InnoDB 支持， MySQL 中其他的引擎都不支持
- 事务管理
- savepoint
- rollback
- commit
- 隔离级别
  数据库管理系统在面对多连接的状态时，为了保证数据一致性要进行连接间的隔离，防止以下情形出现
  - 脏读：连接A读取到连接B未commit的事务
  - 不可重复读：连接A在同一事务中的多次查询由于连接B的多次delete/update操作返回不同的结果
  - 幻读：连接A在同一事务中的多次查询由于连接B的多次insert操作返回不同的结果

  MySQL定义了四种隔离级别

  | 隔离级别                  | 脏读 | 不可重复读 | 幻读 | 加锁 |
  | :------------------------ | ---- | ---------- | ---- | ---- |
  | 读未提交(read uncommited) | √    | √          | √    | ×    |
  | 读已提交(read commited)   | ×    | √          | √    | ×    |
  | 可重复读(repeatable read) | ×    | ×          | ×    | ×    |
  | 可串行化(serializable)    | ×    | ×          | ×    | √    |

  加锁会阻塞语句
- ACID

## 存储引擎

### MyISAM

- 不支持事务
- 不支持外键
- 访问速度快
- 无存储上限
- 表级锁

### InnoDB

- 事务安全
- 支持外键
- 占用空间大(索引)
- 行级锁

### Memory

- 内存数据库
- 速度快
- 不进行持久化

## 视图

- 基于表创建(称作'基表')
- 数据来自基表
- 通过视图可以修改基表的数据
- 视图可以嵌套使用

## 设计范式

### 1NF
- 列(逻辑上)不可拆分

### 2NF
- 必须有主键
- 其他列(逻辑上)只与主键的整体唯一关联

### 3NF

- 非主键列(逻辑上)互相无关联

### 4NF

- 先不管了

### 5NF
- 先不管了
