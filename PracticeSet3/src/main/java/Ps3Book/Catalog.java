package Ps3Book;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import Ps3Book.Book;
import Ps3Book.BookException;
import Ps3Book.Catalog;

public class Catalog {
	

		@XmlAttribute
		String id;

		@XmlElement(name = "book")
		ArrayList<Book> books;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public ArrayList<Book> getBooks() {
			return books;
		}

		public void setBooks(ArrayList<Book> books) {
			this.books = books;
		}

		public static void WriteXMLFile(Catalog cat) {
			try {

				String basePath = new File("").getAbsolutePath();
				basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
				File file = new File(basePath);

				JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(cat, file);
				jaxbMarshaller.marshal(cat, System.out);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		public static Catalog ReadXMLFile() {

			Catalog cat = null;

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			System.out.println(file.getAbsolutePath());
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
				System.out.println(cat);
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			return cat;
		}

		public void addBook(Catalog cat, Book new_book) throws BookException {

			cat = ReadXMLFile();

			for (Book book : cat.getBooks()) {
				if (book.getBookId().compareTo(new_book.getBookId())==0) {
					throw new BookException();
				} else {
					cat.getBooks().add(new_book);
					WriteXMLFile(cat);
				}
			}
		}

		public Book getBook(Catalog cat, Book id) throws BookException {
			cat = ReadXMLFile();
			for (Book b : cat.getBooks()) {
				if (( cat.getBook(cat, id))==b ) {
					throw new BookException();
				}
			}
			return null;
		}
	}

