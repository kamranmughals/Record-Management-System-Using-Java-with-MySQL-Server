

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GUI_InterFace implements ActionListener {
	
	Person Sample = new Person();
	private static JLabel userlabel;
	private static JLabel success;
//	private static JLabel passlabel;
	// private static JPasswordField passText;
	private static JTextField perID;
	private static JTextField perName;
	private static JTextField perAge;
	private static JTextField perPhone;
	private static JTextField perQualif;
	private static JTextField perSalary;
	private static JTextField perCity;
	private static JButton button;
	
	
	public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	frame.setSize(520, 550);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setTitle("Add Record");
    	frame.add(panel);
    	
    	
    	Color DRed = new Color(243, 32, 19);
    	Color Border = new Color(50, 115, 220);
    	LineBorder line = new LineBorder(Border, 2, true);
    	panel.setLayout(null);
    	//PersonID
    	userlabel = new JLabel("PERSON ID");
    	userlabel.setBounds(50, 50, 100, 25);
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	panel.add(userlabel);
    	
    	perID = new JTextField(20);
    	perID.setBounds(250, 50, 165, 30);
    	perID.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perID.setBorder(line);
    	panel.add(perID);
    	//PersonName
    	userlabel = new JLabel("Person-Name");
    	userlabel.setBounds(50, 100, 200, 25);
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	panel.add(userlabel);

    	perName = new JTextField();
    	perName.setBounds(250, 100, 165, 30);
    	perName.setBorder(line);
    	perName.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	panel.add(perName);
    	//PersonAge
    	userlabel = new JLabel("Person-Age");
    	userlabel.setBounds(50, 150, 200, 25);
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	panel.add(userlabel);
    	
    	perAge = new JTextField();
    	perAge.setBounds(250, 150, 165, 30);
    	perAge.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perAge.setBorder(line);
    	panel.add(perAge);
    	
    	//PersonPhone
    	userlabel = new JLabel("Person-PhoneNo#");
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	userlabel.setBounds(50, 200, 200, 25);
    	panel.add(userlabel);
    	perPhone = new JTextField();
    	perPhone.setBounds(250, 200, 165, 30);
    	perPhone.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perPhone.setBorder(line);
    	panel.add(perPhone);
    	
    	//PersonQualif
    	userlabel = new JLabel("Person-Qualification");
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	userlabel.setBounds(50, 250, 200, 25);
    	panel.add(userlabel);
    	perQualif = new JTextField();
    	perQualif.setBounds(250, 250, 165, 30);
    	perQualif.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perQualif.setBorder(line);
    	panel.add(perQualif);
    	
    	//PersonSalary
    	userlabel = new JLabel("Person-Salary");
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	userlabel.setBounds(50, 300, 200, 25);
    	panel.add(userlabel);
    	perSalary = new JTextField();
    	perSalary.setBounds(250, 300, 165, 30);
    	perSalary.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perSalary.setBorder(line);
    	panel.add(perSalary);
    	
    	//PersonCity
    	userlabel = new JLabel("Person-City");
    	userlabel.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	userlabel.setBounds(50, 350, 200, 25);
    	panel.add(userlabel);
    	perCity = new JTextField();
    	perCity.setBounds(250, 350, 165, 30);
    	perCity.setFont(new Font("Malgun Gothic", Font.BOLD,14));
    	perCity.setBorder(line);
    	panel.add(perCity);
    	
    	
    	button = new JButton("ADD RECORD");
    	button.setBounds(180, 410, 180, 30);
    	button.addActionListener(new GUI_InterFace());
    	button.setBackground(DRed);
    	button.setForeground(Color.WHITE);
    	button.setFont(new Font("Poppins", Font.BOLD,16));
    	panel.add(button);
    	
    	success = new JLabel("");
    	success.setBounds(130, 450, 300, 25);
    	panel.add(success);
    	
    	frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Color succesGreen = new Color(25, 135, 84);
		Sample.GetConnection();
		String ID = perID.getText();
		String SALARY = perSalary.getText();
		String AGE = perAge.getText();
		Sample.p_id = Integer.parseInt(ID);
		Sample.p_name = perName.getText();
		Sample.p_age = Integer.parseInt(AGE);
		Sample.p_phone = perPhone.getText();
		Sample.p_qualify = perQualif.getText();
		Sample.p_salary = Integer.parseInt(SALARY);
		Sample.p_city = perCity.getText();
		try {
			Sample.InsertData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
			
			success.setText("Person data has been saved(s) successfully!");
			success.setForeground(succesGreen);
			button.setBackground(succesGreen);
			button.setForeground(Color.WHITE);
	}
}

