package methodvalidator.validators;

import java.lang.reflect.Method;
import methodvalidator.annotations.*;

@ValidationAnnotation(target=Range.class)
public class RangeValidator implements ValidationHandler {

	
	public void process(Object o, Object[] args, Method m) throws Exception {
		// check if numeric type
		m.setAccessible(true);
		
		for(Object a : args){
			try{
				if (!(a instanceof Number))
				{
					throw new RuntimeException(m.getName()+" must be a number");
				}
				
				Range r = m.getAnnotation(Range.class);
				
				double d = Double.valueOf(a.toString());
				
				if (d>r.upperBound() || d<r.lowerBound())
				{
					throw new RuntimeException("Argument must be between "+r.lowerBound()+" and "+r.upperBound());
				}
			}
			catch (Exception e) {
				e.printStackTrace();				
			}
		}		
	}
}
