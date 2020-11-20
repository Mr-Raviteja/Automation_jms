package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runner.FtpDriver;

import javax.jms.JMSException;

public class FtpStepDefination {
    private FtpDriver ftpDriver = new FtpDriver();

    @Given("^I get the file from the location (.*) path$")
    public void getInputFilelocation(String jsonlocation) throws Exception {

        ftpDriver.readFile(jsonlocation);
    }

    @When("^I get Activemq endpoint (.*) and queue name (.*) and outputFile location (.*) path$")
    public void getEndpointQueueName(String endpoint, String queueName, String outputfleLocation) throws JMSException {
        ftpDriver.setEndpointandQueueName(endpoint, queueName, outputfleLocation);
    }

    @When("^Dequeue json objects into a file in location (.*) path$")
    public void getDequeuedFile(String dqueuelocation) throws Throwable {
        ftpDriver.readDequeueFile(dqueuelocation);
    }

    @Then("^I need to compare the two files where to match the content of the data by making assertion as (.*) value$")
    public void responseCodeValidation(boolean assertValue) throws Throwable {
        ftpDriver.expectedResponse(assertValue);
    }

}
