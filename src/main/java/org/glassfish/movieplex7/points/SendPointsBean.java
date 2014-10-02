
package org.glassfish.movieplex7.points;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author Arun Gupta
 */
@Named
@RequestScoped
public class SendPointsBean {

    @Inject
//    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    JMSContext context;
    
    @NotNull
    @Pattern(regexp = "^\\d{2},\\d{2}", message = "Message format must be 2 digits, comma, 2 digits, e.g. 12,12")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Resource(lookup = "java:global/jms/pointsQueue")
    Queue pointsQueue;

    public void sendMessage() {
        System.out.println("Sending message: " + message);

        context.createProducer().send(pointsQueue, message);
    }
}
