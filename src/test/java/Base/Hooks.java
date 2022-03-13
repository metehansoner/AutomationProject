package Base;

import Log.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(){
        Log.info("Test is started");
    }

    @After
    public void afterScenario(){
        Log.info("Test is terminated");
    }
}
