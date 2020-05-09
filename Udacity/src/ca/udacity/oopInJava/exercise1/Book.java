package ca.udacity.oopInJava.exercise1;

/*
 *  EXAMPLE OF IMPLEMENTIG THE COMPARABLE INTERFACE
 *  
    If a book has more pages than the other, then the book with the more pages goes first.
    If both books have the same number of pages, then sort by the title alphabetically.
    If both books have the same number of pages and the same title, then sort by the author alphabetically.

 * 
 */

public class Book implements Comparable<Book> {
	int numberOfPages;
	String title;
	String author;
	
	public int compareTo(Book otherBook) {
		if (this.numberOfPages != otherBook.numberOfPages)
			return this.numberOfPages - otherBook.numberOfPages;
		if (!this.title.equals(otherBook.title))
				return this.title.compareTo(otherBook.title);
		return this.author.compareTo(otherBook.author);
	}
}
