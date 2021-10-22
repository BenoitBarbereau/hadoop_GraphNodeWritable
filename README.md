
# Hadoop GraphNodeWritable


## INSTALL


**Download the repo**
				git clone https://github.com/BenoitBarbereau/hadoop_GraphNodeWritable.git


**Download IDE**
				https://www.jetbrains.com/fr-fr/idea/download/download-thanks.html?platform=windows&code=IIC


**Download VirtualBox**
				https://www.virtualbox.org/


**Download Hadoop**
				https://www.apache.org/dyn/closer.lua/spark/spark-3.2.0/spark-3.2.0-bin-hadoop3.2.tgz


**Download Putty**
				https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html


**Download WinSCP**
				https://winscp.net/eng/download.php


**Download Hadoop with dependencies in VM**
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


- run WinSCP in order to use hdfs system files with local hardware

				localhost:2222
				login: mbds
				password:password



### Step 2 


**On Hadoop Deamon console**


-> Give right to load files on hdfs


				hdfs dfsadmin -safemode leave


-> load graph_input on hdfs


				hadoop fs -put graph_input.txt

if errors input while running the script:

				hadoop fs -rm /graph_input.txt
				hadoop fs -put graph_input.txt # again!!



-> Execute tp-1.0.0.jar (compiled java files) with hadoop, Class Graph on package (org.mbds.hadoop.module_GNW.Graph) input = /graph_input.txt output= /res


				hadoop jar /home/mbds/GraphWritableNode/tp-1.0.0.jar org.mbds.hadoop.module_GNW.Graph /graph_input.txt /res


**Result**

Type  [ hadoop fs -cat /res-step-3/* ] look at the result after 3 iterations,



				mbds@hadoopvm:~$ hadoop fs -cat /res-step-3/*
				2021-10-22 15:39:59,207 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false
				1       2,5|NOIR|0
				2       3,4|NOIR|1
				3       6|NOIR|2
				4       |NOIR|2
				5       6|NOIR|1
				6       |NOIR|3


## ARBORESCENCE

#### Java files


**.java**

GraphNodeWritable\hadoop_intellij_project_gradle\src\main\java\org\mbds\hadoop\module_GNW


**.jar**

GraphNodeWritable\hadoop_intellij_project_gradle\build\libs
