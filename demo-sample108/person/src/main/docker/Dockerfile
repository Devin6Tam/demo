## 基于jdk8环境
FROM txtxw/java
#FROM person:0.0.1
## 指定唯一维护对象
MAINTAINER txtxw txtxw@163.com
## 源宿主机路径为/tmp 创建一个可以从本地主机或其他容器挂载的挂载点
VOLUME /tmp
## 创建data0工程目录
RUN mkdir /data0
## 跳转到 /data0 目录
RUN cd /data0
## 创建java工程目录
RUN mkdir java
# 跳转到 /data0/java目录
RUN cd java
## ADD与COPY都有复制功能，COPY倾向于将本地主机服务
## 将项目工程中打包的person-0.0.1.jar 复制到容器中指定的/data0/java/目录下，并命令为person.jar
ADD person-0.0.1.jar /data0/java/person.jar
## 将项目工程中的运行脚本文件复制到容器中指定的/data0/java/目录下
ADD runboot.sh /data0/java
## 运行指令 touch /data0/java/person.jar（更新文件的时间标签为系统默认时间）
RUN bash -c 'touch /data0/java/person.jar'
## 指定工作目录 /data0/java
WORKDIR /data0/java
## 赋予脚本文件 runboot.sh 执行与写入的权限
RUN chmod 775 runboot.sh
## 指定项目工程的运行端口
EXPOSE 17002
## CMD 运行脚本（运行工程） 指定启动容器时执行的命令，每个Dockerfile只能有一条CMD指令，如果指定了多条指令，则最后一条执行。（会被启动时指定的命令覆盖）
CMD /data0/java/runboot.sh
## ENTRYPOINT 配置容器启动后执行的命令，并且不可被 docker run 提供的参数覆盖。（多个以最后一个生效）
