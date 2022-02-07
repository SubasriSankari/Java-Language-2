
class Complex {
	private double re, im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	@Override
	public String toString() {
		return String.format(re + " + i" + im);
	}
}

public class ComplexClass {
	public static void main(String[] args) {
		Complex c1 = new Complex(10, 15);
		System.out.println(c1);
	}
}
