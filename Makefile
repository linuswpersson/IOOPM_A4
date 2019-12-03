JUNIT	= .:junit-4.12.jar:hamcrest-core-1.3.jar
JUNIT_R	= .:junit-4.12.jar:hamcrest-core-1.3.jar:classes

all:
	javac -d classes Calculator.java

run:
	java -cp classes org.ioopm.calculator.Calculator

test_make:
	javac -d classes -cp $(JUNIT) TestSuiteAst.java
	javac -d classes -cp $(JUNIT) TestSuiteParser.java

run_test:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.astTests.TestSuiteAst
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.parserTests.TestSuiteParser
	java -cp classes org.ioopm.calculator.Calculator < input.txt > output.txt
	diff output.txt expected_output.txt

make_test_ast:
	javac -d classes -cp $(JUNIT) TestSuiteAst.java

make_test_parser:
	javac -d classes -cp $(JUNIT) TestSuiteParser.java

test_ast:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.astTests.TestSuiteAst

test_parser:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.parserTests.TestSuiteParser

test_prog:
	java -cp classes org.ioopm.calculator.Calculator < input.txt > output.txt
	diff output.txt expected_output.txt

clean:
	rm -rf classes
