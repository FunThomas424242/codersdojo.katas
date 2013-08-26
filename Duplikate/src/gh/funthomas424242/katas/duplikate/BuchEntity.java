package gh.funthomas424242.katas.duplikate;

import java.util.Date;

public class BuchEntity {

	private static Long lastGlobalId = 0L;

	protected Long Id;
	protected String autorName;
	protected String buchTitel;
	protected Date herausgabeDatum;

	private synchronized Long nextId() {
		return ++lastGlobalId;
	}

	public BuchEntity(final String buchTitel, final String autorName,
			final Date herausgabeDatum) {
		this.Id = nextId();
		this.buchTitel = buchTitel;
		this.autorName = autorName;
		this.herausgabeDatum = herausgabeDatum;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAutorName() {
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public String getBuchTitel() {
		return buchTitel;
	}

	public void setBuchTitel(String buchTitel) {
		this.buchTitel = buchTitel;
	}

	public Date getHerausgabeDatum() {
		return herausgabeDatum;
	}

	public void setHerausgabeDatum(Date herausgabeDatum) {
		this.herausgabeDatum = herausgabeDatum;
	}

}
