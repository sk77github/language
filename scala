安装：

二进制包安装（解开包，设置环境变量路径即可）：
wget http://downloads.typesafe.com/scala/2.11.5/scala-2.11.5.tgz
chmod 755 scala-2.11.5.tgz 
tar -zxvf scala-2.11.5.tgz 
cd scala-2.11.5
pwd

vim /etc/profile  start
加入
export SCALA_HOME=/上面的scale pwd安装路径
export PATH=$PATH:$SCALA_HOME/bin:$HOME/bin
vim /etc/profile  end
source /etc/profile

Scala    运行Scala命令测试安装
