import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;
/*
<applet code="ScrollbarDemo2" width=600 height=300>
</applet>
*/
public class ScrollbarDemo2 extends Applet
{
	myScrollbar ms;
	public void init()
	{
		ms = new myScrollbar(Scrollbar.HORIZONTAL,0,1,0,100);
		add(ms);
		
	}
	class myScrollbar extends Scrollbar
	{
		public myScrollbar(int style,int intial, int thumb, int min,int max)
		{
			super(style,intial,thumb,min,max);
			enableEvents(AWTEvent.ADJUSTMENT_EVENT_MASK);
		}
		protected void processAdjustmentEvent(AdjustmentEvent ae)
		{
			showStatus("AdjustmentEvent:"+ae.getValue());
			setValue(getValue());
			super.processAdjustmentEvent(ae);
		}
		
	}
}
