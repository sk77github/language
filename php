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
类，对象，静态方法：

类是对一类事物描述，是抽象的、概念上的定义；
对象是实际存在的该类事物的每个个体，因而也称实例(instance)。在计算机中，可以理解为，在内存中创建了实实在在存在的一个内存区域
存储着这个对象。
创建对象的过程称为创建对象，也称为实例化。


静态成员方法一般在该方法不属于某个特定的类实例时使用，即直接属于某个类，静态成员方法相当于一个全局函数！
子类可以继承父类的静态方法！但是不能覆盖。

什么情况下适合使用静态方法？
静态方法只要定义了类，不必建立类的实例就可使用
全部静态意味着牺牲了OOP的三个特性，也就意味着放弃了封装、集成、多态。另外，由于没有统一编码习惯和约定，很多东西不做抽象，不做单一入口，
代码本身的复用以及维护都是个问题。写多了这种代码，估计工程师本身的成就感都是个问题。 
个人理解下面这几种情景下使用static关键字会比较合适：
util类(或者某个类中充当了util角色的method)
一些特殊的design pattern中，比如static factory、singleton pattern中
某项被封装的功能，即使类不实例化，也可以调用并且不觉得别扭、奇怪，不依赖类内部的其它非静态成员

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

