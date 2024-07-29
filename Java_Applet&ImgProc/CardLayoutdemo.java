import java.awt.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
<applet code="CardLayoutdemo" width=600 height=300>
</applet>
*/
public class CardLayoutdemo extends Applet implements ActionListener,MouseListener
{
	Checkbox win10 , win11 ,mac ,linux;
	Panel oscard;
	CardLayout clo;
	Button win,other;
	public void init()
	{
		win = new Button("Windows");
		other = new Button("Other");
		add(win);
		add(other);
		clo =new CardLayout();
		oscard = new Panel();
		oscard.setLayout(clo); 
		// set panel layout to card layout
		win10 = new Checkbox("Windows 10",null,true);
		win11 = new Checkbox("Windows 11");
		mac = new Checkbox("MAC OS");
		linux = new Checkbox("Linux"); 
		
		// add windows checkboxes to a panel
		Panel winpan = new Panel();
		winpan.add(win10);
		winpan.add(win11); 
		//add other os checkboxes to panel
		Panel otherpan = new Panel();
		otherpan.add(mac);
		otherpan.add(linux); 
		// add panel to cut deck panel
		oscard.add(winpan,"Windows");
		oscard.add(otherpan,"Other");
		// add cards to main applet panel
		add(oscard);
		//register to receive action events
		win.addActionListener(this);
		other.addActionListener(this);
		//register mouse events
		addMouseListener(this);
		
		
	}
	//cycle through panels
	public void mousePressed(MouseEvent m)
	{
		clo.next(oscard);
		
	}
	//provide empty implementation on other mouseListener methods
	public void mouseClicked(MouseEvent me)
	{
		
	}
	public void mouseEntered(MouseEvent me)
	{
		
	}
	public void mouseExited(MouseEvent me)
	{
		
	}
	public void mouseReleased(MouseEvent me)
	{
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if 
		(ae.getSource()== win )
		{
			clo.show(oscard,"Windows");
		}
		else
		{
			clo.show(oscard,"Other");
		}	
	}
}