package RedBox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class TableDVDToXmlTest {
    /**
     * Keeps a static version of the serial version ID for that compiled class
     */
    private final long serialVersionUID = 1L;
    private TableISOs list;
    private ISO disk1;

    @Before
    public void setUp(){
        list = new TableISOs();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        try {
            Date d1 = df.parse("3/20/2018");
            temp1.setTime(d1);
            Date d2 = df.parse("12/20/2018");
            temp2.setTime(d2);
            disk1 = new Game(temp1, temp2, "Oxygen Not Included", "Jay Bird", PlayerType.PC);
            disk1.setPlayer(PlayerType.PC);
            disk1.setInfo(PlayerType.PC);
        }
        catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }
    }
    @After
    public void tearDown() {
        disk1 = null;
        list.clear();
    }

    //marshalingUsefullReadableFile
    @Test
    public void marshalingUsefullReadableFile() throws JAXBException {
        String filename = "./marshaling01.xml";

        try {
            list.add(disk1);
            JAXBContext context = JAXBContext.newInstance(TableISOs.class, DVD.class, Game.class, BluRay.class );
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(list, new FileWriter(filename));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving text");
        }

    }

    //marshalingUsefullWritableFile
    @Test
    public void marshalingUsefullWritableFile() throws JAXBException{
        String filename = "./marshaling01.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(TableISOs.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();



        //We had written this file in marshalling example

        TableISOs table = (TableISOs) jaxbUnmarshaller.unmarshal( new File(filename) );


//        while()
//            for(DVD dvd : table.getDVD(index))
//
//            {
//
//                System.out.println(dvd.getDVD());
//
//                System.out.println(dvd.get());
//
//            }
    }
}
