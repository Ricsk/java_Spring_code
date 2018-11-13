import java.beans.*;

public class TitlePositionEditor extends PropertyEditorSupport{
	private String[] options = {"Left", "Center","Right"};
	
	//代表可选属性值的字符串表示数组
	public String[] getTags() {return options;}
	
	//代表属性初始值的字符串
	public String getJavaInitializationString() {
		return "" + getValue();
	}
	
	public String getAsTest() {
		int value = (Integer)getValue();
		return options[value];
	}
	
	public void setAsText(String s) {
		for(int i = 0;i < options.length;i++) {
			if(options[i].equals(s)) {
				setValue(i);
				return;
			}
		}
	}
}