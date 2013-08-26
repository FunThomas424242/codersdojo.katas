package gh.funthomas424242.katas.duplikate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import java.util.Calendar;
import java.util.Hashtable;

import org.junit.BeforeClass;
import org.junit.Test;

public class BuchTest {

	public final static String AUTOR_GOETHE = "Goethe";
	public final static String AUTOR_SCHILLER = "Schiller";
	public final static String AUTOR_LESSING = "Lessing";
	public final static String TITEL_FAUST = "Faust. Eine Tragödie.";
	public final static String TITEL_HANDSCHUH = "Der Handschuh";
	public final static String TITEL_NATHAN = "Nathan der Weise";
	public final static Calendar HERAUSGABE_FAUST = Calendar.getInstance();
	public final static Calendar HERAUSGABE_HANDSCHUH = Calendar.getInstance();
	public final static Calendar HERAUSGABE_NATHAN = Calendar.getInstance();

	@BeforeClass
	public static void initClass() {
		HERAUSGABE_FAUST.set(1808, 1, 1); // nur das Jahr bekannt
		HERAUSGABE_HANDSCHUH.set(1798, 1, 1); // nur das Jahr bekannt
		HERAUSGABE_NATHAN.set(1779, 1, 1); // nur das Jahr bekannt
	}

	/**
	 * Pflicht Anforderungen an hashCode
	 */

	@Test
	public void hashCodeImmerGleich() {
		final Buch buch = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final int hashCode = buch.hashCode();
		for (int i = 1; i < 100; i++) {
			assertEquals(hashCode, buch.hashCode());
		}

	}

	@Test
	public void gleicheBuecherGleicheHashCodes() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		assertEquals(buch1.hashCode(), buch2.hashCode());

	}

	@Test
	public void gleicheBuecherUeberschreibenSichInEinerMap() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch3 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		// Einfügen der Bücher in eine Hashmap
		final Hashtable<Integer, Buch> map = new Hashtable<Integer, Buch>();
		map.put(buch1.hashCode(), buch1);
		map.put(buch2.hashCode(), buch2);
		// jetzt wird der Eintrag von buch1 überschrieben
		map.put(buch3.hashCode(), buch3);
		// hier muss Buch3 zurück kommen
		Buch buch = map.get(buch1.hashCode());
		assertSame(buch3, buch);

	}

	/**
	 * Optionale Anforderungen an hashCode (nicht notwendig aber verbessert die
	 * Performance)
	 */
	@Test
	public void ungleicheBuecherVerschiedeneHashCodes() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		assertNotEquals(buch1.hashCode(), buch2.hashCode());

	}
}
