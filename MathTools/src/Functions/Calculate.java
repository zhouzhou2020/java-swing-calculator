package Functions;
import javax.swing.JOptionPane;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * 文件名：Calcuate.java
 * 项目-包：MathTools - 
 * 作者：Biosone
 * 创建日期：2019-1-6
 */

/**
 * @author Biosone
 * 类名：Calcuate
 * 类说明：
 */
public class Calculate
{
	public String getResult(String expressioon)
	{
		Expression calc = null;
		try
		{
			ExpressionBuilder builder = new ExpressionBuilder(expressioon);
			builder.build();
			calc = builder.build();
			return ""+calc.evaluate();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "输入格式有误!");
			return "error";
		}
		
	}

}
