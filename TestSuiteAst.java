package org.ioopm.calculator.astTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit test Suite
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	VariableTest.class, ConstantTest.class, NamedconstantTest.class, SinTest.class, CosTest.class, LogTest.class, ExpTest.class, NegationTest.class, QuitTest.class, VarsTest.class, ClearTest.class, AdditionTest.class
})

public class TestSuiteAst {
}
