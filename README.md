
# Hadoop GraphNodeWritable


## INSTALL


** Download the repo **
git clone https://github.com/BenoitBarbereau/hadoop_GraphNodeWritable.git


** Download IDE **
https://www.jetbrains.com/fr-fr/idea/download/download-thanks.html?platform=windows&code=IIC


** Download VirtualBox **
https://www.virtualbox.org/


** Download Hadoop **
https://www.apache.org/dyn/closer.lua/spark/spark-3.2.0/spark-3.2.0-bin-hadoop3.2.tgz


** Download Putty **
https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html


** Download WinSCP **
https://winscp.net/eng/download.php


** Download Hadoop with dependancies in VM **
https://drive.google.com/drive/folders/1DGnh28SxJZ3aS-HIOKnd-ibfyJCdqmhP?usp=sharing


## USAGE

### Step 1 

- Run Virtual machine from VM previously downloaded

- Run Putty :

				connect to the VM 
				localhost:2222
				login: mbds
				password:password

- run Hadoop on Putty in order to set a securized connection with hadoop environment

				hadoop-start


				mbds@localhost's password:
				Linux hadoopvm 4.19.0-6-amd64 #1 SMP Debian 4.19.67-2+deb10u1 (2019-09-20) x86_6                               4
				███╗   ███╗██████╗ ██████╗ ███████╗
				████╗ ████║██╔══██╗██╔══██╗██╔════╝
				██╔████╔██║██████╔╝██║  ██║███████╗
				██║╚██╔╝██║██╔══██╗██║  ██║╚════██║
				██║ ╚═╝ ██║██████╔╝██████╔╝███████║
				╚═╝     ╚═╝╚═════╝ ╚═════╝ ╚══════╝
						Big Data / Hadoop

				Last login: Wed Oct 20 09:34:17 2021 from 10.0.2.2
				mbds@hadoopvm:~$ start-hadoop
				Starting namenodes on [localhost]
				Starting datanodes
				Starting secondary namenodes [hadoopvm]
				Starting resourcemanager
				Starting nodemanagers
				HDFS and Yarn processes have been started.


- run WinSCP in order to user hdfs system files with local hardware

				localhost:2222
				login: mbds
				password:password



### Step 2 

