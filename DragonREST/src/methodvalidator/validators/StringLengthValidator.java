package methodvalidator.validators;

import methodvalidator.annotations.*;
import java.lang.reflect.Method;

@ValidationAnnotation(target=StringLength.class)
public class StringLengthValidator implements ValidationHandler 
{
	public void process(Object o, Object[] args, Method m) throws Exception{
		// check if not a primitive
		for(Object a : args) {
		
			try {
				if (a.toString().length() < 3){
					throw new RuntimeException();
				}
				m.setAccessible(true);
				System.out.println("Name accepted.");
			}
			catch (Exception e) {
				//e.printStackTrace();	
				System.out.println("Must be 3 or more characters");
				throw new RuntimeException();
			}
		}
	}
}
