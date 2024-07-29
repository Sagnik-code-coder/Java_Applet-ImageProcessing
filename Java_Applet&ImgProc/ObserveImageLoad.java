import java.awt.*;
import java.applet.*;

/*<applet code="ObserveImageLoad" width=1280 height=768>
 <param name="img" value="butterfly.jpg">
 </applet>
*/
public class ObserveImageLoad extends Applet
{
	Image img;
	boolean error = false;
	String imgName;
	public void init()
	{
		setBackground(Color.blue);
		imgName = getParameter("img");
		img = getImage(getDocumentBase(),imgName);
	}
	public void paint(Graphics g)
	{
		if(error==true)
		{
			Dimension d = getSize();
			g.setColor(Color.red);
			g.fillRect(0,0,d.width,d.height);
			g.setColor(Color.black);
			g.drawString("Image not found:"+imgName,10,d.height/2);
		}
		else
		{
			g.drawImage(img,0,0,this);
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public boolean imageupdate(Image img,int flags,int x,int y,int w,int h)
	{
		if((flags & SOMEBITS)!=0)
		{
			repaint(x,y,w,h);
		}
		else if((flags & ABORT)!=0)
		{
			error = true;
			repaint();
		}
		return (flags & (ALLBITS | ABORT) ) == 0;
	}
	/*public boolean imageupdate(Image img,int flags,int x,int y,int w,int h)
	{
		if((flags & ALLBITS)!=0)
		{
			repaint();
		}
		else if((flags & (ABORT | ERROR))!=0)
		{
			error = true;
			repaint();
		}
		return (flags & (ALLBITS | ABORT | ERROR) ) == 0;
	}*/
}