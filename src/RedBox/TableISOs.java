package RedBox;
/**********************************************************************
 TableISOs.java implements the abstract list model for the GUI's JList.
 This includes printing to the list, adding, removing, and sorting the
 list.
 @author Jason Rupright
 @version 10/26/2018
 *********************************************************************/

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

/**********************************************************************
 * Constructs a ArrayList of ISOs to sort and pass arguments to and
 * from the ISO Class types
 **********************************************************************/
@XmlRootElement(name = "listISOs")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name="ISO")
//@XmlSeeAlso({ArrayList.class, DVD.class, Game.class, BluRay.class})
//@XmlSeeAlso(ISO.class)

public class TableISOs extends AbstractTableModel implements Serializable{

    private long version;

    private boolean wrote;


    private static final int COLUMN_NAME        = 0;


    private static final int COLUMN_TITLE       = 1;


    private static final int COLUMN_RDATE       = 2;


    private static final int COLUMN_RTDATE      = 3;


    private static final int COLUMN_INFO        = 4;


    private static final int COLUMN_LATE        = 5;
    /******************************************************************
     *the string list for the column names.
     ******************************************************************/

    private String[] columnNames = {
            "Customer Name",
            "Title",
            "Rental Date",
            "Due Date",
            "Information"};

    public boolean isWrote() {
        return wrote;
    }

    /******************************************************************
     *Constructs a blank ListEngine and initializes the disk list.
     *used to sort with column name
     * @return String
     * @args int columnIndex
     ******************************************************************/
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    //@XmlAttribute
    protected ArrayList<ISO> listISOs;
    /******************************************************************
     *Constructs a blank ListEngine and initializes the disk list.
     ******************************************************************/
    public TableISOs() {
        super();
        listISOs = new ArrayList<ISO>();
        createList();
    }

    /******************************************************************
     Returns the element at the specified index. Used by the
     fireInterval...() methods.
     @param index of element
     @return element at specified index.
     ******************************************************************/
    public Object getElementAt(int index) {

        //Given a valid index...
        if (index >= 0 && index < listISOs.size()) {

            //Parse the purchase date into a string
            String dateP = DateFormat.getDateInstance(DateFormat.SHORT).format(
                    listISOs.get(index).getRentedOn().getTime());

            //Parse the due date into a string
            String dateD = DateFormat.getDateInstance(DateFormat.SHORT).format(
                    listISOs.get(index).getDueBack().getTime());

            //Creates the output string for a ISO
            String s = "Name: " + listISOs.get(index).getNameOfRenter()
                    + " Title: " + listISOs.get(index).getTitle()
                    + " Date Purchased: " + dateP + " Date Due: " + dateD;

            //Parses the console type for game and output the string
            if (listISOs.get(index).isGame()) {
                Game game = (Game) listISOs.get(index);
                String consoleString = "";

                if (game.getPlayer() == PlayerType.Xbox360)
                    consoleString = "Xbox 360";

                if (game.getPlayer() == PlayerType.XboxOne)
                    consoleString = "Xbox One";

                if (game.getPlayer() == PlayerType.PS3)
                    consoleString = "PS3";

                if (game.getPlayer() == PlayerType.PS4)
                    consoleString = "PS2";

                if (game.getPlayer() == PlayerType.PC)
                    consoleString = "GameCube";

                return s + " Console: " + consoleString;
            }

            //Just return the disk string
            else
                return s;
        }

        //Dont return anything if the index is out of bounds
        else {
            return null;
        }
    }
    /******************************************************************
     Returns the unit at the specified colum length.
     @return int
     ******************************************************************/
    public int getColumnCount() {
        return columnNames.length;
    }

    /******************************************************************
     Returns the unit at the specified row length.
     @return int
     ******************************************************************/
    @Override
    public int getRowCount() {
        return listISOs.size();     // returns number of items in the arraylist
    }

