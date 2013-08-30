package gh.funthomas424242.katas.duplikate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.istack.internal.logging.Logger;

public class BuchTest {

	private static final String SER_TEMPFILE_EXT = "ser";
	private static final String SER_TEMPFILE_NAME = "BuchTest_Buch";
	private static final int STATISTIC_MINCOUNT = 1;
	private static final int STATISTIC_MAXCOUNT = 100;
	public final static String AUTOR_GOETHE = "Goethe";
	public final static String AUTOR_SCHILLER = "Schiller";
	public final static String AUTOR_LESSING = "Lessing";
	public final static String TITEL_FAUST = "Faust. Eine Tragödie.";
	public final static String TITEL_HANDSCHUH = "Der Handschuh";
	public final static String TITEL_NATHAN = "Nathan der Weise";
	public final static Calendar HERAUSGABE_FAUST = Calendar.getInstance();
	public final static Calendar HERAUSGABE_HANDSCHUH = Calendar.getInstance();
	public final static Calendar HERAUSGABE_NATHAN = Calendar.getInstance();

	private static Logger logger;

	@BeforeClass
	public static void initClass() {
		logger = Logger.getLogger(BuchTest.class);
		HERAUSGABE_FAUST.set(1808, 1, 1); // nur das Jahr bekannt
		HERAUSGABE_HANDSCHUH.set(1798, 1, 1); // nur das Jahr bekannt
		HERAUSGABE_NATHAN.set(1779, 1, 1); // nur das Jahr bekannt
	}

	/**
	 * Pflicht Anforderungen an equals
	 */
	@Test
	public void equalsReflexive() {
		final int anzahl = 100;
		final Buch[] instanzen = new Buch[anzahl];
		for (int i = STATISTIC_MINCOUNT; i < anzahl; i++) {
			instanzen[i] = new Buch(TITEL_FAUST, AUTOR_GOETHE,
					HERAUSGABE_FAUST.getTime());
		}

		for (int i = STATISTIC_MINCOUNT; i < anzahl; i++) {
			assertTrue(instanzen[i].equals(instanzen[i]));
		}
	}

	@Test
	public void equalsSymmetric() {
		final Buch buch1 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		final Buch buch2 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());

		assertTrue(buch1.equals(buch2));
		assertTrue(buch2.equals(buch1));
	}

	@Test
	public void equalsTransitive() {
		final Buch buch1 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		final Buch buch2 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		final Buch buch3 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());

		assertTrue(buch1.equals(buch2));
		assertTrue(buch2.equals(buch3));
		assertTrue(buch1.equals(buch3));
	}

	@Test
	public void equalsConsistent() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch3 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());

		for (int i = STATISTIC_MINCOUNT; i < 100; i++) {
			assertTrue(buch1.equals(buch2));
			assertFalse(buch1.equals(buch3));
		}

	}

	/**
	 * Pflicht Anforderungen an hashCode
	 */

	@Test
	public void hashCodeConsistent() {
		final Buch buch = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final int hashCode = buch.hashCode();
		for (int i = STATISTIC_MINCOUNT; i < STATISTIC_MAXCOUNT; i++) {
			assertEquals(hashCode, buch.hashCode());
		}

	}

	@Test
	public void hashCodeEqualsHashCode() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		assertEquals(buch1.hashCode(), buch2.hashCode());

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
		final Integer hash1 = buch1.hashCode();
		final Integer hash2 = buch2.hashCode();
		if (hash1.equals(hash2)) {
			logger.log(
					Level.INFO,
					"Optimierbar: Wenn zwei laut equals verschiedene Objekte auch verschiedene HashCodes liefern sind effizientere Suchen in HashMaps oder HashSets  realisierbar.");
		}

	}

	/**
	 * Test typischer Fallen
	 */

	@Test
	public void equalsNurEinAttribute() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_FAUST, AUTOR_SCHILLER,
				HERAUSGABE_FAUST.getTime());
		final Buch buch3 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_HANDSCHUH.getTime());

		final Buch buch4 = new Buch(TITEL_HANDSCHUH, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch5 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		assertNotEquals(buch1, buch2);
		assertNotEquals(buch1, buch3);
		assertNotEquals(buch1, buch4);
		assertNotEquals(buch1, buch5);
	}

	@Test
	public void hashCodeMapKeyTrap() {
		final Buch buch1 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch3 = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		final Buch buch2 = new Buch(TITEL_HANDSCHUH, AUTOR_SCHILLER,
				HERAUSGABE_HANDSCHUH.getTime());
		// Einfügen der Bücher in eine Hashmap
		final Hashtable<Buch, String> owners = new Hashtable<Buch, String>();
		owners.put(buch1, "Tomy");
		owners.put(buch2, "Sylvia");
		// jetzt wird der Eintrag von buch1 überschrieben
		owners.put(buch3, "Thomas");
		// hier muss Buch3 zurück kommen
		String owner = owners.get(buch1);
		assertEquals("Thomas", owner);
		// "Sylvia" because buch2 has the same hashcode
		final String ownerName = owners.get(new Buch(TITEL_HANDSCHUH,
				AUTOR_SCHILLER, HERAUSGABE_HANDSCHUH.getTime()));
		assertEquals("Sylvia", ownerName);
	}

	@Test
	public void hashCodeSerializeTrap() {
		final Buch buch = new Buch(TITEL_FAUST, AUTOR_GOETHE,
				HERAUSGABE_FAUST.getTime());
		// increment the viewCount (transient attribute)
		buch.getBuchTitel();
		final Map<Buch, String> map = new HashMap<Buch, String>();
		map.put(buch, "Thomas");

		final Path path = serializeBuch(buch);
		final Buch buchEingelesen = deserializeBuch(path);
		assertEquals(map.get(buchEingelesen), "Thomas");

	}

	public Buch deserializeBuch(final Path path) {
		Buch buch = null;
		InputStream inStream = null;
		ObjectInputStream oinStream = null;
		try {
			inStream = Files.newInputStream(path, StandardOpenOption.READ);
			oinStream = new ObjectInputStream(inStream);
			buch = (Buch) oinStream.readObject();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oinStream != null) {
				try {
					oinStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return buch;
	}

	public Path serializeBuch(final Buch buch) {
		Path path = null;
		OutputStream outStream = null;
		ObjectOutputStream ooutStream = null;
		try {

			path = Files.createTempFile(null, SER_TEMPFILE_EXT);
			outStream = Files.newOutputStream(path, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
			ooutStream = new ObjectOutputStream(outStream);
			ooutStream.writeObject(buch);
			ooutStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ooutStream != null) {
					ooutStream.close();
				} else {
					if (outStream != null) {
						outStream.close();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return path;
	}
}
