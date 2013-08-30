package gh.funthomas424242.katas.duplikate;

import java.io.Serializable;
import java.util.Date;

public class BuchEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 414794656668860365L;

	private static Long lastGlobalId = 0L;

	protected Long Id;
	protected String autorName;
	protected String buchTitel;
	protected Date herausgabeDatum;
	transient protected Long viewCount;

	private synchronized Long nextId() {
		return ++lastGlobalId;
	}

	public BuchEntity(final String buchTitel, final String autorName,
			final Date herausgabeDatum) {
		this.Id = nextId();
		this.buchTitel = buchTitel;
		this.autorName = autorName;
		this.herausgabeDatum = herausgabeDatum;
		this.viewCount = 0L;
	}

	public Long getId() {
		viewCount++;
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAutorName() {
		viewCount++;
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public String getBuchTitel() {
		viewCount++;
		return buchTitel;
	}

	public void setBuchTitel(String buchTitel) {
		this.buchTitel = buchTitel;
	}

	public Date getHerausgabeDatum() {
		viewCount++;
		return herausgabeDatum;
	}

	public void setHerausgabeDatum(Date herausgabeDatum) {
		this.herausgabeDatum = herausgabeDatum;
	}

}
