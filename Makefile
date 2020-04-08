JUNIT	= .:junit-4.12.jar:hamcrest-core-1.3.jar
JUNIT_R	= .:junit-4.12.jar:hamcrest-core-1.3.jar:classes

all:
	javac -d classes Calculator.java
	javac -d classes -cp $(JUNIT) TestSuiteAst.java
	javac -d classes -cp $(JUNIT) TestSuiteParser.java

run:
	java -cp classes org.ioopm.calculator.Calculator

run_test:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.astTests.TestSuiteAst
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.parserTests.TestSuiteParser
	java -cp classes org.ioopm.calculator.Calculator < input.txt > output.txt
	diff output.txt expected_output.txt

clean:
	rm -rf classes
