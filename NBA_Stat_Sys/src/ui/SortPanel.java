package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

public class SortPanel extends JPanel {
	private JTextField criteriatF;
    JFrame mainFrame;
	public SortPanel(String category,JFrame mainFrame) {
		this.mainFrame=mainFrame;
		this.setBounds(0,0, 692, 450);
		this.setVisible(true);
	    this.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 75, 517, 284);
		this.add(scrollPane);

		JLabel criterialbl = new JLabel("排序依据");
		criterialbl.setBounds(99, 37, 57, 15);
		this.add(criterialbl);

		criteriatF = new JTextField();
		criteriatF.setBounds(158, 34, 287, 21);
		this.add(criteriatF);
		criteriatF.setColumns(10);

		JButton upSortbtn = new JButton("U");
		upSortbtn.setBounds(455, 33, 22, 23);
		this.add(upSortbtn);

		JButton downSortbtn = new JButton("D");
		downSortbtn.setBounds(478, 33, 22, 23);
		this.add(downSortbtn);
		
		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e->back());
		this.add(backbtn);

		if (category == "player") {
			JButton btnSort = new JButton("排序");
			btnSort.addActionListener(e -> sortPlayer());
			btnSort.setBounds(525, 33, 88, 23);
			this.add(btnSort);

			JButton screeningbtn = new JButton("显示前50");
			screeningbtn.setBounds(525, 366, 88, 23);
			screeningbtn.addActionListener(e -> showTopFifty());
			this.add(screeningbtn);

		}
		if (category == "team") {
			JButton btnSort = new JButton("排序");
			btnSort.addActionListener(e -> sortTeam());
			btnSort.setBounds(525, 33, 88, 23);
			this.add(btnSort);
		}
		mainFrame.add(this);

	}
	public void sortPlayer(){
		
	}
	public void showTopFifty(){
		
	}
	public void sortTeam(){		
		
	}
	public void back(){
	    this.setVisible(false);
		StartPanel sp=new StartPanel(mainFrame);
		mainFrame.add(sp);
	}
}
