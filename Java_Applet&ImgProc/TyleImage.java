import java.awt.*;
import java.applet.*;
import java.awt.image.*;
/*<applet code="TyleImage" width=510 height=330>
 <param name="img" value="test.jpg">
 </applet>
*/
public class TyleImage extends Applet
{
	Image img;
	Image cell[]= new Image[4*4];
	int iw,ih;
	int tw,th;
	public void init()
	{
		try{
			img = getImage(getDocumentBase(),getParameter("img"));
			MediaTracker t = new MediaTracker(this);
			t.addImage(img,0);
			t.waitForID(0);
			iw = img.getWidth(null);
			ih= img.getHeight(null);
			tw= iw/4;
			th=ih/4;
			CropImageFilter f;
			FilteredImageSource fis;
			t = new MediaTracker(this);
			for(int y=0;y<4;y++)
			{
				for(int x=0;x<4;x++)
				{
					f= new CropImageFilter(tw*x,th*y,tw,th);
					fis = new FilteredImageSource(img.getSource(),f);
					int i= y*4+x;
					cell[i] = createImage(fis);
					t.addImage(cell[i],i);
					
				}
			}
			t.waitForAll();
			for(int i=0;i<32;i++)
			{
				int si = (int)(Math.random()*16);
				int di = (int)(Math.random()*16);
				Image temp = cell[si];
				cell[si] = cell[di];
				cell[di] = temp;
				
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint(Graphics g)
	{
		for(int y=0;y<4;y++)
		{
			for(int x=0;x<4;x++)
			{
				g.drawImage(cell[y*4+x],x*tw,y*th,null);
			}
			
		}
	}
}