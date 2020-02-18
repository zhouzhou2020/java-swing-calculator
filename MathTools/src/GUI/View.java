package GUI;
/**
 * 文件名：CalulatorView.java
 * 项目-包：SuperCalulator - View
 * 作者：Biosone
 * 创建日期：2018-12-27
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Biosone
 * 类名：CalulatorView
 * 类说明：
 */
public class View extends JFrame
{
	protected JTabbedPane jtab, transpane, formulapane, helppane;
	protected JPanel calulatepane, drawpane;
	// calulatepane
	protected JButton[] key1;
	protected JTextField calField, resultField;
	protected JTextArea calArea;
	// drawpane
	protected JButton[] key2;
	protected JTextField drawField;
	protected JPanel drawxyPanel;

	// transpane
	protected JButton transButton11, transButton12, transButton21, transButton22,
			transButton31, transButton32, transButton41, transButton42;
	protected JTextField tenField, twoField, sixteenField;
	protected JTextField mField, cmField, mmField, kmField, liField;
	protected JTextField gField, kgField, jinField, bField;
	protected JTextField rmbField, pandField, dollarField, euroField;

	public View()
	{
		layoutcompents();
		launchframe();
	}

	public void launchframe()
	{
		setTitle("MathTools");
		setIconImage(new ImageIcon("image/math.png").getImage());
		setSize(560, 615);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		calField.requestFocusInWindow();
	}

	public void calulatepane()
	{
		// calulatepane
		calulatepane = new JPanel();
		key1 = new JButton[32];
		String[] keyname = { "1", "2", "3", "CE", "4", "5", "6", "C", "7", "8",
				"9", "/", "e", "0", "π", "*", "log", ".", "=", "+", "^2", "^3",
				"^", "-", "^(1/2)", "^(1/3)", "^(1/", "(", "sin(", "cos(",
				"tan(", ")" };
		JPanel keyPane1 = new JPanel();
		for (int i = 0; i < 32; i++)
		{
			key1[i] = new JButton(keyname[i]);
			keyPane1.add(key1[i]);
			if ("1234567890".indexOf(keyname[i])>=0)
			{
				key1[i].setForeground(Color.BLUE);
			}
			if ("'CE''=''c'".indexOf(keyname[i])>=0)
			{
				key1[i].setForeground(Color.RED);
			}
		}
		keyPane1.setLayout(new GridLayout(8, 4, 10, 5));
		calulatepane.setLayout(new BorderLayout());
		calulatepane.add(keyPane1, BorderLayout.SOUTH);

		calArea = new JTextArea();
		calArea.setEditable(false);
		JScrollPane caljsp = new JScrollPane(calArea);
		caljsp.setBorder(new TitledBorder("历史纪录"));

		calField = new JTextField();
		calField.setHorizontalAlignment(JTextField.RIGHT);
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBackground(Color.white);
		resultField.setHorizontalAlignment(JTextField.RIGHT);
		resultField.setText("0");
		JPanel resultPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JLabel resultLabel = new JLabel("结果:  ");
		resultPanel.setLayout(new BorderLayout());
		resultPanel.add(resultLabel, BorderLayout.WEST);
		resultPanel.add(resultField, BorderLayout.CENTER);
		northPanel.add(calField);
		northPanel.add(resultPanel);
		northPanel.setLayout(new GridLayout(2, 1));
		calField.setHorizontalAlignment(JTextField.RIGHT);
		
		calulatepane.add(northPanel, BorderLayout.NORTH);
		calulatepane.add(caljsp, BorderLayout.CENTER);
	}

	public void drawpane()
	{
		// drawpane
		drawpane = new JPanel();
		key2 = new JButton[28];
		String[] keyname = { "1", "2", "3", "重绘", "4", "5", "6", "绘制", "7",
				"8", "9", "/", ".", "0", "x", "*", "π", "(", ")", "+",
				"e", "log(", "^", "-", "sin(",
				"cos(", "tan(", "," };
		JPanel keyPane2 = new JPanel();
		for (int i = 0; i < 28; i++)
		{
			key2[i] = new JButton(keyname[i]);
			keyPane2.add(key2[i]);
			if ("1234567890".indexOf(keyname[i])>=0)
			{
				key2[i].setForeground(Color.BLUE);
			}
			if ("'重绘''绘制'x,".indexOf(keyname[i])>=0)
			{
				key2[i].setForeground(Color.RED);
			}
		}
		drawField = new JTextField();
		drawField.setHorizontalAlignment(JTextField.RIGHT);
		drawField.setEditable(false);
		drawField.setBackground(Color.white);
		drawxyPanel = new JPanel();
		drawxyPanel.setLayout(new BorderLayout());
		keyPane2.setLayout(new GridLayout(7, 4, 5, 0));
		drawpane.setLayout(new BorderLayout());
		drawpane.add(keyPane2, BorderLayout.SOUTH);
		drawpane.add(drawField, BorderLayout.NORTH);
		drawpane.add(drawxyPanel, BorderLayout.CENTER);
	}

