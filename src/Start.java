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
import jxl.Workbook;
import java.io.File;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
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
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;

public class Start extends JFrame {

	private JPanel contentPane;
	private JTextField OrganisationText;
	private JTextField DisplayNameText;
	private JTextField EmailText;
	private JTextField UsernameText;
	private JPasswordField PasswordText;
	private JPasswordField ConfirmText;
	private JPanel Basic_Information;
	private JPanel Management_Scales;
	private JPanel Acceptance_Criteria; 
	private JPanel Control_Set_Selection;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private static int state =1;      
	private JComboBox Formula ;
	private JPanel RiskCalculator;
	private Border border;
	private JSpinner CL;
	private JSpinner II;
	private JSpinner IL;
	private JSpinner AI;
	private JSpinner AL;
	private int FormulaToRisk;
	private JSpinner CI;
	private JButton DownloadExcel;
	private JSlider LikeHood;
	private JSlider Impact_1;
	private int row=0;
	/* *
	 * state value for page direction 
	 * 1 ==> Basic Information
	 * 2 ==> Control set selection
	 * 3 ==> Management scales
	 * 4 ==> AAcceptance criteria
	 * 
	 * FormulaToRisk
	 * 0==>L+I
	 * 1==>L-I
	 * 2==>L+I-1
	 * 3==>L-I-1
	 * 4==>L*I
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
		
		border = BorderFactory.createLineBorder(Color.black, 1, true);
		
		Control_Set_Selection = new JPanel();
		Control_Set_Selection.setBackground(Color.WHITE);
		Control_Set_Selection.setVisible(false);
		
		Management_Scales = new JPanel();
		Management_Scales.setBackground(Color.WHITE);
		Management_Scales.setVisible(false);
		
		Basic_Information = new JPanel();
		Basic_Information.setBackground(Color.WHITE);
		Basic_Information.setBounds(264, 0, 720, 513);
		Basic_Information.setVisible(true);
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
		
		PasswordText = new JPasswordField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(214, 310, 189, 20);
		Basic_Information.add(PasswordText);
		
		JLabel ConfrimLabel = new JLabel("Confirm:");
		ConfrimLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ConfrimLabel.setBounds(128, 348, 86, 31);
		Basic_Information.add(ConfrimLabel);
		
		ConfirmText = new JPasswordField();
		ConfirmText.setColumns(10);
		ConfirmText.setBounds(214, 352, 189, 20);
		Basic_Information.add(ConfirmText);
		

		RiskCalculator = new JPanel();
		RiskCalculator.setBackground(Color.WHITE);
		RiskCalculator.setBounds(264, 0, 720, 513);
		contentPane.add(RiskCalculator);
		RiskCalculator.setVisible(false);
		RiskCalculator.setLayout(null);
		
		JLabel label_18 = new JLabel("Risk Details");
		label_18.setBounds(55, 33, 162, 33);
		RiskCalculator.add(label_18);
		
		JLabel lblRisk = new JLabel("Risk");
		lblRisk.setBounds(55, 89, 73, 22);
		RiskCalculator.add(lblRisk);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(138, 90, 508, 22);
		
		comboBox.addItem("Hardware: Breach of information system maintainability caused by insufficient maintenance of storage media.");
		comboBox.addItem("Hardware: Destruction of equipment or media caused by lack of periodic replacement schemes.");
		comboBox.addItem("Hardware: Dust, corrosion, freezing caused by susceptibility to humidity, dust, soiling.");
		comboBox.addItem("Hardware: Electromagnetic radiation caused by sensitivity to electromagnetic radiation.");
		comboBox.addItem("Hardware: Error in use caused by lack of efficient configuration change control.");
		
		
		
		comboBox.addItem("Software: Abuse of rights caused by lack of audit trail.");
		comboBox.addItem("Software: Error in use caused by complicated user interface.");
		comboBox.addItem("Software: Corruption of data caused by widely distributed software.");
		comboBox.addItem("Software: Error in use caused by lack of documentation.");
		comboBox.addItem("Software: Error in use caused by incorrect dates.");
		
		
		comboBox.addItem("Network: Denial of actions caused by lack of proof of sending or receiving a message.");
		comboBox.addItem("Network: Evesdropping caused by unprotected communication lines.");
		comboBox.addItem("Network: Evesdropping caused by unprotected sensitive traffic.");
		comboBox.addItem("Network: Remotes spying caused by insecured network architecture.");
		comboBox.addItem("Network: Failure of tele-communication equipment caused by poor joint cabling.");
		

comboBox.addItem("Personnel: Error in use caused by lack of security awareness.");
comboBox.addItem("Personnel: Theft of media caused by unsupervised work by outside or cleaning staff.");
comboBox.addItem("Personnel: Illegal processing of data caused by lack of monitoring mechanisms.");


comboBox.addItem("Site: Flood caused by location in an area susceptible to flood.");
comboBox.addItem("Site: Loss of power supply caused by unstable power grid.");
comboBox.addItem("Site: Theft of equipment caused by lack of physical protection of the building, doors and windows.");



comboBox.addItem("Organization: Abuse of rights caused by lack of regular audits.");
comboBox.addItem("Organization: Abuse of rights caused by lack of procedure of monitoring of information processing facilities.");
comboBox.addItem("Organization: Abuse of rights caused by lack of formal procedure for user registration and de-registration.");
comboBox.addItem("Organization: Abuse of rights caused by lack of formal process for access right review.");
comboBox.addItem("Organization: Unauthorized use of equipment caused by lack of regular management reviews.");

		
		RiskCalculator.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Compromises");
		lblNewLabel_5.setBounds(55, 171, 99, 22);
		RiskCalculator.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(border);
		panel_4.setBounds(189, 171, 309, 186);
		RiskCalculator.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblC = new JLabel("C");
		lblC.setBorder(border);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(31, 11, 55, 43);
		panel_4.add(lblC);
		
		JLabel lblI_1 = new JLabel("I");
		lblI_1.setBorder(border);
		lblI_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblI_1.setBounds(135, 11, 55, 43);
		panel_4.add(lblI_1);
		
		JLabel lblA = new JLabel("A");
		lblA.setBorder(border);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(231, 11, 55, 43);
		panel_4.add(lblA);
		
		JCheckBox Check_C = new JCheckBox("New check box");
		Check_C.setVerticalAlignment(SwingConstants.TOP);
		Check_C.setBounds(48, 61, 21, 23);
		panel_4.add(Check_C);
		
		JCheckBox Check_I = new JCheckBox("New check box");
		Check_I.setVerticalAlignment(SwingConstants.TOP);
		Check_I.setBounds(152, 60, 21, 23);
		panel_4.add(Check_I);
		
		JCheckBox Check_A = new JCheckBox("New check box");
		Check_A.setVerticalAlignment(SwingConstants.TOP);
		Check_A.setBounds(248, 61, 21, 23);
		panel_4.add(Check_A);
		
		CI = new JSpinner();
		CI.setBackground(Color.WHITE);
		CI.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		CI.setBounds(48, 111, 38, 20);
		panel_4.add(CI);
		
		CL = new JSpinner();
		CL.setBackground(Color.WHITE);
		CL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		CL.setBounds(47, 147, 39, 20);
		panel_4.add(CL);
		
		II = new JSpinner();
		II.setBackground(Color.WHITE);
		
			II.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			II.setBounds(151, 111, 39, 20);
			panel_4.add(II);
			
			IL = new JSpinner();
			IL.setBackground(Color.WHITE);
			IL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			IL.setBounds(150, 147, 40, 20);
			panel_4.add(IL);
			
			AI = new JSpinner();
			AI.setBackground(Color.WHITE);
			AI.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			AI.setBounds(248, 111, 38, 20);
			panel_4.add(AI);
			
			AL = new JSpinner();
			AL.setBackground(Color.WHITE);
			AL.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			AL.setBounds(247, 147, 39, 20);
			panel_4.add(AL);
			
			JLabel lblI = new JLabel("I");
			lblI.setBounds(10, 113, 22, 14);
			panel_4.add(lblI);
			lblI.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblI.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblL = new JLabel("L");
			lblL.setHorizontalAlignment(SwingConstants.CENTER);
			lblL.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblL.setBounds(10, 150, 22, 14);
			panel_4.add(lblL);
			
			JLabel RiskRatingLabel = new JLabel("Risk Rating     =");
			RiskRatingLabel.setBounds(55, 403, 99, 22);
			RiskCalculator.add(RiskRatingLabel);
			
			JLabel RiskRatingText = new JLabel("");
			RiskRatingText.setBounds(145, 403, 117, 22);
			RiskCalculator.add(RiskRatingText);
			
			JButton btnCalculate = new JButton("Calculate");
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!Check_C.isSelected()&&!Check_I.isSelected()&&!Check_A.isSelected()) {
						JOptionPane.showMessageDialog(contentPane,"Please Select anyone of Compromises");
					}else {
						int Risk = RiskCal();
						RiskRatingText.setText(String.valueOf(Risk));
						DownloadExcel.setVisible(true);
					}
				}

				private int RiskCal() {
					int sum=0;
					if(Check_C.isSelected()) {
						sum+= Calculate((int)CI.getValue(),(int)CL.getValue());
				//		System.out.println(sum);
					}
					if(Check_I.isSelected()) {
						sum+= Calculate((int)II.getValue(),(int)IL.getValue());
				//		System.out.println(sum);
					}
					if(Check_A.isSelected()) {
						sum+= Calculate((int)AI.getValue(),(int)AL.getValue());
						//System.out.println(sum);
					}
					return sum;
				}
			});
			btnCalculate.setBackground(Color.WHITE);
			btnCalculate.setBorder(border);
			btnCalculate.setBounds(517, 318, 129, 49);
			RiskCalculator.add(btnCalculate);
			
			DownloadExcel = new JButton("CreateExcel");
			DownloadExcel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//	JFileChooser jf = new JFileChooser();
					//jf.showOpenDialog(contentPane);
					GenerateExcel();
				}

			});
			DownloadExcel.setBorder(border);
			DownloadExcel.setVisible(false);
			DownloadExcel.setBackground(Color.WHITE);
			DownloadExcel.setBounds(517, 415, 129, 49);
			RiskCalculator.add(DownloadExcel);
		
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
		
		LikeHood = new JSlider();
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
		
		Impact_1 = new JSlider();
		Impact_1.setBackground(Color.WHITE);
		Impact_1.setBounds(171, 297, 446, 26);
		Impact_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Impact_1.getValue()<=12) {
					Impact_1.setValue(0);
					
				}else if(Impact_1.getValue()>12&&Impact_1.getValue()<37)
				{
					Impact_1.setValue(25);
				}
				else if(Impact_1.getValue()>32&&Impact_1.getValue()<62){
					Impact_1.setValue(50);
				}
				else if(Impact_1.getValue()>62&&Impact_1.getValue()<87){
					Impact_1.setValue(75);
				}else {
					Impact_1.setValue(100);
				}
			}
		});
		Management_Scales.add(Impact_1);
		
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
					int Likelihood = Calculate(LikeHood.getValue()/25+1,Impact_1.getValue()/25+1);
					
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
	private void GenerateExcel() {
		String filename = "RiskData.xls";
		try {
			WritableWorkbook ww = Workbook.createWorkbook(new File(filename));
			WritableSheet sh = ww.createSheet("sheet1",0);

			sh.addCell(new Label(0,0,"Organisation"));
			sh.addCell(new Label(0,row,OrganisationText.getText()));
			sh.addCell(new Label(1,0,"Display Name"));
			sh.addCell(new Label(1,row,DisplayNameText.getText()));
			sh.addCell(new Label(2,0,"UserName"));
			sh.addCell(new Label(2,row,UsernameText.getText()));
			sh.addCell(new Label(3,0,"Likelihood"));
			sh.addCell(new Label(3,row,String.valueOf(LikeHood.getValue())));
			sh.addCell(new Label(4,0,"Impact"));
			sh.addCell(new Label(4,row,String.valueOf(Impact_1.getValue())));
			sh.addCell(new Label(5,0,"Confidentiality LikeliHood"));
			sh.addCell(new Label(5,row,String.valueOf(CL.getValue())));
			sh.addCell(new Label(6,0,"Confidentiality Impact"));
			sh.addCell(new Label(6,row,String.valueOf(CI.getValue())));
			sh.addCell(new Label(7,0,"Integrity LikeliHood"));
			sh.addCell(new Label(7,row,String.valueOf(IL.getValue())));
			sh.addCell(new Label(8,0,"Integrity Impact"));
			sh.addCell(new Label(8,row,String.valueOf(II.getValue())));
			sh.addCell(new Label(9,0,"Availability LikeliHood"));
			sh.addCell(new Label(9,row,String.valueOf(AL.getValue())));
			sh.addCell(new Label(10,0,"Availability Impact"));
			sh.addCell(new Label(10,row,String.valueOf(AI.getValue())));
			row++;
			ww.write();
			ww.close();
			
		}catch(Exception e) {
			
		}
		
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
			RiskCalculator.setVisible(false);
			Management_Scales.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			button.setEnabled(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(false);
		}else if(i==3) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(true);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==2) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(true);
			Acceptance_Criteria.setVisible(false);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==4) {		
			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(false);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(true);
			button_1.setEnabled(true);
			button_3.setEnabled(false);
			button_2.setEnabled(true);
		}else if(i==5) {

			Basic_Information.setVisible(false);
			Management_Scales.setVisible(false);
			RiskCalculator.setVisible(true);
			Control_Set_Selection.setVisible(false);
			Acceptance_Criteria.setVisible(false);
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
		FormulaToRisk = Formula.getSelectedIndex();
		
		switch(FormulaToRisk) {
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
