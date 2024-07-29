import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;

/*<applet code="SampleImageLoad" width=300 height=200>
 <param name="img" value="download.jpg">
 </applet>
 

 */
 public class SampleImageLoad extends Applet
 {
	 Image img;
	 public void init()
	 {
		 img = getImage(getDocumentBase(),getParameter("img"));
	 }
	 public void paint(Graphics g)
	 {
		 g.drawImage(img,0,0,this);
	 }
 }