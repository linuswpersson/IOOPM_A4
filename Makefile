JUNIT	= .:junit-4.12.jar:hamcrest-core-1.3.jar
JUNIT_R	= .:junit-4.12.jar:hamcrest-core-1.3.jar:classes

all:
	javac -d classes Calculator.java

make_test_ast:
	javac -d classes -cp $(JUNIT) TestSuiteAst.java

make_test_parser:
	javac -d classes -cp $(JUNIT) TestSuiteParser.java

test_ast:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.astTests.TestSuiteAst

test_parser:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.parserTests.TestSuiteParser

run:
	java -cp classes org.ioopm.calculator.Calculator

clean:
	rm -rf classes
