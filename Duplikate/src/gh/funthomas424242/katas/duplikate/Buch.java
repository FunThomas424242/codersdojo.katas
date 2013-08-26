package gh.funthomas424242.katas.duplikate;

import java.util.Date;

public class Buch extends BuchEntity {

	public Buch(String buchTitel, String autorName, Date herausgabeDatum) {
		super(buchTitel, autorName, herausgabeDatum);
	}

	@Override
	public int hashCode() {
		// TODO ersetzte durch eine korrekte Implementierung
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO ersetzte durch eine korrekte Implementierung
		return super.equals(obj);
	}

}
