import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaPhuongTrinh extends JFrame implements ActionListener, FocusListener {

	JLabel lblTitle, lblHeSoa, lblHeSob, lblKetQua, lblError;
	JButton btnGia, btnThoat, btnHelp;
	JTextField txtHeSoa, txtHeSob, txtKetQua;
	String pattern = "\\d{1,2}";
	boolean checkFlag = false;

	public GiaPhuongTrinh(String title) {
		super(title);

		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addControls();
	}

	private void addControls() {

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		this.add(pnMain);

		// set Title
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Gia Phuong Trinh Bac 1");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		// end setTitle

		// set He so a
		JPanel pnHeSoa = new JPanel();
		lblHeSoa = new JLabel("He so a :");
		txtHeSoa = new JTextField(20);
		txtHeSoa.addFocusListener(this);
		pnHeSoa.add(lblHeSoa);
		pnHeSoa.add(txtHeSoa);
		pnMain.add(pnHeSoa);

		// end set He so a

		// set He so b
		JPanel pnHeSob = new JPanel();
		lblHeSob = new JLabel("He so b :");
		txtHeSob = new JTextField(20);
		txtHeSob.addFocusListener(this);
		pnHeSob.add(lblHeSob);
		pnHeSob.add(txtHeSob);
		pnMain.add(pnHeSob);
		// end set he so b

		// set Button
		JPanel pnButton = new JPanel();
		btnGia = new JButton("Gia");
		btnThoat = new JButton("Thoat");
		btnHelp = new JButton("Help");

		pnButton.add(btnGia);
		pnButton.add(btnThoat);
		pnButton.add(btnHelp);
		pnMain.add(pnButton);

		btnGia.addActionListener(this);
		btnThoat.addActionListener(this);
		btnHelp.addActionListener(this);
		// end set Button

		// set Ket qua
		JPanel pnKetQua = new JPanel();
		lblKetQua = new JLabel("Ket Qua :");
		txtKetQua = new JTextField(20);
		txtKetQua.setEditable(false);
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetQua);
		pnMain.add(pnKetQua);

		// end set Ket qua
		// set Error
		// JPanel pnError = new JPanel();
		// lblError = new JLabel();
		// lblError.setForeground(Color.RED);
		// pnError.add(lblError);
		// pnMain.add(pnError);
		// end Error

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object buttonClicked = e.getSource();
		if (buttonClicked.equals(btnGia)) {
			if (txtHeSoa.getText().toString().isEmpty() || txtHeSob.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui long xem lai!!!", "Thong Bao", JOptionPane.ERROR_MESSAGE);
			} else {
				if (checkFlag) {

					double soA = Double.parseDouble(txtHeSoa.getText().toString().trim());
					double soB = Double.parseDouble(txtHeSob.getText().toString().trim());

					if (soA == 0 && soB == 0) {
						txtKetQua.setText("Phuong Trinh Vo So Nghiem");
					} else if (soA == 0 || soB == 0) {
						txtKetQua.setText("Phuong Trinh Vo Nghiem");
					} else {
						PhuongTrinh PT = new PhuongTrinh(soA, soB);
						txtKetQua.setText(String.valueOf(PT.Gia()));
					}

				} else {
					JOptionPane.showMessageDialog(null, "Vui long xem lai!!!", "Thong Bao", JOptionPane.ERROR_MESSAGE);
				}
			}

		} else if (buttonClicked.equals(btnHelp)) {
			JOptionPane.showMessageDialog(null, "Dang Cap Nhat!!!!", "Thong Bao", JOptionPane.INFORMATION_MESSAGE);
		} else if (buttonClicked.equals(btnThoat)) {
			System.exit(0);
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		// do SomeThing
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(txtHeSoa)) {
			if (txtHeSoa.getText().matches(pattern) && !txtHeSoa.getText().isEmpty()) {
				checkFlag = true;
			} else {
				checkFlag = false;
				JOptionPane.showMessageDialog(null, "He so khong duoc bo trong va khong nhap ky tu", "Thong Bao",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource().equals(txtHeSob) && !txtHeSob.getText().isEmpty()) {
			if (txtHeSob.getText().matches(pattern)) {
				checkFlag = true;
			} else {
				checkFlag = false;
			}
		}

	}
}
