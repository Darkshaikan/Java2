package ar.com.educacionit.exeptions.cheked;

public class DivisioPorCeroExeptions extends Exception {

	public DivisioPorCeroExeptions(String message) {
		super("Maxi" + message);
	}
}