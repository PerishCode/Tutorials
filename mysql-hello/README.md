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

## 函数

### 统计函数
### 字符串函数
### 数学函数
### 时间日期
### 加密函数
### 流程控制

## 内连接

## 外连接

## 约束

## 索引

## 事务