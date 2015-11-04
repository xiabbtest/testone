
pckage autotest1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
																						return new Object[][]{ {bean, "hello", "world!"}, };
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
																																																	    	System.out.println("@BeforeClass 让我在本类所有测试方法之前运行，适合做一些全局初始化");
																																																		    }
																																																		        
																																																			    @AfterClass
																																																			        public void afterClass(){
																																																					System.out.println("@BeforeClass 让我在本类所有测试方法之侯运行，适合做一些清理工作,比如释放数据库链接,");
																																																					    }
																																																					    }
																																																					    
																																																					    ackage autotest1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	return new Object[][]{ {bean, "hello", "world!"}, };
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
	System.out.println("@BeforeClass 让我在本类所有测试方法之前运行，适合做一些全局初始化");
    }
    
    @AfterClass
    public void afterClass(){
	System.out.println("@BeforeClass 让我在本类所有测试方法之侯运行，适合做一些清理工作,比如释放数据库链接,");
    }
}

