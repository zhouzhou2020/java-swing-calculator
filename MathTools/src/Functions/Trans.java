package Functions;

/**
* 文件名：Trans.java
 * 项目-包：MathTools - 
 * 作者：Biosone
 * 创建日期：2019-1-8
 */

/**
 * @author Biosone
 * 类名：Trans
 * 类说明：
 */
public class Trans
{
	public String tenTOtwo(String ten)
	{
		return Integer.toBinaryString(Integer.valueOf(ten));	
	}
	public String twoTOten(String  two)
	{
		return Integer.valueOf(two,2).toString();	
	}
	public String tenTOSixteen(String ten)
	{
		return Integer.toHexString(Integer.valueOf(ten));
		
	}
	public String sixteenTOten(String sixteen)
	{
		return Integer.valueOf(sixteen,16).toString() ;
		
	}
}
