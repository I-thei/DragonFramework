package methodvalidator.validators;

import methodvalidator.annotations.*;
import java.lang.reflect.Method;

@ValidationAnnotation(target=NotNull.class)
public class NotNullValidator implements ValidationHandler 
{
	public void process(Object o, Object[] args, Method m) throws Exception{
		// check if not a primitive
		for(Object a : args) {
		
			try {
				if (a == null){
					throw new RuntimeException("Argument cannot be null");
				}
				if (a.getClass().isPrimitive())
				{
					throw new RuntimeException("Cannot be used on a primitive");
				}
				m.setAccessible(true);
			}
			catch (Exception e) {
				e.printStackTrace();				
			}
		}
	}
}
