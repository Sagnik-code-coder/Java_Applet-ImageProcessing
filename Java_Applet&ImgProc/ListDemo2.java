import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;
/*
<applet code="ListDemo2" width=600 height=300>
</applet>
*/
public class ListDemo2 extends Applet
{
	myList list;
	public void init()
	{
		list = new myList();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		add(list);
		
	}
class myList extends List
{
	public myList()
	{
		enableEvents(AWTEvent.ITEM_EVENT_MASK |AWTEvent.ACTION_EVENT_MASK );
		
	}
	protected void processActionEvent(ActionEvent ae)
	{
		showStatus("ActionEvent:"+ae.getActionCommand());
		super.processActionEvent(ae);
		
	}
	protected void processItemEvent(ItemEvent ie)
	{
		showStatus("ItemEvent:"+getSelectedItem());
		super.processItemEvent(ie);
		
	}
	
}	
}
