import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class Calculadora {

	// Creem Components:
	JFrame jpVentana;
	JPanel jpVentGen;
	JPanel jpVentBtn;
	JPanel jpVentNum;
	JPanel jpVentOper;
	JPanel jpVentOper2;
	JTextField jtfPantalla;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnC, btnMas, btnMenos, btnMult, btnDiv, btnIgual, btnCambio, btnRaiz, btnPot, btnPor;
	BoxLayout bxlGeneral;
	GridLayout glBotones;
	GridLayout glNumeros;
	GridLayout glOperador;
	GridLayout glOperador2;
	
	String calc;
	float calcNum;
	float lastCalc=0;
	int oper=0;
	int num1;
	int num2;
	int total;
		
	public Calculadora() {
		// Initzialitzem Contenidors:
		jpVentana = new JFrame("Calculadora +");
		jpVentGen = new JPanel();
		jpVentBtn = new JPanel();
		jpVentNum = new JPanel();
		jpVentOper = new JPanel();
		jpVentOper2 = new JPanel();
		
		// Initzialitzem Components:
		jtfPantalla = new JTextField();
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnC = new JButton("Clear");
		btnMas = new JButton("+");
		btnMenos = new JButton("-");
		btnMult = new JButton("x");
		btnDiv = new JButton("/");
		btnIgual = new JButton("=");
		
		btnCambio = new JButton("Scien");
		
		btnRaiz = new JButton("Raiz");
		btnPor = new JButton("%");
		btnPot = new JButton("x^");
		
		// Initzialitzem Layouts:
		bxlGeneral = new BoxLayout(jpVentGen, BoxLayout.PAGE_AXIS);
		glBotones = new GridLayout(1, 3, 10, 10);
		glNumeros = new GridLayout(4, 3, 10, 10);
		glOperador = new GridLayout(4, 1, 10, 10);
		glOperador2 = new GridLayout(3, 1);
		
		
		// Assignem els Layouds
		jpVentGen.setLayout(bxlGeneral);
		jpVentBtn.setLayout(glBotones);
		jpVentNum.setLayout(glNumeros);
		jpVentOper.setLayout(glOperador);
		jpVentOper2.setLayout(glOperador2);
		
		jpVentOper2.setVisible(false);
		
		// Afegim el JTextField al JPanel general que esta contruit per un BoxLayoud.
		jpVentGen.add(jtfPantalla);
		
		// 
		jpVentGen.add(btnCambio);
		//
		jpVentOper2.add(btnRaiz);
		jpVentOper2.add(btnPot);
		jpVentOper2.add(btnPor);
		
		// Afegim els botons dins del GridLayoud y Jpanel Ventana Botons
		
		jpVentNum.add(btn1);
		jpVentNum.add(btn2);
		jpVentNum.add(btn3);
		jpVentNum.add(btn4);
		jpVentNum.add(btn5);
		jpVentNum.add(btn6);
		jpVentNum.add(btn7);
		jpVentNum.add(btn8);
		jpVentNum.add(btn9);
		jpVentNum.add(btnC);
		jpVentNum.add(btn0);
		jpVentNum.add(btnIgual);
				
		// Afegim els botons dins del GridLayoud y Jpanel Ventana Operadors
		jpVentOper.add(btnMas);
		jpVentOper.add(btnMenos);
		jpVentOper.add(btnMult);
		jpVentOper.add(btnDiv);
		
		// Afegim el JPanell de numeros y operadors dins del Jpanel de botons. Per poder posar els 2 Grid dins.
		jpVentBtn.add(jpVentNum);
		jpVentBtn.add(jpVentOper2);
		jpVentBtn.add(jpVentOper);
		
		
		// Afegim el Jpanel de botons al General.
		jpVentGen.add(jpVentBtn);
		

		
		// Ultims pasos IMPORTANTS
		
		jpVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpVentana.setContentPane(jpVentGen);
		jpVentana.pack();
		jpVentana.setVisible(true);
		jpVentana.setResizable(false);
		
		btn0.addActionListener(new ActionNumeros());
		btn1.addActionListener(new ActionNumeros());
		btn2.addActionListener(new ActionNumeros());
		btn3.addActionListener(new ActionNumeros());
		btn4.addActionListener(new ActionNumeros());
		btn5.addActionListener(new ActionNumeros());
		btn6.addActionListener(new ActionNumeros());
		btn7.addActionListener(new ActionNumeros());
		btn8.addActionListener(new ActionNumeros());
		btn9.addActionListener(new ActionNumeros());
		btnMas.addActionListener(new ActionOperadores());
		btnMenos.addActionListener(new ActionOperadores());
		btnMult.addActionListener(new ActionOperadores());
		btnDiv.addActionListener(new ActionOperadores());
		btnC.addActionListener(new ActionOperadores());
		btnIgual.addActionListener(new ActionOperadores());
		btnCambio.addActionListener(new ActionOperadores());
	}
	
	class ActionNumeros implements ActionListener 	// Poder tener mas de 1 actionPerformed
	{
		public void actionPerformed(ActionEvent x) 	// Va hacer la accion actionPerformed
		{ 
			// calc=jtfPantalla.getText();
			
			if (x.getSource() == btn0){
				// jtfPantalla.setText(calc + "0");
				if(oper==0){
					jtfPantalla.setText("0");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("0");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn1){
				//jtfPantalla.setText(calc + "1");
				if(oper==0){
					jtfPantalla.setText("1");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("1");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn2){
				//jtfPantalla.setText(calc + "2");
				if(oper==0){
					jtfPantalla.setText("2");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("2");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn3){
				//jtfPantalla.setText(calc + "3");
				if(oper==0){
					jtfPantalla.setText("3");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("3");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn4){
				//jtfPantalla.setText(calc + "4");
				if(oper==0){
					jtfPantalla.setText("4");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("4");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn5){
				//jtfPantalla.setText(calc + "5");
				if(oper==0){
					jtfPantalla.setText("5");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("5");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn6){
				//jtfPantalla.setText(calc + "6");
				if(oper==0){
					jtfPantalla.setText("6");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("6");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn7){
				//jtfPantalla.setText(calc + "7");
				if(oper==0){
					jtfPantalla.setText("7");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("7");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn8){
				//jtfPantalla.setText(calc + "8");
				if(oper==0){
					jtfPantalla.setText("8");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("8");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
			if (x.getSource() == btn9){
				//jtfPantalla.setText(calc + "9");
				if(oper==0){
					jtfPantalla.setText("9");
					num1 = Integer.parseInt(jtfPantalla.getText());
					oper=1;
					
				}
				else
				{
					jtfPantalla.setText("9");
					num2 = Integer.parseInt(jtfPantalla.getText());
				}
			}
		}
	}
	
	class ActionOperadores implements ActionListener 	// Poder tener mas de 1 actionPerformed
	{
		public void actionPerformed(ActionEvent x) 		// Va hacer la accion actionPerformed
		{ 
			// calcNum = Float.parseFloat(jtfPantalla.getText());
			
			if (x.getSource() == btnMas){
				//calc = "0";
				//jtfPantalla.setText("");
				oper=1;
			}
			if (x.getSource() == btnMenos){
				//calc = "0";
				//jtfPantalla.setText("");
				oper=2;
			}
			if (x.getSource() == btnMult){
				//calc = "0";
				//jtfPantalla.setText("");
				oper=3;
			}
			if (x.getSource() == btnDiv){
				//calc = "0";
				//jtfPantalla.setText("");
				oper=4;
			}
			if (x.getSource() == btnC){
				//lastCalc=0;
				//calcNum=0;
				//calc="0";
				jtfPantalla.setText("");
				num1=0;
				num2=0;
				oper=0;
			}	
			
				if (oper==1)
				{
					//lastCalc=lastCalc+calcNum;
					total = num1 + num2;
				}
				if (oper==2)
				{
					//lastCalc=lastCalc-calcNum;
					total = num1 - num2;
				}
				if (oper==3)
				{
					//lastCalc=lastCalc*calcNum;
					total = num1 * num2;
				}
				if (oper==4)
				{
					//lastCalc=lastCalc/calcNum;
					total = num1 / num2;
				}
				
			if (x.getSource() == btnIgual){

				jtfPantalla.setText(String.valueOf(total));
				//lastCalc=0;
				num1=0;
				num2=0;
				oper=0;
			}
			
				if (x.getSource() == btnCambio){
					jpVentOper2.setVisible(!jpVentOper2.isVisible());
					String texto = btnCambio.getText();
					if (texto =="Normal")
					{
						btnCambio.setText("Scien");
					}
					else 
					{ 
						btnCambio.setText("Normal");
					}
					jpVentana.pack();
					}
				}
			}
		
	
	public static void main(String[] args) {
		Calculadora c = new Calculadora();
	}
}


