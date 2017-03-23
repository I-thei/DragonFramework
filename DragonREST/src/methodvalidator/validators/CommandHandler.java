package methodvalidator.validators;
import java.lang.reflect.Method;

public interface CommandHandler 
{
	public void process(Object o, Object[] arg, Method m) throws Exception;
}
