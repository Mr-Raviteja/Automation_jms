package runner;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import javax.jms.*;

import java.io.*;


public class JmsConsumer implements MessageListener {
   static Logger log= Logger.getLogger(JmsConsumer.class);
    private String consumerName;
    private MessageConsumer consumer = null;
  private  Connection connection=null;
  private  Session session=null;
private StringBuilder contentBuilder = new StringBuilder();
private String outputfileLocation;
private FileWriter fw;

    public JmsConsumer() {

    }


   /* public void jms(String url,String qName,String ouputLocation) throws JMSException {
        init(url,qName);
        if(null!=connection) {
            // Clean up
            session.close();
            connection.close();
        }
        }*/



    public void init(String url,String qName,String ouputLocation) throws JMSException {
        outputfileLocation=ouputLocation;
        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();
            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            log.info("Connection Successfull");
            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(qName);
            System.out.println("Connection success");
            // Create a MessageProducer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);

           consumer.setMessageListener(new JmsConsumer("Consumer"));
            Thread.sleep(1000);

            /*while (true){
                 Message message=consumer.receiveNoWait();
                if(message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("Jms message is:\n" + textMessage.getText());
                        appendStrToFile(textMessage.getText().concat(","));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }*/

        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
        finally {
            if(null!=connection) {
                // Clean up
                session.close();
                connection.close();
            }
        }

    }

    public void appendStrToFile(String str) throws IOException {
        try {

            String path = System.getProperty("user.dir") + "\\src\\DqueueDatafile.csv";
            fw = new FileWriter(path, true);
            fw.write(str);
            fw.write("\r\n");

        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
        finally {
            //fw.write(str.replaceFirst("[\n\r]+$", ""));
           // str.replaceFirst("[\n\r]+$", "");
            //fw.write(str);
            fw.close();
        }
    }

   @Override
    public void onMessage(Message message) {

           if (message instanceof TextMessage) {
               TextMessage textMessage = (TextMessage) message;
               try {
                   System.out.println("Jms message is:\n" + textMessage.getText());
                   appendStrToFile(textMessage.getText().trim());
               } catch (JMSException | IOException e) {
                   e.printStackTrace();
               }
           }
           else{
               System.out.println("Queue Empty");

           }

    }

    public JmsConsumer(String consumerName) {
        this.consumerName = consumerName;
    }


}
