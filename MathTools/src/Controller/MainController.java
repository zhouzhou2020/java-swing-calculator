package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Functions.Calculate;
import Functions.DrawMath;
import Functions.Trans;
import GUI.View;

/**
 * 文件名：MainController.java
 * 项目-包：MathTools - 
 * 作者：Biosone
 * 创建日期：2019-1-7
 */

/**
 * @author Biosone
 * 类名：Main
 * 类说明：
 */
public class MainController extends View
{
	static String calIn = " ";
	static String drawIn = " ";
	Calculate calcuate;
	DrawMath drawMath;
	Trans trans;
	CalController calController;
	TransController transController;
	DrawController drawController;

	public static void main(String[] args)
	{
		new MainController();
	}

	public MainController()
	{
		super();
		registerlistener();
	}

	public void registerlistener()
	{
		calController = new CalController();
		// calulatepanel
		for (int i = 0; i < 32; i++)
		{
			key1[i].addActionListener(calController);
		}
		// drawpane
		drawController = new DrawController();
		for (int i = 0; i < 28; i++)
		{
			key2[i].addActionListener(drawController);
		}
		// transpane
		transController = new TransController();
		transButton11.addActionListener(transController);
		transButton12.addActionListener(transController);
		transButton21.addActionListener(transController);
		transButton22.addActionListener(transController);
		transButton31.addActionListener(transController);
		transButton32.addActionListener(transController);
		transButton41.addActionListener(transController);
		transButton42.addActionListener(transController);
	}

	class CalController implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			calcuate = new Calculate();
			String get = e.getActionCommand();

