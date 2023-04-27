package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.LopHocDAO;
import entity.LopHoc;

public class gui extends JFrame implements ActionListener, MouseListener{
	
	private JTextField txtMaLop, txtTenLop, txtSiSo;
	private String[] cols = {"Mã lớp" , "Tên lớp", "Sỉ số"};
	private JTable table;
	private DefaultTableModel model;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXemTT;
	private LopHocDAO lophoc;
	public gui() {
		//Khởi tạo kết nối
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Thông tin lớp học");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 380);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		
		JPanel pnSouth, pnCenter, pnNorth;
		add(pnNorth = new JPanel(), BorderLayout.NORTH);
		add(pnCenter = new JPanel(), BorderLayout.CENTER);
		add(pnSouth = new JPanel(), BorderLayout.SOUTH);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnNorth.add(new JLabel("Thông tin lớp học"));
		
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		pnCenter.add(pane);
		pane.setPreferredSize(new Dimension(670, 170));
		
		JPanel pnbtn = new JPanel();
		pnbtn.add(new JButton("<<"));
		pnbtn.add(new JButton("<"));
		pnbtn.add(new JButton(">"));
		pnbtn.add(new JButton(">>"));
		pnCenter.add(pnbtn);
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnMa.add(new JLabel("Mã lớp: "));
		pnMa.add(txtMaLop = new JTextField(20));
		pnMa.add(new JLabel());
		pnCenter.add(pnMa);

		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnTen.add(new JLabel("Tên lớp: "));
		pnTen.add(txtTenLop = new JTextField(55));
		pnCenter.add(pnTen);
		
		JPanel pnsiso = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnsiso.add(new JLabel("Sỉ số: "));
		pnsiso.add(txtSiSo = new JTextField(8));
		txtSiSo.setEditable(false);
		pnCenter.add(pnsiso);
		
		//load dữ liệu lên table
		lophoc = new LopHocDAO();
		int i =0;
		for(LopHoc lh : lophoc.getAllLopHoc()) {
			int[] siso = lophoc.siso();
			Object[] obj = {lh.getMaLop(), lh.getTenLop(), siso[i]};
			i += 1;
			model.addRow(obj);
		}
		
		pnSouth.add(btnThem = new JButton("Thêm"));
		pnSouth.add(btnLuu = new JButton("Lưu"));
		pnSouth.add(btnSua = new JButton("Sửa"));
		pnSouth.add(btnXoa = new JButton("Xóa"));
		pnSouth.add(btnXemTT = new JButton("Xem thông tin sinh viên"));
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemTT.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			
		}
		if(o.equals(btnLuu)) {
			
		}
		
		if(o.equals(btnSua)) {
			
		}
		
		if(o.equals(btnXoa)) {
			
		}
		
		if(o.equals(btnXemTT)) {
			
		}
	}

	public void loadDateToText(LopHoc item) {
		txtMaLop.setText(item.getMaLop());
		txtTenLop.setText(item.getTenLop());
		txtSiSo.setText(lophoc.siSo1Lop(item.getMaLop()));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			LopHoc ee = lophoc.getAllLopHoc().get(row);
			loadDateToText(ee);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
