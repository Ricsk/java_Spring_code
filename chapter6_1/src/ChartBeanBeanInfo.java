import java.beans.*;
public class ChartBeanBeanInfo extends SimpleBeanInfo{
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor titlePositionDescriptor = 
					new PropertyDescriptor("titlePosition", ChartBean.class);
			titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
			return new PropertyDescriptor[] {titlePositionDescriptor};
		}
		catch(IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}
}