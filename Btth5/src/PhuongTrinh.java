
public class PhuongTrinh {
	private double soA, soB;

	public PhuongTrinh(double soA, double soB) {
		super();
		this.soA = soA;
		this.soB = soB;
	}

	public double Gia() {
		return -this.soB / this.soA;
	}

}
