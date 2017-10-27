public final class Euros {

	private Euros() {

	}

	public static final double CAD_TO_EU = 0.6811;
	public static final double RUP_TO_EU = 0.013050;

	// @precondition amount must be an double
	public static double fromDollars(double amount) {
		return amount * CAD_TO_EU;
	}

	// @precondition amount must be an double
	public static double fromRupees(double amount) {
		return amount * RUP_TO_EU;
	}

}
