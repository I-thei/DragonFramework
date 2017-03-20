package methodvalidator.validators;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class Validator 
{
	private HashMap<Class<?>, ValidationHandler> map = new HashMap<>();
	
	public Validator() throws Exception
	{
		// init map by scanning
		ScanResult results = new FastClasspathScanner("methodvalidator.validators").scan();		
		List<String> allResults = results.getNamesOfClassesWithAnnotation(ValidationAnnotation.class);
		//System.out.println(allResults);
		for (String s : allResults)
		{
			Class<?> c = Class.forName(s);
			ValidationAnnotation va = (ValidationAnnotation) c.getAnnotation(ValidationAnnotation.class);				
			//System.out.println(va);				
			map.put(va.target(), (ValidationHandler) c.newInstance());
		}
	
	}
	
	public Validator(String path) throws Exception
	{
		// init map by scanning
		ScanResult results = new FastClasspathScanner("methodvalidator.validators", path).scan();		
		List<String> allResults = results.getNamesOfClassesWithAnnotation(ValidationAnnotation.class);
		//System.out.println(allResults);
		for (String s : allResults)
		{
			Class<?> c = Class.forName(s);
			ValidationAnnotation va = (ValidationAnnotation) c.getAnnotation(ValidationAnnotation.class);				
			//System.out.println(va);				
			map.put(va.target(), (ValidationHandler) c.newInstance());
		}
	
	}
	
	public void validate(Object o, Object[] args, Method method) throws Exception
	{
		Annotation[] alist = method.getAnnotations();
		for (Annotation a : alist)
		{
			ValidationHandler vh = map.get(a.annotationType());
			if (vh!=null)
			{
				vh.process(o, args, method);
			}
		}
		
	}

	

	

	
	
	
	
}
