package FormDangKy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ThongTinDangKy extends JFrame implements ActionListener, ItemListener, FocusListener {

	JLabel lblNhapTen, lblDiaChi;
	JTextArea txtDiachi;
	JTextField txtHoTen;
	JCheckBox cbDiBoi, cbXemPhim;
	JRadioButton rdNam, rdNu;
	JScrollPane scrollPane;
	JButton btnXacNhan;
	ButtonGroup btnGroup;
	String checkSoThich = "";
	String checkGioiTinh = "";
	String pattern = "^[a-zA-Z ]+";
	boolean checkText = false;

	public ThongTinDangKy(String title) {
		super(title);

		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		addConTrolls();
	}

	private void addConTrolls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 500, 400);
		this.add(pnMain);

		JPanel pnThongTin = new JPanel();
		pnThongTin.setBounds(0, 0, 500, 200);
		Border boder = BorderFactory.createLineBorder(Color.BLACK);

		TitledBorder titleBorder = BorderFactory.createTitledBorder(boder, "Thong Tin",
				TitledBorder.DEFAULT_JUSTIFICATION, 0, new Font("Tahoma", Font.BOLD, 20), Color.RED);
		// TitledBorder titleBoder = BorderFactory.createTitledBorder(boder,
		// "Thong Tin");
		pnThongTin.setBorder(titleBorder);

		JPanel pnNhapTen = new JPanel();
		lblNhapTen = new JLabel("Nhap Ho Ten :");
		txtHoTen = new JTextField(20);
		txtHoTen.addFocusListener(this);
		pnNhapTen.add(lblNhapTen);
		pnNhapTen.add(txtHoTen);

		JPanel pnDiaChi = new JPanel();
		lblDiaChi = new JLabel("Dia chi :");
		txtDiachi = new JTextArea(5, 20);
		scrollPane = new JScrollPane(txtDiachi);
		scrollPane.setAutoscrolls(true);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(scrollPane);

		pnThongTin.add(pnNhapTen);
		pnThongTin.add(pnDiaChi);

		JPanel pnSothich = new JPanel();
		pnSothich.setLayout(new BoxLayout(pnSothich, BoxLayout.Y_AXIS));
		TitledBorder boderSoThich = BorderFactory.createTitledBorder(boder, "So Thich");
		pnSothich.setBorder(boderSoThich);
		pnSothich.setBounds(0, 200, 250, 100);

		cbDiBoi = new JCheckBox("Di Boi");
		cbXemPhim = new JCheckBox("Xem Phim");
		cbDiBoi.addItemListener(this);
		cbXemPhim.addItemListener(this);

		pnSothich.add(cbDiBoi);
		pnSothich.add(cbXemPhim);

		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new BoxLayout(pnGioiTinh, BoxLayout.Y_AXIS));
		TitledBorder boderGioiTinh = BorderFactory.createTitledBorder(boder, "Gioi Tinh");
		pnGioiTinh.setBorder(boderGioiTinh);
		pnGioiTinh.setBounds(250, 200, 250, 100);
		btnGroup = new ButtonGroup();
		rdNam = new JRadioButton("Nam");
		rdNu = new JRadioButton("Nu");

		btnGroup.add(rdNam);
		btnGroup.add(rdNu);
		rdNam.addActionListener(this);
		rdNu.addActionListener(this);

		pnGioiTinh.add(rdNam);
		pnGioiTinh.add(rdNu);

		btnXacNhan = new JButton("OK");
		btnXacNhan.setBounds(380, 310, 100, 20);
		btnXacNhan.addActionListener(this);

		pnMain.add(pnThongTin);
		pnMain.add(pnSothich);
		pnMain.add(pnGioiTinh);
		pnMain.add(btnXacNhan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnXacNhan)) {
			if (checkText) {
				JOptionPane
						.showMessageDialog(null,
								txtHoTen.getText().toString() + "\n" + txtDiachi.getText().toString() + "\n"
										+ checkSoThich + "\n" + checkGioiTinh,
								"Thong Bao", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Xem Lai Thong Tin Nhap");
			}
		} else if (rdNam.isSelected()) {
			checkGioiTinh = rdNam.getText();
		} else if (rdNu.isSelected()) {
			checkGioiTinh = rdNu.getText();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable().equals(cbDiBoi)) {
			checkSoThich += cbDiBoi.getText();
		} else if (e.getItemSelectable().equals(cbXemPhim)) {
			checkSoThich += cbXemPhim.getText();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(txtHoTen)) {
			if (txtHoTen.getText().matches(pattern) && !txtHoTen.getText().isEmpty()) {
				checkText = true;
			} else {
				checkText = false;
				JOptionPane.showMessageDialog(null, "Ho ten khong duoc nhap so va bo trong", "Thong Bao",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
