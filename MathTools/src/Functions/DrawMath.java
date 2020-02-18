package Functions;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * 文件名：DrawMath.java
 * 项目-包：MathTools - 
 * 作者：Biosone
 * 创建日期：2019-1-7
 */

/**
 * @author Biosone
 * 类名：DrawMath
 * 类说明：
 */
public class DrawMath
{
	public double parse(String express, double x)
	{
		String str = "(" + x + ")";
		express = express.replaceAll("x", str);
		ExpressionBuilder builder = new ExpressionBuilder(express);
		Expression cal = builder.build();
		double result = cal.evaluate();
		return result;
	}

	public ChartPanel eval(String express)
	{
		XYSeries xSeries = new XYSeries("xSeries");
		for (double x = -10; x < 10; x = x + 0.1)
		{
			xSeries.add(x, 0);
		}
		XYSeries ySeries = new XYSeries("ySeries");
		for (double y = -10; y < 10; y = y + 0.1)
		{
			ySeries.add(0, y);
		}
		XYSeries series = new XYSeries("xySeries");
		for (double x = -10; x < 10; x = x + 0.1)
		{
			double y = parse(express, x);
			if (y < 10 && y > -10)
			{
				series.add(x, y);
			}
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(xSeries);
		dataset.addSeries(ySeries);
		dataset.addSeries(series);
		express = "y=" + express;
		JFreeChart chart = ChartFactory.createXYLineChart(express, "y", "x",
				dataset, PlotOrientation.VERTICAL, false, false, false);
		XYPlot xyplot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) xyplot
				.getRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.BLACK);
		ValueAxis valueaxis = xyplot.getRangeAxis();
		valueaxis.setPositiveArrowVisible(true);

		return new ChartPanel(chart);
	}
}
