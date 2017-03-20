/*/
//USED THIS FOR TESTING
 
package methodvalidator;
 

import methodvalidator.annotations.*;

public class MyClass {


    private int myField1;
    private int myField2;
    private int myField3;
    private String myString;
    private String myString2;
    
    public int getMyField1()
    {
        return myField1;
    }
    
	@IsInteger
    public void setMyField1(int myField1)
    {
        this.myField1 = myField1;
    }
    public int getMyField2()
    {
        return myField2;
    }
    
    @IsInteger
    public void setMyField2(int myField2)
    {
        this.myField2 = myField2;
    }
    public int getMyField3()
    {
        return myField3;
    }
    
    @IsString
    public void setMyField3(int myField3)
    {
        this.myField3 = myField3;
    }
    
    public String getMyString()
    {
        return myString;
    }
    
    @StringLength 
    public void setMyString(String myString)
    {
        this.myString = myString;
    }
    
    public String getMyString2()
    {
        return myString2;
    }
    public void setMyString2(String myString)
    {
        this.myString2 = myString;
    }

	
}
/*/
