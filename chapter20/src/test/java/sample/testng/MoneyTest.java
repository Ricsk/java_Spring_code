/*package sample.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoneyTest{
	private Money f12CHF;
	private Money f14CHF;
	private Mondy f28USD;
	
	@BeforeMethod
	protected void setUp() {
		f12CHF = new Money(12, "CHF");
		f14CHF = new Money(14, "CHF");
		f28USD = new Mondy(28, "USD");
		
	}
	
	@Test
	public void moneyBag() {
		Money bag[] = { f26CHF, f28USD};
		MoneyBag expected = new MoneyBag(bag);
		assertEquals(expected, f12CHF.add(f28USD.add(f14CHF)));
	}
	
	@AfterMethod
	protected void tearDown() {}
}*/