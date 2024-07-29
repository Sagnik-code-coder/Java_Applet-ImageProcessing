import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.image.*;
public class Animation extends Applet implements Runnable
{
	Image cell[];
	final int MAXSEQ=64;
	int sequence[];
	int nseq;
	int idx;
	int framerate;
	boolean stopflag;
	private int intDef(String s, int def)
	{
		int n=def;
		if(s!=null)
		{
			try
			{
				n=Integer.parseInt(s);
			}
			catch(NumberFormatException e)
			{}
		}
		return n;
	}
	public void init()
	{
		framerate=intDef(getParameter("framerate"),5);
		int tilex=intDef(getParameter("cols"),1);
		int tiley=intDef(getParameter("rows"),1);
		cell=new Image[tilex*tiley];
		StringTokenizer st=new StringTokenizer(getParameter("sequence"),",");
		sequence=new int[MAXSEQ];
		nseq=0;
		while(st.hasMoreTokens() && nseq<MAXSEQ)
		{
			sequence[nseq]=intDef(st.nextToken(),0);
			nseq++;
		}
		try
		{
			Image img=getImage(getDocumentBase(),getParameter("img"));
			MediaTracker t=new MediaTracker(this);
			t.addImage(img,0);
			t.waitForID(0);
			int iw=img.getWidth(null);
			int ih=img.getHeight(null);
			int tw=iw/tilex;
			int th=ih/tiley;
			CropImageFilter f;
			FilteredImageSource fis;
			for(int y=0;y<tiley;y++)
			{
				for(int x=0;x<tilex;x++)
				{
					f=new CropImageFilter(tw*x,th*y,tw,th);
					fis=new FilteredImageSource(img.getSource(),f);
					int i=y*tilex+x;
					cell[i]=createImage(fis);
					t.addImage(cell[i],i);
				}
			}
			t.waitForAll();
		}
		catch(InterruptedException e)
		{}
	}
	public void update(Graphics g)
	{
		
	}
	public void paint(Graphics g)
	{
		g.drawImage(cell[sequence[idx]],0,0,null);
	}
	Thread t;
	public void start()
	{
		t=new Thread(this);
		stopflag=false;
		t.start();
	}
	public void stop()
	{
		stopflag=true;
	}
	public void run()
	{
		int idx=0;
		while(true)
		{
			paint(getGraphics());
			idx=(idx+1)%nseq;
			try{
				Thread.sleep(1000/framerate);
			}
			catch(Exception e){}
			if(stopflag)
				return;
		}
	}
}
/*
<applet code=Animation width=400 height=300 >
<param name=img value=mario.gif>
<param name=rows value=3>
<param name=cols value=4>
<param name=sequence value=0,1,2,3,4,5,6,7,8,9,10>
<param name=framerate value=15>
</applet>
*/
 