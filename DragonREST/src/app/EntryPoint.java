package app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repositories.UserRepository;
import methodvalidator.validators.Validator;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//import java.util.List;
import java.util.Scanner;

@Component // do not forget to add this
public class EntryPoint {
	
	//auto wire puts an object instance to the field 
	@Autowired
	UserRepository rep;
	static Scanner sc;
	
	//trigger the moment all the object are initialized 
	@PostConstruct
	public void run() throws Exception{
		sc = new Scanner(System.in);
		User u = new User();
		u = (User) createObjectWithValidation(u);
		System.out.println("Enter name for user:");
		createUser(u);
		
		/*/ SAMPLE QUERY
			List<User> users = rep.findByName("ed");
			List<User> users2 = rep.findByAgeGreaterThan(10);
			List<User> users3 = rep.myQuery();
			System.out.println(users);
			System.out.println(users2);
			System.out.println(users3);
		/*/
	}
	
	public void createUser(User u){
		String in = "Player";
		try {
			in = sc.nextLine();
		}catch (Exception e){
			createUser(u);
		}
		createUser(u, in);
	}
	
	
	public void createUser(User u, String in){	
		u.setName(in);
		u.setBABY_DEAD(0);
		u.setCHEST_FOUND(0);
		u.setDEAD(0);
		u.setGRAVE_FOUND(0);
		u.setIN_POOL(0);
		u.setTOOK_SWORD(0);
		u.setWORD_FOUND_2(0);
		u.setWORD_FOUND_3(0);
		u.setWORD_FOUND_4(0);
		rep.save(u);
		System.out.println("Added");
	}
	
	//I USED BYTEBUDDY LANG MUNA TO TEST IF VALIDATIONS WORK
	//PERO IT IS STILL FOR USERNAME INPUT PA LANG
	//EVERYTHING BELOW 
	public static Object createObjectWithValidation(Object o) throws Exception
	{
		Class<?> type = o.getClass();
        ClassLoader classLoader = type.getClassLoader();
        Class<?> proxyType = new ByteBuddy()
                .subclass(type)
                .method(ElementMatchers.any()) 									// triggers on EVERYTHING                
                .intercept(InvocationHandlerAdapter.of(new ProxyInvocationHandler(o)))
                .make()
                .load(classLoader)
                .getLoaded();
        Object proxy = (User) proxyType.newInstance();
		return proxy;
	}
	
	static class ProxyInvocationHandler implements InvocationHandler
	{
		private Object original;
		public ProxyInvocationHandler(Object o) {
			original = o;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Validator v = new Validator();
			v.validate(proxy, args, method);
			
			return method.invoke(original, args);
		}
		
	}
}