import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Start extends JFrame {

	private JPanel contentPane;
	private JTextField OrganisationText;
	private JTextField DisplayNameText;
	private JTextField EmailText;
	private JTextField UsernameText;
	private JTextField PasswordText;
	private JTextField ConfirmText;
	private JPanel Basic_Information;
	private JPanel Management_Scales;
	private JPanel Acceptance_Criteria; 
	private JPanel Control_Set_Selection;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private static int state =3;      
	private JComboBox Formula ;
	private Border border;
	/* *
	 * state value for page direction 
	 * 1 ==> Basic Information
	 * 2 ==> Control set selection
	 * 3 ==> Management scales
	 * 4 ==> AAcceptance criteria
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		border = BorderFactory.createLineBorder(Color.black, 2, true);
		
		Basic_Information = new JPanel();
		Basic_Information.setBackground(Color.WHITE);
		Basic_Information.setBounds(264, 0, 720, 513);
		Basic_Information.setVisible(false);
		
		Control_Set_Selection = new JPanel();
		Control_Set_Selection.setBackground(Color.WHITE);
		Control_Set_Selection.setVisible(false);
		
		Management_Scales = new JPanel();
		Management_Scales.setBackground(Color.WHITE);
		Management_Scales.setVisible(true);
		
		Acceptance_Criteria = new JPanel();
		Acceptance_Criteria.setBackground(Color.WHITE);
		Acceptance_Criteria.setVisible(false);
		Acceptance_Criteria.setBounds(264, 0, 720, 513);
		contentPane.add(Acceptance_Criteria);
		Acceptance_Criteria.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(87, 61, 270, 286);
		Acceptance_Criteria.add(panel_2);
		panel_2.setBorder(border);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(29, 0, 1, 286);
		lblNewLabel_4.setBorder(border);
		panel_2.add(lblNewLabel_4);
		
		JLabel label_17 = new JLabel("New label");
		label_17.setBorder(border);
		label_17.setBounds(0, 255, 270, 1);
		panel_2.add(label_17);
		
		
		JLabel lblNewLabel_3 = new JLabel("Likelihood");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 142, 77, 14);
		Acceptance_Criteria.add(lblNewLabel_3);
		
		JLabel lblImpact_1 = new JLabel("Impact");
		lblImpact_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpact_1.setBounds(159, 359, 122, 14);
		Acceptance_Criteria.add(lblImpact_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(395, 76, 237, 217);
		Acceptance_Criteria.add(panel_3);
		panel_3.setLayout(null);
		
		Management_Scales.setBounds(264, 0, 720, 513);
		contentPane.add(Management_Scales);
		Management_Scales.setLayout(null);
		
		JLabel lblManagementScales = new JLabel("Management Scales");
		lblManagementScales.setBounds(23, 11, 154, 28);
		Management_Scales.add(lblManagementScales);
		
		JLabel lblLikelihood = new JLabel("Likelihood");
		lblLikelihood.setBounds(23, 60, 154, 28);
		Management_Scales.add(lblLikelihood);
		
		JLabel lblImpact = new JLabel("Impact");
		lblImpact.setBounds(23, 257, 154, 28);
		Management_Scales.add(lblImpact);
		
		JLabel label_2 = new JLabel("1");
		label_2.setBounds(171, 144, 15, 14);
		Management_Scales.add(label_2);
		
		JLabel label_3 = new JLabel("2");
		label_3.setBounds(279, 144, 15, 14);
		Management_Scales.add(label_3);
		
		JLabel label_4 = new JLabel("3");
		label_4.setBounds(392, 144, 15, 14);
		Management_Scales.add(label_4);
		
		JLabel label_5 = new JLabel("4");
		label_5.setBounds(502, 144, 15, 14);
		Management_Scales.add(label_5);
		
		JLabel label_9 = new JLabel("5");
		label_9.setBounds(610, 142, 15, 14);
		Management_Scales.add(label_9);
		
		JLabel label_10 = new JLabel("1");
		label_10.setBounds(171, 334, 15, 14);
		Management_Scales.add(label_10);
		
		JLabel label_11 = new JLabel("2");
		label_11.setBounds(279, 334, 15, 14);
		Management_Scales.add(label_11);
		
		JLabel label_12 = new JLabel("3");
		label_12.setBounds(392, 334, 15, 14);
		Management_Scales.add(label_12);
		
		JLabel label_13 = new JLabel("4");
		label_13.setBounds(502, 334, 15, 14);
		Management_Scales.add(label_13);
		
		JLabel label_14 = new JLabel("5");
		label_14.setBounds(610, 332, 15, 14);
		Management_Scales.add(label_14);
		
		JSlider LikeHood = new JSlider();
		LikeHood.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(LikeHood.getValue()<=12) {
					LikeHood.setValue(0);
					
				}else if(LikeHood.getValue()>12&&LikeHood.getValue()<37)
				{
					LikeHood.setValue(25);
				}
				else if(LikeHood.getValue()>32&&LikeHood.getValue()<62){
					LikeHood.setValue(50);
				}
				else if(LikeHood.getValue()>62&&LikeHood.getValue()<87){
					LikeHood.setValue(75);
				}else {
					LikeHood.setValue(100);
				}
			}
		});
		LikeHood.setBackground(Color.WHITE);
		LikeHood.setValue(75);
		LikeHood.setOpaque(true);
		LikeHood.setBounds(171, 107, 446, 26);
		Management_Scales.add(LikeHood);
		
		JSlider Impact = new JSlider();
		Impact.setBackground(Color.WHITE);
		Impact.setBounds(171, 297, 446, 26);
		Impact.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Impact.getValue()<=12) {
					Impact.setValue(0);
					
				}else if(Impact.getValue()>12&&Impact.getValue()<37)
				{
					Impact.setValue(25);
				}
				else if(Impact.getValue()>32&&Impact.getValue()<62){
					Impact.setValue(50);
				}
				else if(Impact.getValue()>62&&Impact.getValue()<87){
					Impact.setValue(75);
				}else {
					Impact.setValue(100);
				}
			}
		});
		Management_Scales.add(Impact);
		
		JLabel lblHighly = new JLabel("Highly");
		lblHighly.setBounds(145, 176, 71, 14);
		Management_Scales.add(lblHighly);
		
		JLabel lblUnlikely = new JLabel("unlikely");
		lblUnlikely.setBounds(145, 195, 71, 14);
		Management_Scales.add(lblUnlikely);
		
		JLabel lblUn = new JLabel("Unlikely");
		lblUn.setBounds(262, 169, 71, 14);
		Management_Scales.add(lblUn);
		
		JLabel lblPlausible = new JLabel("Plausible");
		lblPlausible.setBounds(370, 169, 71, 14);
		Management_Scales.add(lblPlausible);
		
		JLabel lblLike = new JLabel("Like");
		lblLike.setBounds(495, 169, 38, 14);
		Management_Scales.add(lblLike);
		
		JLabel label_15 = new JLabel("Highly");
		label_15.setBounds(590, 167, 71, 14);
		Management_Scales.add(label_15);
		
		JLabel lblLikely = new JLabel("likely");
		lblLikely.setBounds(590, 186, 71, 14);
		Management_Scales.add(lblLikely);
		
		JLabel lblOperational = new JLabel("Operational");
		lblOperational.setBounds(43, 381, 71, 14);
		Management_Scales.add(lblOperational);
		
		JLabel label_16 = new JLabel("< 1 day");
		label_16.setBounds(155, 381, 71, 14);
		Management_Scales.add(label_16);
		
		JLabel lblDays = new JLabel("1-3 days");
		lblDays.setBounds(262, 381, 71, 14);
		Management_Scales.add(lblDays);
		
		JLabel lblDays_1 = new JLabel("4-7 days");
		lblDays_1.setBounds(370, 381, 71, 14);
		Management_Scales.add(lblDays_1);
		
		JLabel lblDays_2 = new JLabel("7 days+");
		lblDays_2.setBounds(484, 381, 71, 14);
		Management_Scales.add(lblDays_2);
		
		Formula = new JComboBox();
		Formula.setBounds(155, 418, 161, 20);
		Formula.addItem(new String("Likelihood+Impact"));
		Formula.addItem(new String("Likelihood-Impact"));
		Formula.addItem(new String("Likelihood+Impact-1"));
		Formula.addItem(new String("Likelihood-Impact-1"));
		Formula.addItem(new String("Likelihood*Impact"));
		Management_Scales.add(Formula);
		
		
		Control_Set_Selection.setBounds(264, 0, 720, 513);
		contentPane.add(Control_Set_Selection);
		Control_Set_Selection.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Please tick the control sets you wish to use during the risk assessment (more than one can be selected):");
		lblNewLabel_2.setBounds(71, 21, 568, 30);
		Control_Set_Selection.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ISO 27001:2005");
		chckbxNewCheckBox.setBounds(256, 78, 131, 23);
		Control_Set_Selection.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("ISO 27001:2013");
		checkBox.setBounds(256, 116, 131, 23);
		checkBox.setSelected(true);
		Control_Set_Selection.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("ISO 27001:2012");
		checkBox_1.setBounds(256, 155, 131, 23);
		Control_Set_Selection.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("NIST 800-53");
		checkBox_2.setBounds(256, 199, 131, 23);
		Control_Set_Selection.add(checkBox_2);
		contentPane.add(Basic_Information);
		Basic_Information.setLayout(null);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setBounds(58, 11, 205, 38);
		Basic_Information.add(lblBasicInformation);
		
		JLabel lblSoLets = new JLabel("So, let's configure vsRisk!");
		lblSoLets.setBounds(58, 50, 205, 38);
		Basic_Information.add(lblSoLets);
		
		JLabel label_1 = new JLabel("First, we need a few basic details.");
		label_1.setBounds(58, 88, 205, 38);
		Basic_Information.add(label_1);
		
		JLabel OrganisationLabel = new JLabel("Organisation:");
		OrganisationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		OrganisationLabel.setBounds(128, 148, 86, 31);
		Basic_Information.add(OrganisationLabel);
		
		OrganisationText = new JTextField();
		OrganisationText.setBounds(214, 152, 189, 20);
		Basic_Information.add(OrganisationText);
		OrganisationText.setColumns(10);
		
		JLabel DisplayNameLabel = new JLabel("Display Name:");
		DisplayNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		DisplayNameLabel.setBounds(128, 190, 86, 31);
		Basic_Information.add(DisplayNameLabel);
		
		DisplayNameText = new JTextField();
		DisplayNameText.setColumns(10);
		DisplayNameText.setBounds(214, 194, 189, 20);
		Basic_Information.add(DisplayNameText);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setBounds(128, 232, 86, 31);
		Basic_Information.add(EmailLabel);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(214, 236, 189, 20);
		Basic_Information.add(EmailText);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		UsernameLabel.setBounds(128, 268, 86, 31);
		Basic_Information.add(UsernameLabel);
		
		UsernameText = new JTextField();
		UsernameText.setColumns(10);
		UsernameText.setBounds(214, 272, 189, 20);
		Basic_Information.add(UsernameText);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PasswordLabel.setBounds(128, 306, 86, 31);
		Basic_Information.add(PasswordLabel);
		
		PasswordText = new JTextField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(214, 310, 189, 20);
		Basic_Information.add(PasswordText);
		
		JLabel ConfrimLabel = new JLabel("Confirm:");
		ConfrimLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ConfrimLabel.setBounds(128, 348, 86, 31);
		Basic_Information.add(ConfrimLabel);
		
		ConfirmText = new JTextField();
		ConfirmText.setColumns(10);
		ConfirmText.setBounds(214, 352, 189, 20);
		Basic_Information.add(ConfirmText);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 263, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuration");
		lblNewLabel.setBounds(0, 0, 263, 50);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New Label");
		label.setBounds(0, 52, 263, 93);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Basic Information");
		lblNewLabel_1.setBounds(76, 270, 127, 27);
		panel.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("Control Set selection");
		label_6.setBounds(76, 308, 127, 27);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Management scales");
		label_7.setBounds(76, 346, 127, 27);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Acceptance criteria");
		label_8.setBounds(76, 380, 127, 27);
		panel.add(label_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(264, 514, 720, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state =1 ;
				MoveTo(1);
				Referesh();
			}
		});
		button.setBounds(10, 5, 103, 23);
		button.setBackground(Color.WHITE);
		panel_1.add(button);
		
		button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state-=1;
				MoveTo(state);
			}
		});
		button_1.setBounds(150, 5, 103, 23);
		button_1.setEnabled(false);
		button_1.setBackground(Color.WHITE);
		panel_1.add(button_1);
		
		 button_2 = new JButton("Next");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(state ==1) {

					if(OrganisationText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Organisation Name");
					}else if(DisplayNameText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Display Name");
					}else if(EmailText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Email Address");
					}else if(UsernameText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Username");
					}else if(PasswordText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Enter Valid Password");
					}else if(ConfirmText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Basic_Information, "Please Confirm your Password");
					}else if(ConfirmText.getText().equals(PasswordText.getText())){
						AddToData();
						state=2;
						MoveTo(state);
						
					}else {
						ConfirmText.setText("");
						JOptionPane.showMessageDialog(Basic_Information, "Please check your password");
					}
				}
				else if(state==3){
					state+=1;
					MoveTo(state);
					int Likelihood = Calculate(LikeHood.getValue()/25+1,Impact.getValue()/25+1);
					
					MyComponent myComponent = new MyComponent(Likelihood);
					myComponent.setBounds(10, 5, 217, 211);
					panel_3.add(myComponent);
				}else{
					state+=1;
					MoveTo(state);
				}
			}
		});
		button_2.setBounds(313, 5, 110, 23);
		button_2.setBackground(Color.WHITE);
		panel_1.add(button_2);
		
		button_3 = new JButton("Finish");
		button_3.setBounds(593, 5, 89, 23);
		button_3.setEnabled(false);
		button_3.setBackground(Color.WHITE);
		panel_1.add(button_3);
	}
	public  void AddToData() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","1234");
			Statement st = con.createStatement();
			int rs = st.executeUpdate("insert into DEMODB.VSRISK values('"+OrganisationText.getText()+"','"+DisplayNameText.getText()+"','"+
			EmailText.getText()+"','"+UsernameText.getText()+"','"+PasswordText.getText()+"',0,0)");
			con.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void MoveTo(int i) {
		if(i==1) {		
			Basic_Information.setVisible(true);
			Management_Scales.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			button.setEnabled(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==3) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(true);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==2) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			Control_Set_Selection.setVisible(true);
			Acceptance_Criteria.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==4) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(true);
			button_1.setEnabled(true);
			button_3.setEnabled(true);
			button_2.setEnabled(false);
		}
	}
	private void Referesh() {
		OrganisationText.setText(null);
		DisplayNameText.setText(null);
		EmailText.setText(null);
		UsernameText.setText(null);
		PasswordText.setText(null);
		ConfirmText.setText(null);
	}
	private int Calculate(int Like, int Impact) {
		int selectedFormula = Formula.getSelectedIndex();
		
		switch(selectedFormula) {
		case 0:
			return Like+Impact;
			
		case 1:
			return Like-Impact;
			
		case 2:
			return Like+Impact-1;
			
		case 3:
			return Like-Impact-1;
		case 4:
			return Like*Impact;
		}
		return 0;
	}
}
class Part {
	   double value;
	   Color color;
	   
	   public Part(double value, Color color) {
	      this.value = value;
	      this.color = color;
	   }
	}
class MyComponent extends JComponent {
	   Part[] slices = { 
	      new Part(15, Color.yellow), new Part(30, Color.red)
	   }; 
	   MyComponent(int are) {
		   slices[0].value = are;
		   slices[1].value = 25-are;
	   }
	   public void paint(Graphics g) {
	      drawPie((Graphics2D) g, getBounds(), slices);
	   } 
	   void drawPie(Graphics2D g, Rectangle area, Part[] slices) {
	      double total = 0.0D;
	      for (int i = 0; i < slices.length; i++) {
	         total += slices[i].value;
	      } 
	      double curValue = 0.0D;
	      int startAngle = 0;
	      for (int i = 0; i < slices.length; i++) {
	         startAngle = (int) (curValue * 360 / total);
	         int arcAngle = (int) (slices[i].value * 360 / total);
	         
	         g.setColor(slices[i].color);
	         g.fillArc(area.x, area.y,200, 200, startAngle, arcAngle);
	         curValue += slices[i].value;
	      } 
	   }
	}
