java安装方式（推荐用rpm方式，安装时如果不需要其他版本，可以先rpm -e将其他版本删除）：
Manual 解压二进制包
rpm方式
Distribution repository  yum方式  一般OpenJDK都是此种方式
Thirdparty repository

check java的安装方式：
java -version
rpm -qa | grep java
rpm -qa | grep jdk

删除java：
rpm方式安装 可用  rpm -e  包名（rpm -qa | grep java 及 rpm -qa | grep java 的输出）
Self-extracting file uninstall
手动解压二进制包安装  可直接删除jdk目录（其他如java二进制执行文件可能还需要手动删除，如/usr/bin/java)
Find out if Java is installed in some folder. Common locations are /usr/java/jre_<version> or /opt/jre_nb/jre_<version>/bin/java/
When you have located the folder, you may delete folder. 
Warning: You should be certain that Java is not already installed using RPM before removing the folder.
Type: rm -r jre<version>
For example: rm -r jre1.6.0


java -version                                       查看当前jdk版本
update-alternatives --config java                   查看系统上已安装多少个java版本
update-alternatives是linux系统中专门维护系统命令链接符的工具，通过它可以很方便的设置系统默认使用哪个命令、哪个软件版本，比如，我们在系统中
同时安装了open jdk和sun jdk两个版本，而我们又希望系统默认使用的是sun jdk，就可以通过update-alternatives --config java 进行指定


设置java环境变量：
JAVA_HOME
CLASSPATH
PATH


————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
在没有java环境的机器上，使用rpm方式，安装jdk1.7

下载
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm"
安装
rpm -ivh jdk-7u79-linux-x64.rpm 
此种方式安装，会将/usr/bin目录下的相关链接做好  比如/usr/bin/java链接到jdk安装目录下的响应可执行文件上

使用ansible，在集群中批量安装
ansible all -m copy -a "src=/root/jdk-7u79-linux-x64.rpm dest=/root" 
ansible all -m shell -a 'rpm -qa | grep jdk'  
ansible all -m shell -a 'rpm -e jdk1.8.0_65-1.8.0_65-fcs.x86_64'  
ansible all -m shell -a 'rpm -qa | grep jdk'  
ansible all -m shell -a 'ls | grep rpm'  
ansible all -m shell -a 'rpm -ivh jdk-7u79-linux-x64.rpm'  
ansible all -m shell -a 'java -version'  
ansible all -m shell -a 'which java'  

设置java环境变量：
JAVA_HOME
CLASSPATH
PATH
