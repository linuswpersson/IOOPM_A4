
all:
	javac -d classes *.java

run:
	java -cp classes org.ioopm.calculator.parser.Calculator

clean:
	rm -rf classes
