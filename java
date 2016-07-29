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

1. PATH环境变量。作用是指定命令搜索路径，在shell下面执行命令时，它会到PATH变量所指定的路径中查找看是否能找到相应的命令程序。
我们需要把 jdk安装目录下的bin目录增加到现有的PATH变量中，bin目录中包含经常要用到的可执行文件如javac/java/javadoc等待，
设置好 PATH变量后，就可以在任何目录下执行javac/java等工具了。 
2. CLASSPATH环境变量。作用是指定类搜索路径，要使用已经编写好的类，前提当然是能够找到它们了，JVM就是通过CLASSPTH来寻找类的。
我们 需要把jdk安装目录下的lib子目录中的dt.jar和tools.jar设置到CLASSPATH中，当然，当前目录“.”也必须加入到该变量中。 
3. JAVA_HOME环境变量。它指向jdk的安装目录，Eclipse/NetBeans/Tomcat等软件就是通过搜索JAVA_HOME变量来找到并使用安装好的jdk。 

三. 三种配置环境变量的方法1. 修改/etc/profile文件 
如果你的计算机仅仅作为开发使用时推荐使用这种方法，因为所有用户的shell都有权使用这些环境变量，可能会给系统带来安全性问题。 
·用文本编辑器打开/etc/profile 
·在profile文件末尾加入： 
export JAVA_HOME=/usr/share/jdk1.6.0_14 
export PATH=$JAVA_HOME/bin:$PATH 
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 

·重新登录 
·注解 
a. 你要将 /usr/share/jdk1.6.0_14改为你的jdk安装目录 
b. linux下用冒号“:”来分隔路径 
c. $PATH / $CLASSPATH / $JAVA_HOME 是用来引用原来的环境变量的值 
在设置环境变量时特别要注意不能把原来的值给覆盖掉了，这是一种 
常见的错误。 
d. CLASSPATH中当前目录“.”不能丢,把当前目录丢掉也是常见的错误。 
e. export是把这三个变量导出为全局变量。 
f. 大小写必须严格区分。 


————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
在没有java环境的机器上，使用rpm方式，安装jdk1.7

下载
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm(这里可换成对应版本的jdk地址，jdk地址从http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html这里获取)"
安装
rpm -ivh jdk-7u79-linux-x64.rpm 
此种方式安装，会将/usr/bin目录下的相关链接做好  比如/usr/bin/java链接到jdk安装目录下的响应可执行文件上（如果原来是手动解压安装的呢？
此时/usr/bin/java下已链接到手动安装的目录，此时/usr/bin/java的指向还是原来的指向，并不会被更改，如果想要使刚刚rpm的方式安装生效，
则需要改变/usr/bin/java的指向，要么手动改变，要么使用update-alternatives（亲测，update-alternatives --config java 并没有输出刚刚rpm
安装的选项，还是只输出了原来手动安装的选项）

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
