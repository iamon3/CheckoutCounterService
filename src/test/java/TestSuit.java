import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.freeorg.checkoutCounter.controller.CheckoutCounterControllerTest;
import com.freeorg.checkoutCounter.service.CheckoutCounterServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CheckoutCounterServiceTest.class,
	CheckoutCounterControllerTest.class})
public class TestSuit {

}
