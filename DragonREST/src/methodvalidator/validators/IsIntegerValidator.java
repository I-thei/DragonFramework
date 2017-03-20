package methodvalidator.validators;

import methodvalidator.annotations.*;
import java.lang.reflect.Method;

@ValidationAnnotation(target=IsInteger.class)
public class IsIntegerValidator implements ValidationHandler 
{
	public void process(Object o, Object[] args, Method m) throws Exception{
		// check if is integer
		for(Object a : args) {
		
			try {
				if (!a.getClass().getTypeName().equals("java.lang.Integer"))
				{
					throw new RuntimeException(a.getClass().getTypeName() + " is not Integer");
				}
				m.setAccessible(true);
			}
			catch (Exception e) {
				e.printStackTrace();				
			}
		}
	}
}
