
## Hadoop GraphNodeWritable

#### Command Line Interpretor


* Launch hadoop

hadoop-start

* Give right to load files on hdfs

hdfs dfsadmin -safemode leave

* load graph_input on hdfs

hadoop fs -put graph_input.txt

* Execute tp-1.0.0.jar (compiled java files) with hadoop, Class Graph on package (org.mbds.hadoop.tp2) input = /graph_input.txt output= /Gresults

hadoop jar /home/mbds/graph/tp2/tp-1.0.0.jar org.mbds.hadoop.tp2.Graph /graph_input.txt /Gresults

* read results

hadoop fs -ls /Gresults/Gresults-step-3
hadoop fs -cat /Gresults-step-3/*
