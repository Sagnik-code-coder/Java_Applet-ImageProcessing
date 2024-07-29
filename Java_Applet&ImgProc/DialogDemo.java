import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//import java.util.*;
//import javax.swing.*;

/*
<applet code="DialogDemo" width=500 height=300>
<param name = width value=400>
<param name = height value=200>
</applet>
*/
//Create a subclass of dialog
class SampleDialog extends Dialog implements ActionListener
{
	SampleDialog(Frame parent, String title)
	{
		super(parent,title,false);
		setLayout(new FlowLayout());
		setSize(300,200);
		add(new Label("Press this button:"));
		Button b;
		add(b=new Button("Cancel"));
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
	public void paint(Graphics g)
	{
		g.drawString("This is in Dialog box",10,70);
	}
}
class MenuFrame extends Frame
{
	String msg = "";
	CheckboxMenuItem debug,test;
	MenuFrame (String title)
	{
		super(title);
		//create MenuBar added to Frame
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		//create the menu item
		Menu file = new Menu("File");
		MenuItem item1,item2,item3,item4;
		file.add(item1= new MenuItem("New..."));
		file.add(item2= new MenuItem("Open..."));
		file.add(item3= new MenuItem("Close"));
		file.add(new MenuItem("-"));
		file.add(item4= new MenuItem("Quit..."));
		mbar.add(file);
		
		Menu edit = new Menu("Edit");
		MenuItem item5,item6,item7;
		edit.add(item5= new MenuItem("Cut"));
		edit.add(item6= new MenuItem("Copy"));
		edit.add(item7= new MenuItem("Paste"));
		edit.add(new MenuItem("-"));

		Menu sub = new Menu("Special",true);
		MenuItem item8,item9,item10;
		sub.add(item8= new MenuItem("First"));
		sub.add(item9= new MenuItem("Second"));
		sub.add(item10= new MenuItem("Third"));
		edit.add(sub);
		
		// These are Checkable MenuItems.
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);
		test= new CheckboxMenuItem("Testing");
		edit.add(test);
		mbar.add(edit);
		//Create an object to handle action an ItemEvents
		MyMenuHandler handler = new MyMenuHandler(this);
		//Register it to receive those events
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		item4.addActionListener(handler);
		item5.addActionListener(handler);
		item6.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		//item11.addActionListener(handler);
		//item12.addActionListener(handler);
		debug.addItemListener(handler);
		test.addItemListener(handler);
		//create an object to handle windows event
		MyWindowAdapter adapter = new MyWindowAdapter(this);
		addWindowListener(adapter);
	}
	
	public void paint(Graphics g)
	{
		g.drawString(msg,10,200);
		if(debug.getState())
		{
			g.drawString("Debug is on",10,220);
		}
		else
		{
			g.drawString("Debug is off",10,220);
		}
		if(test.getState())
		{
			g.drawString("Test is on",10,220);
		}
		else
		{
			g.drawString("Test is off",10,220);
		}
	}
}
class MyWindowAdapter extends WindowAdapter
{
	MenuFrame mf;
	public MyWindowAdapter(MenuFrame mf)
	{
		this.mf=mf;
	}
	public void windowClosing(WindowEvent we)
	{
		//mf.setVisible(false);
		mf.dispose();
	}
}
class MyMenuHandler implements ActionListener,ItemListener
{
	MenuFrame mf;
	public MyMenuHandler(MenuFrame mf)
	{
		this.mf=mf;
	}
	//Handle Action event
	public void actionPerformed(ActionEvent ae)
	{
		String msg = "You Selected ";
		String arg = (String)ae.getActionCommand();
		if(arg.equals("New..."))
		{
			msg+="New";
			SampleDialog d = new SampleDialog(mf,"New Dialog box");
			d.setVisible(true);
		}
		else if(arg.equals("Open..."))
		{
			msg+="Open";
		}
		else if(arg.equals("Close"))
		{
			msg+="Close";
		}
		else if(arg.equals("Quit..."))
		{
			msg+="Quit";
		}
		else if(arg.equals("Edit"))
		{
			msg+="Edit";
		}
		else if(arg.equals("Cut"))
		{
			msg+="Cut";
		}
		else if(arg.equals("Copy"))
		{
			msg+="Copy";
		}
		else if(arg.equals("Paste"))
		{
			msg+="Paste";
		}
		else if(arg.equals("First"))
		{
			msg+="First";
		}
		else if(arg.equals("Second"))
		{
			msg+="Second";
		}
		else if(arg.equals("Third"))
		{
			msg+="Third";
		}
		else if(arg.equals("Debug"))
		{
			msg+="Debug";
		}
		else if(arg.equals("Testing"))
		{
			msg+="Testing";
		}
	mf.msg = msg;
	mf.repaint();
	}
	//Handle ItemEvent
	public void itemStateChanged(ItemEvent i)
	{
		mf.repaint();
	}
}
public class DialogDemo extends Applet
{
	Frame f;
	public void init()
	{
		f = new MenuFrame("Menu Demo");
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		setSize(width,height);
		f.setSize(width,height);
		f.setVisible(true);

	}
	public void start()
	{
		f.setVisible(true);
	}
	public void stop()
	{
		f.setVisible(false);
	}
}