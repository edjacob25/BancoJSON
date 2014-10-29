#!/bin/bash
rm *.class
javac -classpath .:mysql/mysql-connector.jar ClienteIUG.java
java -classpath .:mysql/mysql-connector.jar ClienteIUG
