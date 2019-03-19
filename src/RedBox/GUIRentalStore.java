package RedBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

/**********************************************************************
 *
 * Maintains the GUIRentalStore for the red box rental store
 * @author Jason Rupright
 * @version 10/26/2018
 *
 **********************************************************************/
public class GUIRentalStore extends JFrame implements ActionListener{

    /**Count to remember state of Toggle CheckBox Item*/
    private int count;
    /**Holds tempary table*/
    private TableISOs table0;

    /** Holds menu bar */
    private JMenuBar menus;

    /** menus in the menu bar */
    private JMenu fileMenu;
    private JMenu actionMenu;

    /** menu items in each of the menus */
    private JMenuItem openSerItem;
    private JMenuItem exitItem;
    private JMenuItem saveSerItem;
    private JMenuItem openTextItem;
    private JMenuItem saveTextItem;
    private JMenuItem sortDate;
    private JMenuItem rentBluRay;
    private JMenuItem rentDVD;
    private JMenuItem rentGame;
    private JMenuItem returnItem;
    /** The search menu item */
    private JMenuItem searchItem;
    private JMenuItem dayLate;
    private JCheckBoxMenuItem filterTog;
    private JFileChooser fc;


    /** Holds the list engine */
    private TableISOs tableISOs;


    /** Holds jTable */
    private JTable jTable;


    /** Scroll pane */
    //private JScrollPane scrollList;
    //stores amount due by customer
//	private Double amount;
//	private String due;


    /******************************************************************
     *
     * A constructor that starts a new GUI1024 for the rental store
     *
     ******************************************************************/
    public GUIRentalStore(){
        //adding menu bar and menu items
        menus = new JMenuBar();
        fileMenu = new JMenu("File");
        actionMenu = new JMenu("Action");
        openSerItem = new JMenuItem("Open File");
        exitItem = new JMenuItem("Exit");
        saveSerItem = new JMenuItem("Save File");
        sortDate = new JMenuItem("Sort");
        openTextItem = new JMenuItem("Open Text");
        saveTextItem = new JMenuItem("Save Text");
        rentBluRay = new JMenuItem("Rent BluRay");
        rentDVD = new JMenuItem("Rent DVD");
        rentGame = new JMenuItem("Rent Game");
        returnItem = new JMenuItem("Return");
        searchItem = new JMenuItem("Search");
        dayLate = new JMenuItem("Days Late");
        filterTog = new JCheckBoxMenuItem("Filter Toggle");

        //adding items to bar
        fileMenu.add(openSerItem);
        fileMenu.add(saveSerItem);
        fileMenu.addSeparator();
        fileMenu.add(openTextItem);
        fileMenu.add(saveTextItem);
        sortDate.addActionListener(this);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        actionMenu.add(rentBluRay);
        actionMenu.add(rentDVD);
        actionMenu.add(rentGame);
        actionMenu.add(searchItem);
        actionMenu.addSeparator();
        actionMenu.add(returnItem);
        actionMenu.addSeparator();
        actionMenu.add(dayLate);
        actionMenu.add(filterTog);

        menus.add(fileMenu);
        menus.add(actionMenu);

        //adding actionListener
        openSerItem.addActionListener(this);
        saveSerItem.addActionListener(this);
        openTextItem.addActionListener(this);
        saveTextItem.addActionListener(this);
        fileMenu.add(sortDate);
        exitItem.addActionListener(this);
        rentBluRay.addActionListener(this);
        rentDVD.addActionListener(this);
        rentGame.addActionListener(this);
        returnItem.addActionListener(this);
        searchItem.addActionListener(this);
        dayLate.addActionListener(this);
        fileMenu.addActionListener(this);
        filterTog.addActionListener(this);

        filterTog.setState(false);
        setJMenuBar(menus);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableISOs = new TableISOs();
        jTable = new JTable(tableISOs);
        actionMenu.add(dayLate);
        setTitle("Bat Box");
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                titleAlign(topFrame);
            }

        });

        add(new JScrollPane(jTable), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(1000,400);

        //sets amount due to a double with two decimal places
        //due = toStringL(amount);
        //System.out.print("As string" +due+"\n");
        //JTableHeader header = jTable.getTableHeader();
        //header.setUpdateTableInRealTime(true);
        //header.addMouseListener(tableModel.new ColumnListener(jTable));
        //header.setReorderingAllowed(true);
    }

    /**method toStringL takes double and converts to a monitored format (x.xx) with two decimal places*/
    public String toStringL(Double amount) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setGroupingUsed(false);
        formatter.setMinimumFractionDigits(2);
        String DoubleD = formatter.format(amount);
        return DoubleD;
    }

    /********************************************************************
     * Method to create a center aligned text title for topframe JFrame
     * Found at StackOverflow (the website)
     * Posted by: Articuno L
     * On: Sep, 14, 2017
     * Found at: 'https://stackoverflow.com/questions/9662393/
     * how-to-center-align-the-title-in-a-jframe'
     * @param frame JFrame This is passed to set title.
     *******************************************************************/
    private void titleAlign(JFrame frame) {

        Font font = getFont();

        String currentTitle = getTitle().trim();
        FontMetrics fm = getFontMetrics(font);
        int frameWidth = getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        setTitle(pad + currentTitle);

    }
