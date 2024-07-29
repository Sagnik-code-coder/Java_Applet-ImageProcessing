import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
/*
<applet code="Button2" width=600 height=300>
</applet>
*/
public class Button2 extends Applet
{
	Mybutton mb ;
	static int i =0;
	public void init()
	{
		mb = new Mybutton ("test Button");
		add(mb);
		
	}
	class Mybutton extends Button
	{
		public Mybutton(String label)
		{
			super(label);
			enableEvents(AWTEvent.ACTION_EVENT_MASK);
			
		}
		protected void processActionEvent(ActionEvent ae)
		{
			showStatus("Action Event:"+i++);
			super.processActionEvent(ae);
			
			}
	}
}