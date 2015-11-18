
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
#print "xiabbtest"
public class autotest1{

    static class TestBean{
	private String field1 = null;
	private String field2 = null;
	public String getField1() {
	    return field1;
	}
	public void setField1(String field1) {
	    this.field1 = field1;
	}
	public String getField2() {
	    return field2;
	}
	public void setField2(String field2) {
	    this.field2 = field2;
	}
	
	public String toString(){
	    return this.getField1() + " " + this.getField2();
	}
    }
    
    
    @DataProvider(name="dataProvider1")
    public Object[][] initData1(){
	TestBean bean = new TestBean();
	return new Object[][]{ {bean, "hello", "world!"}, {bean, "hello", "world!"},};
    }
    @Test(dataProvider="dataProvider1")
    public void testSetValue(TestBean targetObj, String value1, String value2){
	if (targetObj == null) {
	    return;
	}
	targetObj.setField1(value1);
	targetObj.setField2(value2);
	assert "hello world!".equals(targetObj.toString());
	System.out.println(targetObj);
	
    }
    
    @DataProvider(name="dataProvider2")
    public Object[][] initData2(){
	TestBean bean = new TestBean();
	bean.setField1("hello");
	bean.setField2("world!");
	return new Object[][]{ {bean}, };
    }
    @Test(dataProvider="dataProvider2")
    public void testReverseValue(TestBean targetObj){
	if (targetObj == null) {
	    return;
	}
	String reversedValue1 = new StringBuffer(targetObj.getField1()).reverse().toString();
	String reversedValue2 = new StringBuffer(targetObj.getField2()).reverse().toString();
	
	targetObj.setField1(reversedValue2);
	targetObj.setField2(reversedValue1);
	assert "!dlrow olleh".equals(targetObj.toString());
	System.out.println(targetObj);
    }
    
    @BeforeClass
    public void beforeClass(){
	System.out.println("@BeforeClass ........");
    }
    
    @AfterClass
    public void afterClass(){
	System.out.println("@BeforeClass .........");
    }
}

