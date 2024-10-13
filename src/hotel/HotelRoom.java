package hotel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JSeparator;

public class HotelRoom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRoomNumber;
	private JTextField txtRoomAmount;
	private JTextArea txtRoomDescription;
	private JLabel lblDescription;
	private JLabel lbRoomDetails;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HotelRoom frame = new HotelRoom();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HotelRoom() {
		setResizable(false);
		
		setTitle("Publish Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbFName = new JLabel("Room Number");
		lbFName.setBounds(31, 33, 149, 29);
		contentPane.add(lbFName);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(31, 58, 149, 45);
		contentPane.add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		JButton btnOkay = new JButton("Publish Room");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer roomNumber = Integer.parseInt(txtRoomNumber.getText()) ;
				
				Double amount = Double.parseDouble(txtRoomAmount.getText());
				
				String roomDescription = txtRoomDescription.getText();
				
				Room saveRoom = new Room(roomDescription, roomNumber, amount);
				saveRoom.publish();
			}
		});
		btnOkay.setBounds(31, 261, 624, 45);
		contentPane.add(btnOkay);
		
		JLabel lblLastName = new JLabel("Amount");
		lblLastName.setBounds(31, 140, 149, 29);
		contentPane.add(lblLastName);
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setBounds(31, 171, 149, 45);
		contentPane.add(txtRoomAmount);
		txtRoomAmount.setColumns(10);
		
		txtRoomDescription = new JTextArea();
		txtRoomDescription.setLineWrap(true);
		txtRoomDescription.setBounds(214, 58, 441, 158);
		contentPane.add(txtRoomDescription);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(214, 30, 94, 29);
		contentPane.add(lblDescription);
		
		lbRoomDetails = new JLabel("");
		lbRoomDetails.setBounds(31, 340, 624, 204);
		contentPane.add(lbRoomDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 318, 624, 10);
		contentPane.add(separator);
	}
}
