package gh.funthomas424242.katas.duplikate;

import java.util.Date;

public class Buch extends BuchEntity {

	public Buch(String buchTitel, String autorName, Date herausgabeDatum) {
		super(buchTitel, autorName, herausgabeDatum);
	}

	@Override
	public int hashCode() {
		// TODO
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO
		return true;
	}

}
