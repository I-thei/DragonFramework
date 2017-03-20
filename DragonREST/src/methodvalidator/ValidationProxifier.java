/*/
//USED THIS FOR TESTING

package methodvalidator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Scanner;

import methodvalidator.validators.Validator;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;

public class ValidationProxifier 
{
	public static Object createObjectWithValidation(Object o) throws Exception
	{
		Class<?> type = o.getClass();
        ClassLoader classLoader = type.getClassLoader();

        Class<?> proxyType = new ByteBuddy()
                .subclass(type)
                
                .method(ElementMatchers.any()) 									// triggers on EVERYTHING                
                //.method(ElementMatchers.isDeclaredBy(type)) 					// triggers on declared methods in class
                //.method(ElementMatchers.isAnnotatedWith(GreaterThan.class))   // annotated with a specific annotation               
                .intercept(InvocationHandlerAdapter.of(new ProxyInvocationHandler(o)))
                .make()
                .load(classLoader)
                .getLoaded();
        
        Object proxy = (MyClass) proxyType.newInstance();
		return proxy;
	}
	
	
	static class ProxyInvocationHandler implements InvocationHandler
	{
		private Object original;
		
		public ProxyInvocationHandler(Object o) 
		{
			original = o;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Validator v = new Validator();
			v.validate(proxy, args, method);
			
			return method.invoke(original, args);
		}
		
	}
	//TESTING
	static Scanner sc;
	static MyClass mc;
	public static void main(String[] args) throws Exception
	{
		sc = new Scanner(System.in);
		mc = new MyClass();
		mc = (MyClass) createObjectWithValidation(mc);
		System.out.println("Enter name for user:");
		setName();
	}
	
	public static void setName(){
		try {
			String in = sc.nextLine();
			mc.setMyString(in);
		}
		catch (Exception e){
			setName();
		}
	}
}
/*/
