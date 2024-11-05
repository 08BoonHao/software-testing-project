package my.edu.utar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {AddCustomerOrderUnitTests.class, 
		CalculateEachDocChargeUnitTests.class,
		CalculateEachPhotoChargeUnitTests.class,
		GetTotalChargeUnitTests.class,
		OrderUnitTests.class,
		PassPrintingRequestsUnitTests.class,
		PrintingUnitTests.class
})
public class RegressionUnitTestSuite {
}
