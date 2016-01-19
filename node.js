yum install nodejs  
（?centos的一些版本没有源
yum install epel-release 
ls -lah /etc/yum.repos.d/
(？rpm -e epel-release
如果ls -lah /etc/yum.repos.d/找不到epel源，说明之前有安装脏
需要rpm -e epel-release
再yum install epel-release
）
yum install nodejs 
yum install npm --enablerepo=epel
）
