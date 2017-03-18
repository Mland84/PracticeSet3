package pkgLibrary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ps3Book.Book;
import Ps3Book.BookException;
import Ps3Book.Catalog;

public class BookOpTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws BookException {
		Book b = new Book();
		b.setBookId("1");
		Catalog a = null;
		Catalog cat = a.ReadXMLFile();
		cat.addBook(cat, b);
		Book b1 = new Book();
		b1.setBookId("bk101");
		cat.addBook(cat, b1);

		assertEquals(cat.getBooks().size(), 13);
	}
}
