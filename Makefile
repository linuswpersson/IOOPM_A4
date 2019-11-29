JUNIT	= .:junit-4.12.jar:hamcrest-core-1.3.jar
JUNIT_R	= .:junit-4.12.jar:hamcrest-core-1.3.jar:classes

all:
	javac -d classes Calculator.java

make_test_AST:
	javac -d classes -cp $(JUNIT) TestSuiteAst.java

test_AST:
	java -cp $(JUNIT_R) org.junit.runner.JUnitCore org.ioopm.calculator.astTests.TestSuiteAst

run:
	java -cp classes org.ioopm.calculator.Calculator

clean:
	rm -rf classes
