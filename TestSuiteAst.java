package org.ioopm.calculator.astTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit test Suite
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   VariableTest.class, ConstantTest.class
})

public class TestSuiteAst {
}
