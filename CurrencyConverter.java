import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CurrencyConverter extends JApplet
{
	JLabel l1,l2,l3;
	JTextField t1;
	String[] currency={"USD","Yen","Euro"};
	JComboBox select;
	Container cp;
	JButton b1,b2;
	public void init()
	{
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		l1=new JLabel("Enter amount in INR: ");
		l2=new JLabel("Select any currency to convert: ");
		l3=new JLabel();
		b1=new JButton("Convert");
		b2=new JButton("Reset");
		b1.setEnabled(false);
		t1=new JTextField(20);
		select=new JComboBox(currency);
		select.setSelectedIndex(0);
		cp.add(l1);
		cp.add(t1);
		cp.add(l2);
		cp.add(select);
		cp.add(b1);
		cp.add(b2);
		cp.add(l3);
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e) 
			{ 
				 if(t1.getText().length() == 0)
				 {
					b1.setEnabled(false);
				 }
				else
				{
					b1.setEnabled(true);
				}
			}
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				t1.setText("");
				l3.setText("");
				b1.setEnabled(false);
			}
		});
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					
					double d;
					String s=(String)select.getSelectedItem();
					if(s=="USD")
					{
						String s1=t1.getText();
						double x=Double.parseDouble(s1);
						d=x/68.52;
						l3.setText("Converted Amount is "+d+"");
					}
					else if(s=="Yen")
					{
						String s1=t1.getText();
						double x=Double.parseDouble(s1);
						d=x/0.62;
						l3.setText("Converted Amount is "+d+"");
					}
					else if(s=="Euro")
					{
						String s1=t1.getText();
						double x=Double.parseDouble(s1);
						d=x/79.36;
						l3.setText("Converted Amount is "+d+"");
					}
					else
					{
						l3.setText("Converted Amount");
					}
			
			}
		});
	}
}
//<applet code="CurrencyConverter" height=200 width=270></applet>