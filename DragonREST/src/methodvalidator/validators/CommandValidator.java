package methodvalidator.validators;

import methodvalidator.annotations.*;
import java.lang.reflect.Method;

@CommandAnnotation(target=IsInteger.class)
public clas CommandValidator implements CommandHandler 
{
	public void process(Object o, Object[] args, Method m) throws Exception{
		
		/*/for(Object a : args) {
		
			try {
				//do stuff to check if valid command
				//throw new RuntimeException(a.getClass().getTypeName() + " is not Integer");
				
				m.setAccessible(true);
			}
			catch (Exception e) {
				e.printStackTrace();				
			}
		}/*/
	}
}