	public void transpane()
	{
		// transpane
		transpane = new JTabbedPane(JTabbedPane.LEFT);
		JPanel transpane1 = new JPanel();
		JPanel transpane2 = new JPanel();
		JPanel transpane3 = new JPanel();
		JPanel transpane4 = new JPanel();
		transpane.add(transpane1, " 长度");
		transpane.add(transpane3, " 重量");
		transpane.add(transpane4, " 汇率");
		transpane.add(transpane2, " 进制");
		// 长度
		JPanel transpane11 = new JPanel();
		JPanel transpane12 = new JPanel();
		JLabel mLabel = new JLabel("       米/m");
		JLabel cmLabel = new JLabel("       厘米/cm");
		JLabel mmLabel = new JLabel("       毫米/mm");
		JLabel kmLabel = new JLabel("       千米/Km");
		JLabel liLabel = new JLabel("       里");
		mField = new JTextField();
		mmField = new JTextField();
		cmField = new JTextField();
		kmField = new JTextField();
		liField = new JTextField();
		transpane11.add(mLabel);
		transpane11.add(mField);
		transpane11.add(cmLabel);
		transpane11.add(cmField);
		transpane11.add(mmLabel);
		transpane11.add(mmField);
		transpane11.add(kmLabel);
		transpane11.add(kmField);
		transpane11.add(liLabel);
		transpane11.add(liField);
		transpane11.setLayout(new GridLayout(5, 2));
		transButton11 = new JButton("转换");
		transButton12 = new JButton("清空");
		transpane12.add(transButton11);
		transpane12.add(transButton12);
		transpane1.setLayout(new BoxLayout(transpane1, BoxLayout.Y_AXIS));
		transpane1.add(transpane11);
		transpane1.add(transpane12);

		// 进制
		JPanel transpane21 = new JPanel();
		JPanel transpane22 = new JPanel();
		JLabel tenLabel = new JLabel("       十进制");
		JLabel twoLabel = new JLabel("       二进制");
		JLabel sixteenLabel = new JLabel("       十六进制");
		tenField = new JTextField();
		twoField = new JTextField();
		sixteenField = new JTextField();
		transpane21.add(tenLabel);
		transpane21.add(tenField);
		transpane21.add(twoLabel);
		transpane21.add(twoField);
		transpane21.add(sixteenLabel);
		transpane21.add(sixteenField);
		transpane21.setLayout(new GridLayout(3, 2));
		transButton21 = new JButton("转换");
		transButton22 = new JButton("清空");
		transpane22.add(transButton21);
		transpane22.add(transButton22);
		transpane2.setLayout(new BoxLayout(transpane2, BoxLayout.Y_AXIS));
		transpane2.add(transpane21);
		transpane2.add(transpane22);

		// 重量
		JPanel transpane31 = new JPanel();
		JPanel transpane32 = new JPanel();
		JLabel gLabel = new JLabel("       克/g");
		JLabel kgLabel = new JLabel("       千克/Kg");
		JLabel jinLabel = new JLabel("       斤");
		JLabel bLabel = new JLabel("       磅");
		gField = new JTextField();
		kgField = new JTextField();
		jinField = new JTextField();
		bField = new JTextField();
		transpane31.setLayout(new GridLayout(4, 2));
		transpane31.add(gLabel);
		transpane31.add(gField);
		transpane31.add(kgLabel);
		transpane31.add(kgField);
		transpane31.add(jinLabel);
		transpane31.add(jinField);
		transpane31.add(bLabel);
		transpane31.add(bField);

		transButton31 = new JButton("转换");
		transButton32 = new JButton("清空");
		transpane32.add(transButton31);
		transpane32.add(transButton32);

		transpane3.setLayout(new BoxLayout(transpane3, BoxLayout.Y_AXIS));
		transpane3.add(transpane31);
		transpane3.add(transpane32);

		// 汇率
		JPanel transpane41 = new JPanel();
		JPanel transpane42 = new JPanel();
		JLabel rmbLabel = new JLabel("       人民币CNY");
		JLabel pandLabel = new JLabel("       英镑GPB");
		JLabel dollarLabel = new JLabel("       美元USD");
		JLabel euroLabel = new JLabel("       欧元EUR");
		rmbField = new JTextField();
		pandField = new JTextField();
		dollarField = new JTextField();
		euroField = new JTextField();
		transpane41.setLayout(new GridLayout(4, 2));
		transpane41.add(rmbLabel);
		transpane41.add(rmbField);
		transpane41.add(dollarLabel);
		transpane41.add(dollarField);
		transpane41.add(pandLabel);
		transpane41.add(pandField);
		transpane41.add(euroLabel);
		transpane41.add(euroField);

		transButton41 = new JButton("转换");
		transButton42 = new JButton("清空");
		transpane42.add(transButton41);
		transpane42.add(transButton42);
		transpane4.setLayout(new BoxLayout(transpane4, BoxLayout.Y_AXIS));
		transpane4.add(transpane41);
		transpane4.add(transpane42);
	}

	public void layoutcompents()
	{
		calulatepane();
		drawpane();
		transpane();
		
		// jtab
		jtab = new JTabbedPane();
		jtab.addTab("计算", new ImageIcon("image/计算.png"), calulatepane);
		jtab.addTab("作图", new ImageIcon("image/绘图.png"), drawpane);
		jtab.addTab("换算", new ImageIcon("image/换算.png"), transpane);
		
		// jfrme
		this.add(jtab);
	}
}
