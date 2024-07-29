import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;
/*
<applet code="CheckBoxDemo2" width=600 height=300>
</applet>
*/
public class CheckBoxDemo2 extends Applet
{
	myCheckBox mc1,mc2,mc3;
	public void init(){
		mc1= new myCheckBox("item1");
		add(mc1);
		mc2= new myCheckBox("item2");
		add(mc2);
		mc3= new myCheckBox("item3");
		add(mc3);
	}
	class myCheckBox extends Checkbox{
		
	public myCheckBox(String label)
	{
		super(label);
		enableEvents(AWTEvent.ITEM_EVENT_MASK);
	}
	protected void processItemEvent(ItemEvent ie)
	{
		showStatus("CheckBox name/State:"+getLabel()+"/"+getState());
		super.processItemEvent(ie);
	}
	}
	
}