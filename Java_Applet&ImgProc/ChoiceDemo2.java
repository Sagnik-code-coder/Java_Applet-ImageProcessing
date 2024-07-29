import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;
/*
<applet code="ChoiceDemo2" width=600 height=300>
</applet>
*/
public class ChoiceDemo2 extends Applet
{
	myChoice choice;
	public void init()
	{
		choice = new myChoice();
		choice.add("Red");
		choice.add("Green");
		choice.add("Blue");
		add(choice);
		
	}
	class myChoice extends Choice
	{
		public myChoice()
		{
			enableEvents(AWTEvent.ITEM_EVENT_MASK);
			
		}
		protected void processItemEvent(ItemEvent ie)
		{
			showStatus("Choice Selection:"+getSelectedItem());
			super.processItemEvent(ie);
		}
	}
}