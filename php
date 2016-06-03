扩展：

安装php连接mysql扩展：
yum install php-mysql

rpm -ql php   查看安装分布

一般php配置文件位置：
/etc/php.ini

配置时区：
date.timezone = Asia/Shanghai




安装数学计算扩展：
yum install php-bcmath





-----------------------------------------------------------------------------------------------------------
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

