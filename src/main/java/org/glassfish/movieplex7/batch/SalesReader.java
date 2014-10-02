
package org.glassfish.movieplex7.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * @author Arun Gupta
 */
@Dependent
@Named
public class SalesReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                new InputStreamReader(
                Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("META-INF/sales.csv")));
    }

    @Override
    public String readItem() {
        String string = null;
        try {
            string = reader.readLine();
            System.out.println("SalesReader.readItem: " + string);
        } catch (IOException ex) {
            Logger.getLogger(SalesReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }
}
