package methodvalidator.validators;

import methodvalidator.annotations.*;
import java.lang.reflect.Method;

@ValidationAnnotation(target=IsString.class)
public class IsStringValidator implements ValidationHandler 
{
	public void process(Object o, Object[] args, Method m) throws Exception{
		//check if string
		for(Object a : args) {		
			try {
				if (!a.getClass().getTypeName().equals("java.lang.String"))
				{
					throw new RuntimeException(a.getClass().getTypeName() + " is not String");
				}
				m.setAccessible(true);
			}
			catch (Exception e) {
				e.printStackTrace();				
			}
		}
	}
}
