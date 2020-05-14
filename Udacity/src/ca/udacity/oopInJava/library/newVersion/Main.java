package ca.udacity.oopInJava.library.newVersion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();
		
		Patron p1 = new Patron(10, library);
		Patron p2 = new Patron(12, library);
		Patron p3 = new Patron(20, library);
		Patron p4 = new Patron(30, library);
		
		Title t1 = new Title("La religion perenne", 'S', 100, 3);
		Title t2 = new Title("Du Divin a l'humain", 'S', 100, 5);
		Title t3 = new Title("Resume de Metaphysique", 'S', 100, 1);
		Title t4 = new Title("Meknassia", 'A', 30, 1);
		Title t5 = new Title("Pif", 'M', 10, 1);
		
		System.out.println("Ajout de 4 utilisateurs (Patron p1 a p4) a la librairie");
		System.out.println(library.addPatron(p1));
		System.out.println(library.addPatron(p2));
		System.out.println(library.addPatron(p3));
		System.out.println(library.addPatron(p4));
		
		System.out.println("Ajout de 3 exemplaires du livre (Book i1) \"La religion perenne\"");
		System.out.println(library.addTitle(t1)); 
		System.out.println("Ajout de 5 exemplaires du livre (Book i2) \"Du Divin a l'humain\"");
		System.out.println(library.addTitle(t2));
		System.out.println("Ajout de 1 exemplaire du livre (Book i3) \"Resume de Metaphysique\"");
		System.out.println(library.addTitle(t3));
		System.out.println("Ajout de 1 exemplaire audio-videoe (AudioVideo i4) \"Meknassia\"");
		System.out.println(library.addTitle(t4));
		System.out.println("Ajout de 1 exemplaire magasine (magazine i5) \"Pif\"");
		System.out.println(library.addTitle(t5));
		
		System.out.println("Test: 3 check out de \"La religion perenne\" par 2 enfants (12 ans et moins) et un adulte => true true true");
		Loanable i1 = t1.getAvailableLoanableCopie();
		System.out.println(p1.checkOutItem(i1));
		Loanable i2 = t1.getAvailableLoanableCopie();
		System.out.println(p2.checkOutItem(i2));
		Loanable i3 = t1.getAvailableLoanableCopie();
		System.out.println(p3.checkOutItem(i3)); 
				
		System.out.println("Test: Tentative de recheck du meme exemplaire par l'adulte => false");
		System.out.println(p3.checkOutItem(i3));
		
		System.out.println("Test: Request par un second adulte de \"La religion perenne\" qui n'est plus disponible => true");
		System.out.println(p4.requestTitle(t1));
		
		System.out.println("Test: Request une seconde fois par le meme second adulte de \"La religion perenne\" alors que sa 1ere demande est toujours en cour => false");
		System.out.println(p4.requestTitle(t1));
		
		System.out.println("Test: Retour par le premier adulte de \"La religion perenne\" => true");
		System.out.println("library va automatiquement appeler la methode checkOutItem(String title) du second adulte.");
		System.out.println(p3.returnCheckout(i3));
		System.out.println("Test: verifions que le second adulte (ID: 4) a bien recu \"La religion perenne\" => true");
		p4.listLoans();
		
		System.out.println("============================================================================================================");
		library.listAllPatrons();
		System.out.println("============================================================================================================");
		library.listAllLoans();
		System.out.println("============================================================================================================");
		library.listAllTitles();
		System.out.println("============================================================================================================");
		library.listAllItems();
	}

}