			if ("0123456789.+-*/^()eπ'sin(''cos(''tan(''log''^2''^3''^(1/2)''^(1/3)'"
					.indexOf(get) >= 0)
			{
				calIn = calField.getText() + get;
				calField.setText(calIn);
				calField.requestFocusInWindow();

			}
			else if ("=".indexOf(get) >= 0
					&& calField.getText().trim().length() != 0
					&& !calIn.contains("="))
			{
				calIn = calField.getText();
				resultField.setText(calcuate.getResult(calField.getText()));
				calField.setText(calIn);
				if (!resultField.getText().contains("error"))
				{
					calArea.append(calIn + "=" + resultField.getText() + "\n");
				}
				calField.requestFocusInWindow();

			}
			else if ("CE".compareTo(get) == 0)
			{
				int L = calIn.length();
				if (L != 0)
				{
					calIn = calIn.substring(0, L - 1);
				}
				calField.setText(calIn);
				calField.requestFocusInWindow();
			}
			else if ("C".compareTo(get) == 0)
			{
				calIn = "";
				calField.setText(calIn);
				resultField.setText("0");
				calField.requestFocusInWindow();
			}
		}
	}

	class DrawController implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			drawMath = new DrawMath();
			String get = e.getActionCommand();
			if ("0123456789.,+-*/()^eπxlogsincostan"
					.indexOf(get) >= 0)
			{
				drawIn = drawIn + get;
				drawField.setText(drawIn);
			}
			else if ("绘制".compareTo(get) == 0 && drawIn.trim().length() != 0)
			{
				drawxyPanel.removeAll();
				drawxyPanel.add(drawMath.eval(drawField.getText()),
						BorderLayout.CENTER);
				drawxyPanel.revalidate();
				// drawxyPanel.updateUI();
			}
			else if ("CE".compareTo(get) == 0)
			{
				int L = drawIn.length();
				if (L != 0)
				{
					drawIn = drawIn.substring(0, L - 1);
				}
				drawField.setText(drawIn);
			}
			else if ("重绘".compareTo(get) == 0)
			{
				drawxyPanel.removeAll();
				drawIn = "";
				drawField.setText(drawIn);
				drawxyPanel.repaint();
				// drawxyPanel.updateUI();
			}
		}
	}

	class TransController implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			trans = new Trans();
			Object o = e.getSource();
			// 长度
			String m = mField.getText();
			String mm = mmField.getText();
			String km = kmField.getText();
			String cm = cmField.getText();
			String li = liField.getText();
			// 进制
			String ten = tenField.getText();
			String two = twoField.getText();
			String sixteen = sixteenField.getText();
			// 重量
			String g = gField.getText();
			String kg = kgField.getText();
			String jin = jinField.getText();
			String b = bField.getText();
			// 汇率
			String rmb = rmbField.getText();
			String dollar = dollarField.getText();
			String pand = pandField.getText();
			String euro = euroField.getText();
			if (o == transButton21)
			{
				if (ten.length() != 0 && two.length() == 0
						&& sixteen.length() == 0)
				{
					twoField.setText(trans.tenTOtwo(ten));
					sixteenField.setText(trans.tenTOSixteen(ten));
				}
				else if (ten.length() == 0 && two.length() != 0
						&& sixteen.length() == 0)
				{
					tenField.setText(trans.twoTOten(two));
					sixteenField
							.setText(trans.tenTOSixteen(trans.twoTOten(two)));
				}
				else if (ten.length() == 0 && two.length() == 0
						&& sixteen.length() != 0)
				{
					twoField.setText(trans.tenTOtwo(trans.sixteenTOten(sixteen)));
					tenField.setText(trans.sixteenTOten(sixteen));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "输入有误！");
				}
			}
			else if (o == transButton22)
			{
				tenField.setText("");
				twoField.setText("");
				sixteenField.setText("");
			}
			else if (o == transButton11)
			{
				if (mm.length() != 0 && cm.length() == 0 && m.length() == 0
						&& km.length() == 0 && li.length() == 0)
				{
					kmField.setText("" + Double.valueOf(mm) / 1000000);
					mField.setText("" + Double.valueOf(mm) / 100);
					liField.setText("" + Double.valueOf(mm) / 500000);
					cmField.setText("" + Double.valueOf(mm) / 10);
				}
				else if (mm.length() == 0 && cm.length() != 0
						&& m.length() == 0 && km.length() == 0
						&& li.length() == 0)
				{
					mmField.setText("" + Double.valueOf(cm) * 10);
					kmField.setText("" + Double.valueOf(cm) / 100000);
					mField.setText("" + Double.valueOf(cm) / 100);
					liField.setText("" + Double.valueOf(cm) / 50000);
				}
				else if (mm.length() == 0 && cm.length() == 0
						&& m.length() != 0 && km.length() == 0
						&& li.length() == 0)
				{
					mmField.setText("" + Double.valueOf(m) * 1000);
					kmField.setText("" + Double.valueOf(m) / 1000);
					liField.setText("" + Double.valueOf(m) / 500);
					cmField.setText("" + Double.valueOf(m) * 100);
				}
				else if (mm.length() == 0 && cm.length() == 0
						&& m.length() == 0 && km.length() != 0
						&& li.length() == 0)
				{
					mmField.setText("" + Double.valueOf(km) * 1000000);
					mField.setText("" + Double.valueOf(km) * 1000);
					liField.setText("" + Double.valueOf(km) * 2);
					cmField.setText("" + Double.valueOf(km) * 100000);
				}
				else if (mm.length() == 0 && cm.length() == 0
						&& m.length() == 0 && km.length() == 0
						&& li.length() != 0)
				{
					mmField.setText("" + Double.valueOf(li) * 500000);
					kmField.setText("" + Double.valueOf(li) / 2);
					mField.setText("" + Double.valueOf(li) * 500);
					cmField.setText("" + Double.valueOf(li) * 50000);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "输入有误！");
				}

			}
			else if (o == transButton12)
			{
				mmField.setText("");
				kmField.setText("");
				mField.setText("");
				liField.setText("");
				cmField.setText("");
			}
			else if (o == transButton31)
			{
				if (g.length() != 0 && kg.length() == 0 && jin.length() == 0
						&& b.length() == 0)
				{
					kgField.setText("" + Double.valueOf(g) / 1000);
					jinField.setText("" + Double.valueOf(g) / 500);
					bField.setText("" + Double.valueOf(g) / 453.59237);
				}
				else if (g.length() == 0 && kg.length() != 0
						&& jin.length() == 0 && b.length() == 0)
				{
					gField.setText("" + Double.valueOf(kg) * 1000);
					jinField.setText("" + Double.valueOf(kg) * 2);
					bField.setText("" + Double.valueOf(kg) / 0.4535924);
				}
				else if (g.length() == 0 && kg.length() == 0
						&& jin.length() != 0 && b.length() == 0)
				{
					gField.setText("" + Double.valueOf(jin) * 500);
					kgField.setText("" + Double.valueOf(jin) / 2);
					bField.setText("" + Double.valueOf(jin) / 0.9071847);
				}
				else if (g.length() == 0 && kg.length() == 0
						&& jin.length() == 0 && b.length() != 0)
				{
					gField.setText("");
					kgField.setText("");
					jinField.setText("");
					bField.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "输入有误！");
				}

			}
			else if (o == transButton32)
			{
				gField.setText("");
				kgField.setText("");
				jinField.setText("");
				bField.setText("");
			}
			else if (o == transButton41)
			{
				if (rmb.length() != 0 && dollar.length() == 0
						&& pand.length() == 0 && euro.length() == 0)
				{
					dollarField.setText("" + Double.valueOf(rmb) / 6.8521);
					pandField.setText("" + Double.valueOf(rmb) / 8.7529);
					euroField.setText("" + Double.valueOf(rmb) / 7.8532);
				}
				else if (rmb.length() == 0 && dollar.length() != 0
						&& pand.length() == 0 && euro.length() == 0)
				{
					rmbField.setText("" + Double.valueOf(dollar) * 8.7529);
					pandField.setText("" + Double.valueOf(dollar) / 0.7828);
					euroField.setText("" + Double.valueOf(dollar) / 0.8725);
				}
				else if (rmb.length() == 0 && dollar.length() == 0
						&& pand.length() != 0 && euro.length() == 0)
				{

					rmbField.setText("" + Double.valueOf(pand) * 0.1142);
					dollarField.setText("" + Double.valueOf(pand) * 0.7828);
					euroField.setText("" + Double.valueOf(pand) * 0.8972);
				}
				else if (rmb.length() == 0 && dollar.length() == 0
						&& pand.length() == 0 && euro.length() != 0)
				{
					rmbField.setText("" + Double.valueOf(euro) * 0.1273);
					dollarField.setText("" + Double.valueOf(euro) * 0.8725);
					pandField.setText("" + Double.valueOf(euro) * 1.1146);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "输入有误！");
				}

			}
			else if (o == transButton42)
			{
				rmbField.setText("");
				dollarField.setText("");
				pandField.setText("");
				euroField.setText("");
			}
		}
	}
}
