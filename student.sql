-- 管理员登录postgresql
psql -U postgres

-- 创建用户
CREATE USER test WITH LOGIN PASSWORD '123456';

-- 创建数据库
CREATE DATABASE student;

-- 分配数据库权限
GRANT ALL PRIVILEGES ON DATABASE "student" TO test;

-- 列出所有数据库
\l
-- 权限
\du
-- 切换
\c student;


-- 用test登录
psql -U test -d student