package lt.techin.Tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({BaseTest.class, HomePageTest.class, RegistrationPageTest.class})
public class ExampleTestSuite {
    // This class remains empty. It's used only as a holder for the above annotations.
}
