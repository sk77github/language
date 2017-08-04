扩展模块：

查看所有php扩展模块：
yum search all php

安装php连接mysql扩展：
yum install php-mysql

rpm -ql php   查看安装分布

一般php配置文件位置：
/etc/php.ini

配置时区：
date.timezone = Asia/Shanghai

----------------------------------------------------------------------------------------------------
扩展安装，以ssh2为例：
安装支持库文件
1，yum install  php-devel php-pear libssh2 libssh2-devel -y
安装SSH2扩展
2，pecl install -f ssh2
修改ssh2.ini
3，vim /etc/php.d/ssh2.ini
检查SSH2是否安装成功
4，php -m | grep ssh2 
5，php -i|grep ssh2   


好用扩展：

安装数学计算扩展：
yum install php-bcmath

PHP SSH2扩展
执行远程服务器上的命令并取返回值

--------------------------------------------------------------------------------------------------------
yum安装服务器：

Step 1: Installing Remi Repository
yum update
yum install epel-release
rpm -Uvh http://rpms.famillecollet.com/enterprise/remi-release-7.rpm

Step 2: Enabling the Remi Repository
vim /etc/yum.repos.d/remi.repo
    [remi]项下
     enabled=1
    [remi-php55]项下（如果安装php5.5）
     enabled=1
     
Step 3: Installing Apache, and PHP  
yum --enablerepo=remi install httpd  php php-common
yum --enablerepo=remi install php-pdo php-mysql php-gd php-xml php-mbstring php-mcrypt php-pecl-apcu php-cli php-pear

Step 5: Enable/Start Apache
centos7：
systemctl enable httpd
systemctl start httpd

centos6:
chkconfig httpd on
service httpd start





-----------------------------------------------------------------------------------------------------------
类，对象，静态方法：

类是对一类事物描述，是抽象的、概念上的定义；
对象是实际存在的该类事物的每个个体，因而也称实例(instance)。在计算机中，可以理解为，在内存中创建了实实在在存在的一个内存区域
存储着这个对象。
创建对象的过程称为创建对象，也称为实例化。


静态成员方法一般在该方法不属于某个特定的类实例时使用，即直接属于某个类，静态成员方法相当于一个全局函数！
子类可以继承父类的静态方法！但是不能覆盖。

什么情况下适合使用静态方法？
静态方法只要定义了类，不必建立类的实例就可使用
全部静态意味着牺牲了OOP的三个特性，也就意味着放弃了封装、继承、多态。另外，由于没有统一编码习惯和约定，很多东西不做抽象，不做单一入口，
代码本身的复用以及维护都是个问题。写多了这种代码，估计工程师本身的成就感都是个问题。 
个人理解下面这几种情景下使用static关键字会比较合适：
util类(或者某个类中充当了util角色的method)
一些特殊的design pattern中，比如static factory、singleton pattern中
某项被封装的功能，即使类不实例化，也可以调用并且不觉得别扭、奇怪，不依赖类内部的其它非静态成员

-----------------------------------------------------------------------------------------------------------
用curl调用接口时，各个阶段响应时间：

time_total 总时间，按秒计。精确到小数点后三位。 （The total time, in seconds, that the full operation lasted. The time will be displayed with millisecond resolution.） 

time_namelookup DNS解析时间,从请求开始到DNS解析完毕所用时间。(The time, in seconds, it took from the start until the name resolving was completed.) 

time_connect 连接时间,从开始到建立TCP连接完成所用时间,包括前边DNS解析时间，如果需要单纯的得到连接时间，用这个time_connect时间减去前边time_namelookup时间。以下同理，不再赘述。(The time, in seconds, it took from the start until the TCP connect to the remote host (or proxy) was completed.) 

time_appconnect 连接建立完成时间，如SSL/SSH等建立连接或者完成三次握手时间。(The time, in seconds, it took from the start until the SSL/SSH/etc connect/handshake to the remote host was completed. (Added in 7.19.0)) 

time_pretransfer 从开始到准备传输的时间。(The time, in seconds, it took from the start until the file transfer was just about to begin. This includes all pre-transfer commands and negotiations that are specific to the particular protocol(s) involved.) 

time_redirect 重定向时间，包括到最后一次传输前的几次重定向的DNS解析，连接，预传输，传输时间。(The time, in seconds, it took for all redirection steps include name lookup, connect, pretransfer and transfer before the final transaction was started. time_redirect shows the complete execution time for multiple redirections. (Added in 7.12.3)) 

time_starttransfer 开始传输时间。在发出请求之后，Web 服务器返回数据的第一个字节所用的时间(The time, in seconds, it took from the start until the first byte was just about to be transferred. This includes time_pretransfer and also the time the server needed to calculate the result.) 

------------------------------------------------------------------------------------------------------------
设计模式：

单例模式：
class Foo {
 
  private static $instance;
 
  private __construct() {
    // Do stuff
  }
 
  public static function getInstance() {
 
    if (!isset(self::$instance)) {
      $c = __CLASS__;
      $instance = new $c;
    }
 
    return self::$instance;
  }
 
  public function sayHello() {
    echo "Hello World!!";
  }
 
}
 
$bar = Foo::getInstance();
 
// Prints 'Hello World' on the screen.
$bar -> sayHello();

