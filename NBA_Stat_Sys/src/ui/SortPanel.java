package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortPanel extends JPanel{
	private JTextField criteriatF;
	public SortPanel(String category){
		this.setBounds(200, 100, 692, 450);
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 81, 535, 305);
		add(scrollPane);
		
		JLabel criterialbl = new JLabel("排序依据");
		criterialbl.setBounds(99, 37, 57, 15);
		add(criterialbl);
		
		criteriatF = new JTextField();
		criteriatF.setBounds(158, 34, 287, 21);
		add(criteriatF);
		criteriatF.setColumns(10);
		
		JButton upSortbtn = new JButton("U");
		upSortbtn.setBounds(455, 33, 22, 23);
		add(upSortbtn);
		
		JButton downSortbtn = new JButton("D");
		downSortbtn.setBounds(478, 33, 22, 23);
		add(downSortbtn);
		
		JButton btnSort = new JButton("排序");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSort.setBounds(525, 33, 93, 23);
		add(btnSort);
		

		
		
		if(category=="player"){
			JButton screeningbtn = new JButton("显示前50");
			screeningbtn.setBounds(525, 406, 93, 23);
			add(screeningbtn);
		}
		if(category=="team"){}
		
		
	}
}
