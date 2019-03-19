package RedBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


public class DialogRentBluRay extends JDialog implements ActionListener {
	
	private JTextField titleTxt;
	private JTextField renterTxt;
	private JTextField rentedOnTxt;
	private JTextField DueBackTxt;
	private JButton okButton;
	private JButton cancelButton;
	private boolean closeStatus;
	private Date daterentedOn, dateDue;
	private ISO unit;
	BluRayEdition field;
	final JComboBox<String> bluRayType;
	/*********************************************************
		 Instantiate a Custom Dialog as 'modal' and wait for the
		 user to provide data and click on a button.
     ********************************************************
     * @param parent reference to the JFrame application
     * @param disk an instantiated object to be filled with data*/

	public DialogRentBluRay(JFrame parent, ISO disk) {
		// call parent and create a 'modal' dialog
		super(parent, true);
		
		setTitle("Rent a BluRay:");
		closeStatus = false;
		setSize(400,200);
		
		unit = disk;
		// prevent user from closing window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// instantiate and display text fields
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(7,2));
		
		textPanel.add(new JLabel("Your Name:"));
		renterTxt = new JTextField("John Doe",30);
		textPanel.add(renterTxt);
		
		textPanel.add(new JLabel("Title of BluRay:"));
		titleTxt = new JTextField("Avengers",30);
		textPanel.add(titleTxt);
		
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		textPanel.add(new JLabel("Rented on Date: "));
		rentedOnTxt = new JTextField(df.format(date),30);			//
		textPanel.add(rentedOnTxt);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);  // number of days to add
		date = c.getTime();
		  
		textPanel.add(new JLabel("Due Back: "));
		DueBackTxt = new JTextField(df.format(date),15);
		textPanel.add(DueBackTxt);

		//new dropdown to choose wether it is a special extended edition (double layered) or not
		textPanel.add(new JLabel("Select BluRay Edition: "));
		//gameList = new JList(PlayerType.values());
		bluRayType = new JComboBox(BluRayEdition.values());
		textPanel.add(bluRayType);
		getContentPane().add(textPanel, BorderLayout.CENTER);
		
		// Instantiate and display two buttons
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		setSize(300,300);
		setVisible (true);	
	}
	
	/**************************************************************
		 Respond to either button clicks
		 @param e the action event that was just fired
	 **************************************************************/
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		
		//
		// Get the source of the component, which is our combo
		// box.
		//
		//JComboBox gameSysType = (JComboBox) e.getSource();
		this.field = null;
		Object selected = bluRayType.getSelectedItem();
		switch(selected.toString()) {
			case "DirectorsCut":
				this.field = BluRayEdition.DirectorsCut;
				break;
			case "Enhanced":
				this.field = BluRayEdition.Enhanced;
				break;
			case "Standard":
				this.field = BluRayEdition.Standard;
				break;
			default:
				this.field = null;
		}
		// if OK clicked the fill the object
		if (button == okButton) {
			// save the information in the object
			closeStatus = false;
			
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date dateDue;
			Date daterentedOn;
			df.setLenient(false);
			try {
				daterentedOn = df.parse(rentedOnTxt.getText());
				dateDue = df.parse(DueBackTxt.getText());
				GregorianCalendar rentedOn = new GregorianCalendar();
				GregorianCalendar dueBackOn = new GregorianCalendar();

				ValidateJavaDate validator = new ValidateJavaDate();

				//checking if valid date form format?
				if (validator.validateJavaDate(DueBackTxt.getText())){
					rentedOn.setTime(daterentedOn);
					long diffInMillies = (dateDue.getTime() - rentedOn.getTime().getTime());
					double daysLate = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

					if(daysLate<0){
						JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATE FORMAT:\nMM/DD/YYYY", "Error", JOptionPane.ERROR_MESSAGE);

					}
					else {
						dueBackOn.setTime(dateDue);

						unit.setRentedOn(rentedOn);
						unit.setDueBack(dueBackOn);
						unit.setNameOfRenter(renterTxt.getText());
						unit.setTitle(titleTxt.getText());
						unit.setInfo(field);
						closeStatus = true;
					}
				}
				else
					JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATE FORMAT:\nMM/DD/YYYY", "Error", JOptionPane.ERROR_MESSAGE);

			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATE FORMAT:\nMM/DD/YYYY", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Select valid edition:\nDirectorsCut\nEnhanced\nStandard", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		
		// make the dialog disappear
		dispose();
	}
	
	/**************************************************************
		 Return a String to let the caller know which button
		 was clicked
		 
		 @return an int representing the option OK or CANCEL
	 **************************************************************/
	public boolean closeOK(){
		return closeStatus;
	}
	public BluRayEdition getField() {
		return this.field;
	}
}



