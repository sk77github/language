安装：
https://golang.org/dl/   选择版本下载
https://golang.org/doc/install?download=go1.5.3.linux-amd64.tar.gz   有安装向导

安装步骤：
wget --no-check-certificate  https://storage.googleapis.com/golang/go1.5.3.linux-amd64.tar.gz
tar -C /usr/local -xzf go1.5.3.linux-amd64.tar.gz
设置PATH
//VIM START 
vim /etc/profile  写入
export PATH=$PATH:/usr/local/go/bin
//VIM END
设置GOPATH
//VIM START
vim .bashrc 
export GOPATH=$HOME/gowork(某个目录)
//VIM END

test for install
设定GOPATH环境变量
export GOPATH=$HOME/gowork
mkdir gowork
设定workspace（https://golang.org/doc/code.html#Workspaces）
mkdir bin
mkdir pkg
mkdir src
mkdir src/hello/
//VIM START
vim   src/hello/hello.go
package main

import "fmt"

func main() {
    fmt.Printf("hello, world\n")
}
//VIM END
go install hello (类编译的那么一个过程，会在workspace的bin目录里生成可执行文件)
运行 bin/hello 输出hello，world 验证安装正确
（注意PATH  GOPATH GOROOT 这三者的概念 以及go的workspace的概念）


显示GO环境
go env



Uninstalling Go

To remove an existing Go installation from your system delete the go directory. This is usually /usr/local/go under Linux,
You should also remove the Go bin directory from your PATH environment variable. 
Under Linux and FreeBSD you should edit /etc/profile or $HOME/.profile or $HOME/.bashrc



defer语句保证了在该函数被执行结束之前互斥锁mutex一定会被解锁。
这省去了我们在所有return语句之前以及异常发生之时重复的附加解锁操作的工作。
