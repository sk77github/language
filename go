安装：
https://golang.org/dl/   选择版本下载
https://golang.org/doc/install?download=go1.5.3.linux-amd64.tar.gz   有安装向导

安装步骤：
wget --no-check-certificate  https://storage.googleapis.com/golang/go1.5.3.linux-amd64.tar.gz
tar -C /usr/local -xzf go1.5.3.linux-amd64.tar.gz
//VIM START 
vim /etc/profile  写入
export PATH=$PATH:/usr/local/go/bin
设定GOPATH环境变量
export GOPATH=$HOME/gowork
//VIM END

test for install
mkdir gowork




defer语句保证了在该函数被执行结束之前互斥锁mutex一定会被解锁。
这省去了我们在所有return语句之前以及异常发生之时重复的附加解锁操作的工作。
