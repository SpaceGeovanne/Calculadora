package me.space.calculator.api;

public class Equação {
	
	public static String calcular(String first, String second, String last) {
		int a = Integer.parseInt(first);
		int b = Integer.parseInt(second);
		int c = Integer.parseInt(last);
		String result = "";
		String equação = gerar(a, b, c);
		int delta = delta(a, b, c);
		if(delta < 0) {
			result = "Delta é negativo, logo x não pertence aos numeros reais!";
		} else {
			result = resolver(a, b, c);
		}
		
		return equação + " ; " + delta + " ; " + result;
	}
	
	private static String resolver(int a, int b, int c) {
		double delta = delta(a, b, c);
		
		double x1 = ((-b + (Math.sqrt(delta)))/( 2*a ));
				
		double x2 = ((-b - (Math.sqrt(delta)))/(2*a));
	
        return "O valor de x¹ é: " + x1 + "; O valor de x² é: " + x2;
	}
	
	private static Integer delta(int a, int b, int c) {
		return b*b - 4*a*c;
	}

	private static String gerar(int a, int b, int c) {
		String resultado = "";
		if(a < 0) {
			resultado = a + "x²";  
		} else if(a > 0) {
			resultado = a + "x²";
		}
		if(b == 0) {} else if(b < 0) {
			resultado = resultado + b + "x";
		} else if(b > 0) {
			resultado = resultado + "+" + b + "x";
		}
		
		if(c == 0) {} else if(c < 0) {
			resultado = resultado + c;
		} else if(c > 0) {
			resultado = resultado + "+" + c;
		}
		return resultado;
	}

}
