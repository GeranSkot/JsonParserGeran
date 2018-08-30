cd C:\repo\JsonParserMibh\src\by\intexsoft\json\parser
javac *.java
jar cvfm JsonParserMibh.jar manifest.txt *.class
jar cvfe JsonParserMibh.jar JsonParserMibh *.class
java -jar JsonParserMibh.jar
pause