    /******************************************************************
     Returns the unit in string format given a colum type and a index row
     @args int row, int col
     @return String
     ******************************************************************/
    @Override
    public String getValueAt(int row, int col) {
        GregorianCalendar dat = new GregorianCalendar();

        switch (col) {

            case COLUMN_NAME:
                Object nameList =  (listISOs.get(row).getNameOfRenter());
                return nameList.toString();
            case COLUMN_TITLE:
                Object titleList =  (listISOs.get(row).getTitle());
                return titleList.toString();
            case COLUMN_RDATE:
                //Object rentedOn = (listISOs.get(row).getRentedOn());
                Object rentedOn =  (DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(listISOs.get(row).getRentedOn().getTime()));
                return rentedOn.toString();
            case COLUMN_RTDATE:
                //Object returnOn =  listISOs.get(row).getDueBack();
                Object returnOn =  (DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(listISOs.get(row).getDueBack().getTime()));
                return returnOn.toString();
            case COLUMN_INFO:
                Object infoList =  (listISOs.get(row).getInfo());
                return infoList.toString();
            case COLUMN_LATE:
                Object daysLate =  (listISOs.get(row).getDaysLate(listISOs.get(row).getDueBack()));
                return daysLate.toString();
            default:
                return null;
        }

    }
    /******************************************************************
     Returns the unit in Object raw format given a colum type and a index row
     @args int row, int col
     @return Object
     ******************************************************************/
    public Object getABSValueAt(int row, int col) {
        Calendar cal = new GregorianCalendar();
        switch (col) {

            case COLUMN_NAME:
                Object nameList =  (listISOs.get(row).getNameOfRenter());
                return nameList;
            case COLUMN_TITLE:
                Object titleList =  (listISOs.get(row).getTitle());
                return titleList;
            case COLUMN_RDATE:
                Object rentedOn = (listISOs.get(row).getRentedOn());
                return rentedOn;
            case COLUMN_RTDATE:
                Object returnOn =  listISOs.get(row).getDueBack();
                return returnOn;
            case COLUMN_INFO:
                Object infoList =  (listISOs.get(row).getInfo());
                return infoList;
            case COLUMN_LATE:
                Object daysLate =  (listISOs.get(row).getDaysLate(listISOs.get(row).getDueBack()));
                return daysLate;
            default:
                return null;
        }

    }


    /******************************************************************
     Adds a new unit to the list
     @param disk
     @return completion status
     ******************************************************************/
    public boolean add(ISO disk) {
        listISOs.add(disk);
        fireTableRowsInserted(0, listISOs.size()-1);
        return true;
    }


    /******************************************************************
     Removes the unit at the specified index
     @param index of unit
     @return completion status
     ******************************************************************/
    public boolean remove(int index) {
        listISOs.remove(index);
        fireTableRowsDeleted(0, listISOs.size()-1);
        return true;
    }


    /******************************************************************
     Updates the list
     @param disk
     @return completion status
     ******************************************************************/
    public boolean update(ISO disk) {
        fireTableRowsUpdated(0, listISOs.size()-1);
        return true;
    }


