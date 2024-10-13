package hotel;

//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class HotelRoom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRoomNumber;
	private JTextField txtRoomAmount;
	private JTextArea txtRoomDescription;
	private JLabel lblDescription;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

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
		
		setTitle("Publish Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbRoomNumber = new JLabel("Room Number");
		lbRoomNumber.setBounds(31, 33, 149, 29);
		contentPane.add(lbRoomNumber);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(31, 58, 149, 45);
		contentPane.add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		JLabel lbAmount = new JLabel("Amount");
		lbAmount.setBounds(31, 140, 149, 29);
		contentPane.add(lbAmount);
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setBounds(31, 171, 149, 45);
		contentPane.add(txtRoomAmount);
		txtRoomAmount.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(214, 58, 441, 158);
		contentPane.add(scrollPane_1);
		
		txtRoomDescription = new JTextArea();
		scrollPane_1.setViewportView(txtRoomDescription);
		txtRoomDescription.setRows(1000);
		txtRoomDescription.setWrapStyleWord(true);
		txtRoomDescription.setLineWrap(true);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(214, 30, 94, 29);
		contentPane.add(lblDescription);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 318, 624, 10);
		contentPane.add(separator);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 346, 624, 219);
		contentPane.add(scrollPane);
		
		JTextPane lbRoomDetails = new JTextPane();
		lbRoomDetails.setEditable(false);
		scrollPane.setViewportView(lbRoomDetails);
		
		
		JButton btnPublish = new JButton("Publish Room");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer roomNumber = Integer.parseInt(txtRoomNumber.getText()) ;
				
				Double amount = Double.parseDouble(txtRoomAmount.getText());
				
				String roomDescription = txtRoomDescription.getText();
				
				Room saveRoom = new Room(roomDescription, roomNumber, amount);
				String savedDetails = saveRoom.publish();
				System.out.println(savedDetails);
				lbRoomDetails.setText(savedDetails);
				
			}
		});
		btnPublish.setBounds(31, 261, 624, 45);
		contentPane.add(btnPublish);
		


	}
}