//	public double calcAmount(Long date){
//		if(date<0)
//			return 3.00;
//
//		return amount;
//	}

    /******************************************************************
     *
     * This method handles event-handling code for the GUI1024
     *
     * @param e - Holds the action event parameter
     ******************************************************************/
    public void actionPerformed(ActionEvent e) {

        Object comp = e.getSource();

        if (e.getSource() == sortDate) {
            tableISOs.sortDateDue();
        }

        // save elements
        if (e.getSource() == saveSerItem ||
                e.getSource() == saveTextItem) {
            try {
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showSaveDialog(null);
                File selectedFile = fc.getSelectedFile();
                if (selectedFile == null) {
                    JOptionPane.showMessageDialog(null, "PLEASE SELECT 1 FILE!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (e.getSource() == saveTextItem) {
                        String file = fc.getSelectedFile().getAbsolutePath();
                        tableISOs.marshalingUsefullReadableFile(file);
                    } else {
                        String file = fc.getSelectedFile().getAbsolutePath();
                        tableISOs.saveDatabase(file);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        // load elements
        if (e.getSource() == openSerItem ||
                e.getSource() == openTextItem) {
            try {
                ArrayList<ISO> list = new ArrayList<>();
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showOpenDialog(null);
                File selectedFile = fc.getSelectedFile();
                if (selectedFile == null) {
                    JOptionPane.showMessageDialog(null, "PLEASE SELECT 1 FILE!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (e.getSource() == openSerItem) {
                        String file = fc.getSelectedFile().getAbsolutePath();
                        ArrayList<ISO> temp = tableISOs.loadDatabase(list, file);
                        if (tableISOs.isWrote()) {
                            tableISOs.clear();
                            tableISOs.listISOs = temp;
                        }

                    } else {
                        String file = fc.getSelectedFile().getAbsolutePath();
                        tableISOs.marshalingUsefullWritableFile(file);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }


        //MenuBar options
        if (e.getSource() == exitItem) {
            System.exit(1);
        }
        if (e.getSource() == rentDVD) {
            ISO dvd = new DVD();
            DialogRentDVD dialog = new DialogRentDVD(this, dvd);
            if (dialog.closeOK()) {
                tableISOs.add(dvd);
            }
        }
        if (e.getSource() == rentBluRay) {
            ISO bluRay = new BluRay();
            DialogRentBluRay dialog = new DialogRentBluRay(this, bluRay);
//            if(dialog.getField()==null){
//                JOptionPane.showConfirmDialog(null,"Error: Invalid drop-down selection.", JOptionPane.MESSAGE_PROPERTY, JOptionPane.PLAIN_MESSAGE);
//            }
            if (dialog.closeOK()) {
                tableISOs.add(bluRay);
            } else {
            }

        }

        if (e.getSource() == rentGame) {
            ISO game = new Game();
            DialogRentGame dialog = new DialogRentGame(this, game);
            if (dialog.closeOK()) {
                tableISOs.add(game);
            }

        }


        if (e.getSource() == returnItem) {

            //Get the index of the selected item
            int index = jTable.getSelectedRow();
            GregorianCalendar dat = new GregorianCalendar();
            DialogDaysLate dialog = new DialogDaysLate(this, dat);
            //Check for out of bounds indexes
            if (index < 0) {
                //Alert the user of an out of bounds index
                JOptionPane.showMessageDialog(null,
                        "Please select an item from the list");
            } else {

                //Initialize a calendar for todays date to compare
                //to the due date
                Calendar today = new GregorianCalendar();

                Calendar dueDate = new GregorianCalendar();


                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

                try {
                    today.setTime(dateFormat.parse(DateFormat.
                            getDateInstance(DateFormat.SHORT).
                            format(today.getTime())));
                } catch (ParseException en) {

                }

                /*****************************************************************
                 * Setting dates for rental by grabbing from disk table list and finding the cost by passing an
                 *  amorphic function getCost then formatting properly as a string*/
                GregorianCalendar rentDate = (GregorianCalendar) tableISOs.getABSValueAt(index, 2);
                long diffInMillies = (dat.getTime().getTime() - rentDate.getTime().getTime());
                double daysLate = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                double cost = tableISOs.getISO(index).setCost(dat);

                if (daysLate < 0) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATE FORMAT:\nMM/DD/YYYY", "Error", JOptionPane.ERROR_MESSAGE);

                } else if (!dialog.closeOK()) {
                } else {
                    dueDate.setTime(tableISOs.getISO(index).getDueBack().getTime());

                    String uname = tableISOs.getISO(index).getNameOfRenter();

                    String title = tableISOs.getISO(index).getTitle();

                    DecimalFormat df = new DecimalFormat("#0.00");

                    String costString = "Rental cost: $" +
                            df.format(cost) + "\n";

                    int resp1 = JOptionPane.showConfirmDialog(null, "Thank you, \"" + uname + "\"\nFor returning: \"" + title + "\"\nPlease Swipe Credit Card. \nAmount Due: " + costString, "Make Payment Please: ",
                            JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (resp1 == JOptionPane.OK_OPTION) {
                        tableISOs.remove(index);
                    }
                }

            }
        }

        if (e.getSource() == searchItem) {
        }

        if (e.getSource() == dayLate) {
            int size = tableISOs.listISOs.size();
            String[] stringArray = new String[size];
            String uname;
            GregorianCalendar dueDate;
            String title;
            String dateDue = "";
            String cost="";

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");



            for (int row = 0; row < size; row++) {

                double late = tableISOs.getISO(row).getDaysLate(tableISOs.getISO(row).getDueBack());
                if (late > 0) {
                    uname = tableISOs.getISO(row).getNameOfRenter();
                    title = tableISOs.getISO(row).getTitle();
                    dueDate = tableISOs.getISO(row).getDueBack();
                    cost = toStringL(tableISOs.getISO(row).setCost(dueDate));


                    dateDue = df.format(dueDate.getTime());
                    stringArray[row] = "Renter's Name: " + uname + ", Title: " + title + ", Due Back on " + dateDue + ", Days Late: " + late + ", Estimated Cost: $" + cost+"\n";
                }
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, new JList(stringArray));
                }
            });
        }

        if (filterTog.isSelected()) {
            this.table0 = new TableISOs();
            TableISOs table1 = new TableISOs();

            int size = tableISOs.listISOs.size();
            System.out.println("THIS IS THE SIZE OF TE ISO ARRAY!!"+size);
            String[] stringArray = new String[size];
            String uname;
            GregorianCalendar dueDate;
            String title;
            String dateDue = "";
            String cost="";

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


            for (ISO disk: tableISOs.listISOs){
                table0.add(disk);
            }
            for (int row = 0; row < size; row++) {
                double late = tableISOs.getISO(row).getDaysLate(tableISOs.getISO(row).getDueBack());
                if (late > 0) {
                    table1.add(tableISOs.listISOs.get(row));
                }
            }
            table1.fireTableDataChanged();
            for (int row = 0; row < size; row++) {
                tableISOs.remove(row);
            }
            tableISOs.fireTableDataChanged();

            for (ISO disk: table1.listISOs){
                tableISOs.add(disk);
            }
            tableISOs.fireTableDataChanged();

//            for (int row = 0; row < table1.listISOs.size(); row++) {
//                tableISOs.listISOs.add(table1.getISO(row));
//            }
//            table1.clear();
//            table1.listISOs.clear();
            //this.count++;
            tableISOs.fireTableDataChanged();
            filterTog.setState(false);
        }
//        else if(filterTog.isSelected() && this.count%2 != 0){
//            tableISOs.clear();
//            for(ISO disk: this.table0.listISOs){
//                tableISOs.add(disk);
//            }
//            table0.clear();
//            filterTog.setState(false);
//            this.count++;
//        }


        //JOptionPane.showMessageDialog(null, Arrays.toString(stringArray));
        //if (resp1 == JOptionPane.OK_OPTION) {            }
//          if(e.getSource() == dayLate) {
//            DialogRentDVD ld = new DialogDaysLate(tableDVDs.get());
//        }
    }







    /*****************************************************************
     *
     * Main method that runs the rental store GUI1024
     *
     *****************************************************************/
    public static void main(String[] args) {
        new GUIRentalStore();
    }
}
