import java.beans.*;

public class TitlePositionEditor extends PropertyEditorSupport{
	private String[] options = {"Left", "Center","Right"};
	
	//�����ѡ����ֵ���ַ�����ʾ����
	public String[] getTags() {return options;}
	
	//�������Գ�ʼֵ���ַ���
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