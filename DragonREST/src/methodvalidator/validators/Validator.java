package methodvalidator.validators;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class Validator 
{
	private HashMap<Class<?>, CommandHandler> map = new HashMap<>();
	
	public Validator() throws Exception
	{
		ScanResult results = new FastClasspathScanner("methodvalidator.validators").scan();		
		List<String> allResults = results.getNamesOfClassesWithAnnotation(CommandAnnotation.class);
		for (String s : allResults)
		{
			Class<?> c = Class.forName(s);
			CommandAnnotation ca = (CommandAnnotation) c.getAnnotation(CommandAnnotation.class);							
			map.put(ca.target(), (CommandHandler) c.newInstance());
		}
	}
	
	public Validator(String path) throws Exception
	{
		ScanResult results = new FastClasspathScanner("methodvalidator.validators", path).scan();		
		List<String> allResults = results.getNamesOfClassesWithAnnotation(CommandAnnotation.class);
		for (String s : allResults)
		{
			Class<?> c = Class.forName(s);
			CommandAnnotation ca = (CommandAnnotation) c.getAnnotation(CommandAnnotation.class);								
			map.put(ca.target(), (CommandHandler) c.newInstance());
		}
	
	}
	
	public void validate(Object o, Object[] args, Method method) throws Exception
	{
		Annotation[] alist = method.getAnnotations();
		for (Annotation a : alist)
		{
			CommandHandler ch = map.get(a.annotationType());
			if (ch!=null)
			{
				ch.process(o, args, method);
			}
		}
		
	}

	

	

	
	
	
	
}
