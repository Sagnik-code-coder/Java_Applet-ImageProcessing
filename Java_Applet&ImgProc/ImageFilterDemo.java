import java.awt.*;
import java.applet.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
/*<applet code="ImageFilterDemo" width=510 height=330>
 <param name="img" value="test.jpg">
 <param name="filters" value="Grayscale+Invert+Contrast+Blur+Sharpen">
 </applet>
*/
public class ImageFilterDemo extends Applet implements ActionListener 
{
	Image img;
	PlugInFilter pif;
	Image fimg;
	Image curImg;
	LoadedImage lim;
	Label lab;
	Button reset;
	public void init()
	{
		setLayout(new BorderLayout());
		Panel p = new Panel();
		add(p,BorderLayout.SOUTH);
		reset = new Button("Reset");
		reset.addActionListener(this);
		p.add(reset);
		StringTokenizer st = new StringTokenizer(getParameter("filters"),"+");
		while(st.hasMoreTokens())
		{
			Button b = new Button(st.nextToken());
			b.addActionListener(this);
			p.add(b);
		}
		lab = new Label("");
		add(lab,BorderLayout.NORTH);
		img = getImage(getDocumentBase(),getParameter("img"));
		lim = new LoadedImage(img);
		add(lim,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a = "";
		try{
			a = (String)ae.getActionCommand();
			if(a.equals("Reset"))
			{
				lim.set(img);
				lab.setText("Normal");
			}
			else
			{
				pif = (PlugInFilter) Class.forName(a).newInstance();
				fimg = pif.filter(this,img);
				lim.set(fimg);
				lab.setText("Filtered:"+a);
				
			}
			repaint();
		}
		catch(ClassNotFoundException e )
		{
			lab.setText(a+" Not Found");
			lim.set(img);
			repaint();
		}
		catch(InstantiationException e )
		{
			lab.setText("Could not new"+a);
		}
		catch(IllegalAccessException e )
		{
			lab.setText("No Access:"+a);
		}
	}
}