#!/usr/bin/env sh

# 当发生错误时中止脚本
set -e

# 进入page页面
cd ./page

# 打包
yarn run build

# 删除java代码中的页面资源
rm -rf ../src/main/resources/static

# 移动所有文件到java代码中的页面资源目录
mv ./dist ../src/main/resources/

# 移动到java代码中的资源目录
cd ../src/main/resources/

# 修改文件名
mv dist static

# 回到初始目录
cd ../../../