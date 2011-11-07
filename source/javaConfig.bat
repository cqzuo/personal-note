 @echo off
 @echo ------- java 环境变量设置开始 -------------
 @echo off 

 wmic ENVIRONMENT create name="JAVA_HOME",username="",VariableValue="C:\jdk1.6"
 wmic ENVIRONMENT create name="CLASSPATH",username="",VariableValue=".;%%JAVA_HOME%%\lib\tools.jar;%%JAVA_HOME%%\lib\dt.jar;"
 wmic ENVIRONMENT where "name='PATH' and username=''" set VariableValue="%%JAVA_HOME%%\bin;%PATH%" 

@echo ------- java 环境变量设置开始 ----------------------
 pause