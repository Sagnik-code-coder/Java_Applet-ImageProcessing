import java.awt.*;
import java.applet.*;
//import java.util.*;
import java.awt.event.*;
/*
<applet code="CheckBoxGroupDemo2" width=600 height=300>
</applet>
*/
public class CheckBoxGroupDemo2 extends Applet
{
	CheckboxGroup cbg;
	myCheckBox mc1,mc2,mc3;
	public void init()
	{
		cbg= new CheckboxGroup();
		mc1= new myCheckBox("item1",cbg,true);
		add(mc1);
		mc2= new myCheckBox("item2",cbg,true);
		add(mc2);
		mc3= new myCheckBox("item3",cbg,true);
		add(mc3);
	}
	class myCheckBox extends Checkbox
	{
		public myCheckBox(String label,CheckboxGroup cbg,boolean flag)
		{
			super(label,cbg,flag);
			enableEvents(AWTEvent.ITEM_EVENT_MASK);
		}
		protected void processItemEvent(ItemEvent ie)
		{
			showStatus("CheckBox name/State:"+getLabel()+"/"+getState());
			super.processItemEvent(ie);
		}
	}
}