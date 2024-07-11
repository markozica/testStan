package testovi;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import stan.AgencijaProdajeStanova;
import stan.Stan;

public class TestRunner {

    public static void main(String[] args) {
    
		Result result = JUnitCore.runClasses(StanTests.class, AgencijaProdajeStanovaTests.class);
		
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		for (Failure f: result.getFailures()) {
			l.warning(f.toString());
		}
		
		l.info("Vreme izvrsavanja:" + result.getRunTime());
		l.info("Broj testova:"+ result.getRunCount());
		
		l.info("Uspesno testova:" + (result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
		l.info("Broj palih testova:"+ result.getFailureCount());
		l.info("Broj preskocenih:"+ result.getIgnoreCount());
		l.info("Broj dinamicki preskocenih:" + result.getAssumptionFailureCount());
		
		if (result.wasSuccessful()) 
			l.info("Svi testovi su uspesno izvrseni");
		else
			l.warning("Postoje greske u testovima");
    	
    	
}
}
