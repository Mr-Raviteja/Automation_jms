package runner;

import org.testng.Assert;

import javax.jms.JMSException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FtpDriver {
    File inputfw, dequeueOutputfw;
    private JmsConsumer jmsConsumer = new JmsConsumer();
    boolean result;
    byte[] file2Bytes, file1Bytes;


    public void readFile(String expectedFileLocation) throws Exception {
        System.out.println(expectedFileLocation);
        inputfw = new File(expectedFileLocation);
        byte[] file1Bytes = Files.readAllBytes(Paths.get(expectedFileLocation));

    }

    public void setEndpointandQueueName(String endpoint, String queueName, String actualOutFileLocation) throws JMSException, IOException {
        System.out.println(endpoint + ":" + queueName + ":" + actualOutFileLocation);
        jmsConsumer.init(endpoint, queueName, actualOutFileLocation);
        dequeueOutputfw = new File(actualOutFileLocation);
        file2Bytes = Files.readAllBytes(Paths.get(actualOutFileLocation));

    }

   /* public void readDequeueFile(String dqueueLocation) throws Exception {
        System.out.println(dqueueLocation);
        dequeueOutputfw = new File(dqueueLocation);
    }*/

    public void expectedResponse(boolean assertValue) throws Exception {
        // Assertions.assertThat(file1).hasSameContentAs(file2)
        //System.out.println("debugger");
        //String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
        //String file2 = new String(file2Bytes, StandardCharsets.UTF_8);
        //result = FileUtils.contentEquals(inputfw, dequeueOutputfw);

        //assertEquals("The content in the strings should match", file1, file2);
        //assertThat(inputfw).hasSameContentAs(dequeueOutputfw);
        //Assert.assertEquals(result, assertValue);


        BufferedReader bExp;
        BufferedReader bRes;
        String expLine;
        String resLine;
        boolean equal = false;


        try {
            bExp = new BufferedReader(new FileReader(inputfw));
            bRes = new BufferedReader(new FileReader(dequeueOutputfw));

            if ((bExp != null) && (bRes != null)) {
                expLine = bExp.readLine();
                resLine = bRes.readLine();

                equal = ((expLine == null) && (resLine == null)) || ((expLine != null) && expLine.equals(resLine));

                while (equal && expLine != null) {
                    expLine = bExp.readLine();
                    resLine = bRes.readLine();
                    equal = expLine.equals(resLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Assert.assertEquals(equal, assertValue);

    }
    }