    public void saveDatabase(String file) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(file));
            for (ISO disk : listISOs) {
                outStream.writeObject(disk);
            }

        } catch (IOException ioException) {
            System.err.println("Error opening file.");
            ioException.printStackTrace();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input.");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
                ioException.printStackTrace();
            }
        }
    }

    /******************************************************************
     * Loads (deserializes) the Account objects from the specified file.
     * @param file autoName of the file to load from.
     ******************************************************************/
    public ArrayList<ISO> loadDatabase(ArrayList<ISO> list, String file) {
        ObjectInputStream inputStream = null;
        //this.version = 0L;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));

            while (true) {
                ISO p = (ISO) inputStream.readObject();
                list.add(p);
                //this.version = inputStream.readByte()& 0xFF;
            }

        } catch (EOFException eofException) {
            return list;
        } catch (InvalidClassException classInvalid) {
            JOptionPane.showMessageDialog(null, "Error 0: No such Administrator privilege.\n\n\nAbort, Retry, Fail?");
            int resp1 = JOptionPane.showConfirmDialog(null, classInvalid.getMessage(), JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);
            if (resp1 == JOptionPane.OK_OPTION) {
                this.wrote = false;
                return list;
            }
            classInvalid.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null, "Error 1: No such Administrator privilege.\n\n\nAbort, Retry, Fail?");
            int resp1 = JOptionPane.showConfirmDialog(null,classNotFoundException.getMessage(), JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);

            if (resp1 == JOptionPane.OK_OPTION) {
                this.wrote = false;
                return list;
            }

            classNotFoundException.printStackTrace();
        } catch ( StreamCorruptedException e) {
            JOptionPane.showMessageDialog(null, "Error 2: No such Administrator privilege.\n\n\nAbort, Retry, Fail?");
            int resp1 = JOptionPane.showConfirmDialog(null,e.getMessage(), JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);

            if (resp1 == JOptionPane.OK_OPTION) {
                this.wrote = false;
                return list;
            }
            e.printStackTrace();
        } catch (IOException ioException) {
            //if(version != DVD.getSerialVersionUID()) {
                JOptionPane.showMessageDialog(null, "Error 3: No such Administrator privilege.\n\n\nAbort, Retry, Fail?");
                int resp1 = JOptionPane.showConfirmDialog(null,ioException.getMessage(), JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);

                if (resp1 == JOptionPane.OK_OPTION) {
                    this.wrote = false;
                    return list;
                }
                ioException.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error 4: No such Administrator privilege.\n\n\nAbort, Retry, Fail?");
                int resp1 = JOptionPane.showConfirmDialog(null,ioException.getMessage(), JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);

                if (resp1 == JOptionPane.OK_OPTION) {
                    this.wrote = false;
                    return list;
                }
            }
        }
        this.wrote = true;
        return list;
    }


    /******************************************************************
     Saves the text object to the file at the given filepath
     @param filename
     @return completion status
     ******************************************************************/
    public void saveAsText(String filename) throws IOException{
        try {
            //BufferedWriter bfw = new BufferedWriter(new FileWriter(filename));
            FileOutputStream f = new FileOutputStream(new File(filename));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(int i = 0; i < listISOs.size(); i++) {
                ISO disk = getISO(i);
                //if(disk.isGame()){

                //}
                o.writeObject(disk.getNameOfRenter());
                o.writeObject(disk.getRentedOn().toString());
                o.writeObject(disk.getDueBack().toString());
                o.writeObject(disk.getInfo());
            }
            o.close();
            f.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error in saving text");

        }
    }

    /******************************************************************
     Loads the text object from the file at the given filepath
     //@param filename
     @return completion status
     ******************************************************************/
    public void loadFromText(String filename) {
        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            ISO disk = (ISO) oi.readObject();
            while(disk != null) {
                //listISOs = (ArrayList<ISO>);
                add(disk);
            }
            fireTableDataChanged();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in loading text");
        }

    }
    public void marshalingUsefullReadableFile(String filename) throws JAXBException {

        TableISOs list = new TableISOs();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        try {

            list.clear();
            for (ISO disk: listISOs) {
                list.add(disk);
            }

            JAXBContext context = JAXBContext.newInstance(TableISOs.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(list, new FileWriter(filename));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving text");
        }
    }

    public void marshalingUsefullWritableFile(String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TableISOs.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();



        //We had written this file in marshalling example

        TableISOs table = (TableISOs) jaxbUnmarshaller.unmarshal( new File(filename) );


        System.out.println(table.listISOs);
        this.clear();
        for (ISO disk: table.listISOs) {
            this.add(disk);
        }
        fireTableDataChanged();
        System.out.println(listISOs);

    }



    /******************************************************************
     Creates a beginning starter list of users to work with
     @return void
     ******************************************************************/
    public void createList() {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        GregorianCalendar temp3 = new GregorianCalendar();
        GregorianCalendar temp4 = new GregorianCalendar();
        GregorianCalendar temp5 = new GregorianCalendar();
        GregorianCalendar temp6 = new GregorianCalendar();

        try {
            Date d1 = df.parse("3/20/2018");
            temp1.setTime(d1);
            Date d2 = df.parse("4/20/2018");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("1/20/2018");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("1/20/2020");
            temp6.setTime(d6);


            Game game1 = new Game(temp1, temp2,"Street Fighter Alpha", "Allie Allen ", PlayerType.Xbox360);
            Game game2 = new Game(temp5, temp3,"The Shadow of the Colossus", "Sam Stone", PlayerType.PS4);
            Game game3 = new Game(temp1, temp6,"God of War", "Callous Meridious", PlayerType.PC);
            DVD dvd = new DVD(temp1, temp3, "Titanic III", "Jim Carry", DVDEdition.Standard );
            BluRay bluRay2 = new BluRay(temp5, temp2, "Shadow Runner", "Jim Booluchi", BluRayEdition.Standard);
            BluRay bluRay3 = new BluRay(temp5, temp1, "A Nightmare Before Christmas", "Charlie Chaplin", BluRayEdition.DirectorsCut);

            add(game1);
            add(game2);
            add(game3);
            add(dvd);
            add(bluRay2);
            add(bluRay3);


        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

    }

    /******************************************************************
     Returns the unit at the specified index.
     @param index of unit
     @return unit at specified index
     ******************************************************************/
    public ISO getISO(int index) {
        return listISOs.get(index);
    }

    /******************************************************************
     Returns the disk list
     @return the disk list
     ******************************************************************/
    @XmlElements
            ({
                    @XmlElement(name = "DVD", type = DVD.class, required = false),
                    @XmlElement(name = "Game", type = Game.class, required = false),
                    @XmlElement(name = "BluRay", type = BluRay.class, required = false),
                    //@XmlElement(name = "ISO", type = ISO.class, required = false),

            })
    public ArrayList<ISO> getList() {
        return listISOs;
    }

    /******************************************************************
     Clears the disk list
     @return none
     ******************************************************************/
    public void clear() {
        listISOs.clear();
    }

    /******************************************************************
     Sorts the disk list and displays the sorted list
     @return none
     ******************************************************************/
    public void sortDateDue() {
        fireTableCellUpdated(0,listISOs.size() - 1);
        Collections.sort(listISOs);
    }

    /******************************************************************
     Helper method to sort through the list
     ******************************************************************/
    public int compare(Double s, Double t) {
        return s.compareTo(t);
    }
}