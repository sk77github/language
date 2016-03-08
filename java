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
