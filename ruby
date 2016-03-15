ruby概念：

RVM
用于帮你安装Ruby环境，帮你管理多个Ruby环境，帮你管理你开发的每个Ruby应用使用机器上哪个Ruby环境。
Ruby环境不仅仅是Ruby本身，还包括依赖的第三方Ruby插件。都由RVM管理。


RubyGems
RubyGems是一个方便而强大的Ruby程序包管理器（ package manager），类似RedHat的RPM.它将一个Ruby应用程序打包到一个gem里，
作为一个安装单元。无需安装，最新的Ruby版本已经包含RubyGems了。


Gem
Gem是封装起来的Ruby应用程序或代码库。
注：在终端使用的gem命令，是指通过RubyGems管理Gem包。


Gemfile
定义你的应用依赖哪些第三方包，bundle根据该配置去寻找这些包。


Rake
Rake是一门构建语言，和make类似。Rake是用Ruby写的，它支持自己的DSL用来处理和维护Ruby程序。 Rails用rake扩展来完成多种不容任务，
如数据库初始化、更新等。
Rake is a build language, similar in purpose to make and ant. Like make and ant it's a Domain Specific Language, 
unlike those two it's an internal DSL programmed in the Ruby language.
详细 http://rake.rubyforge.org/


Rakefile
Rakefile是由Ruby编写，Rake的命令执行就是由Rakefile文件定义。
In a gem’s context, the Rakefile is extremely useful. It can hold various tasks to help building, testing and debugging your gem, 
among all other things that you might find useful.
详细：http://rake.rubyforge.org/files/doc/rakefile_rdoc.html


Bundle
相当于多个RubyGems批处理运行。在配置文件gemfilel里说明你的应用依赖哪些第三方包，他自动帮你下载安装多个包，并且会下载这些包依赖的包。
Bundler maintains a consistent environment for ruby applications. It tracks an application's code and the rubygems it needs to run,
so that an application will always have the exact gems (and versions) that it needs to run.





安装-----------------------------------------------------------------------------------------------------------------
安装rvm，传递stable参数，执行https://get.rvm.io所指向的脚本
\curl -sSL https://get.rvm.io | bash -s stable
执行上行脚本后，输出
Creating group 'rvm'

Installing RVM to /usr/local/rvm/
Installation of RVM in /usr/local/rvm/ is almost complete:

  * First you need to add all users that will be using rvm to 'rvm' group,
    and logout - login again, anyone using rvm will be operating with `umask u=rwx,g=rwx,o=rx`.

  * To start using RVM you need to run `source /etc/profile.d/rvm.sh`
    in all your open shell windows, in rare cases you need to reopen all shell windows.

安装--------------------------------------------------------------------------------------------------------------------------

rvm使用----------------------------------------------------------------------------------------------

rvm list known       列出已知的ruby版本
rvm install 1.9.3    安装1.9.3版本的ruby
