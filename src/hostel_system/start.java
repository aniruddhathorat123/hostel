package hostel_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class start
{
	public static void main(String args[])
	{
		JFrame main_frame = new JFrame("Hostel Management System");
		JTabbedPane tb = new JTabbedPane();
		JPanel panel1 = new JPanel();
		main_frame.setSize(1000,1000);
		main_frame.setLayout(new BorderLayout());
		
		panel1.setLayout(new BorderLayout());
		tb.addTab("View Record", new view_rec());
		tb.addTab("Insert Record", new insert_rec());
		tb.addTab("Update Record", new update_rec());
		tb.addTab("Delete Record", new delete_rec());
		
		panel1.add(tb);
		main_frame.add(panel1,BorderLayout.NORTH);
		main_frame.setVisible(true);
	}
}

class view_rec extends JPanel implements ActionListener
{
	JTable view_table;
	String data[][];
	JButton refresh = new JButton("Refresh");
	int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	JScrollPane scroll = new JScrollPane(view_table , v ,h);
	String columns[]  = {"ID","NAME","ROOM_NO","ROLLNO"};
	

	view_rec()
	{
		int w = this.getWidth();
		int h = this.getHeight();
		setLayout(new BorderLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//view_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setPreferredSize(new Dimension(screenSize.width,(screenSize.height-135)));
		add(refresh,BorderLayout.SOUTH);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","mysql");
			Statement stmt=con.createStatement();
			int nos=stmt.executeUpdate("select * from hostel_data");

			data = new String[nos][4];
			
			ResultSet rs = stmt.executeQuery("hostel_data");
			while(rs.next())
			{
				for(int i=0;i<nos;i++)
				{
					data[i][0] = rs.getString(1);
					data[i][1] = rs.getString(2);
					data[i][2] = rs.getString(3);
					data[i][3] = rs.getString(4);
				}
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		view_table = new JTable(data,columns);
		view_table.setSize(w,h);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}

class insert_rec extends JPanel implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class update_rec extends JPanel implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class delete_rec extends JPanel implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}