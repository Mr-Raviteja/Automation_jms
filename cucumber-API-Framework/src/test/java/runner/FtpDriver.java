package runner;

import com.google.common.io.Files;
import cucumber.runtime.junit.Assertions;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import javax.jms.JMSException;
import java.io.File;
import java.io.FileReader;


public class FtpDriver {
    private JmsConsumer jmsConsumer=new JmsConsumer();

    File inputfw,dequeueOutputfw;
    boolean result;


    public void readFile(String jsonLocation) throws Exception{
        System.out.println(jsonLocation);
        inputfw=new File(jsonLocation);
    }

    public void setEndpointandQueueName(String endpoint, String queueName,String outFileLocation) throws JMSException {
        System.out.println(endpoint+":"+queueName+":"+outFileLocation);
        jmsConsumer.init(endpoint,queueName,outFileLocation);

    }

    public void readDequeueFile(String dqueueLocation) throws Exception{
        System.out.println(dqueueLocation);
        dequeueOutputfw=new File(dqueueLocation);
    }

    public void expectedResponse(boolean assertValue) throws Exception {
        result=FileUtils.contentEquals(inputfw,dequeueOutputfw);
       // Assertions.assertThat(file1).hasSameContentAs(file2)
        Assert.assertEquals(result,assertValue);
    }
}