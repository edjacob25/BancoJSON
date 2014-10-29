#!/bin/bash
rm *.class
javac -classpath .:mysql/mysql-connector.jar Source/*.java
mv Source/*.class .
java -classpath .:mysql/mysql-connector.jar ClienteIUG

