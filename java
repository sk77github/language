java安装方式（推荐用rpm方式）：
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
手动解压二进制包安装  可直接删除jdk目录（其他如java二进制执行文件可能还需要手动删除，如/usr/bin/java)


java -version                                       查看当前jdk版本
update-alternatives --config java                   查看系统上已安装多少个java版本
