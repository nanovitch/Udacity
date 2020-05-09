package ca.udacity.saad.library;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();
		
		Patron p1 = new Patron(10, library);
		Patron p2 = new Patron(12, library);
		Patron p3 = new Patron(20, library);
		Patron p4 = new Patron(30, library);
		
		Item i1 = new Book("La religion perenne", 80, true);
		Item i2 = new Book("Du Divin a l'humain", 90, true);
		Item i3 = new Book("Resume de Metaphysique", 85, true);
		Item i4 = new AudioVideo("Meknassia", 35);
		Item i5 = new Magazine("Pif");
		
		System.out.println("Ajout de 4 utilisateurs (Patron p1 a p4) a la librairie");
		System.out.println(library.addPatron(p1));
		System.out.println(library.addPatron(p2));
		System.out.println(library.addPatron(p3));
		System.out.println(library.addPatron(p4));
		
		System.out.println("Ajout de 3 exemplaires du livre (Book i1) \"La religion perenne\"");
		System.out.println(library.addItem(i1, 2)); // addItem(i (item a ajouter), 2 (nombre de copies supplementaires)) ==> nbre total d'exemplaires = 3
		System.out.println("Ajout de 5 exemplaires du livre (Book i2) \"Du Divin a l'humain\"");
		System.out.println(library.addItem(i2, 4));
		System.out.println("Ajout de 1 exemplaire du livre (Book i3) \"Resume de Metaphysique\"");
		System.out.println(library.addItem(i3, 1));
		System.out.println("Ajout de 1 exemplaire audio-videoe (AudioVideo i4) \"Meknassia\"");
		System.out.println(library.addItem(i4, 1));
		System.out.println("Ajout de 1 exemplaire magasine (magazine i5) \"Pif\"");
		System.out.println(library.addItem(i5, 1));
		
		System.out.println("Test: 3 check out de \"La religion perenne\" par 2 enfants (12 ans et moins) et un adulte => true true true");
		System.out.println(p1.checkOutItem("La religion perenne"));
		System.out.println(p2.checkOutItem("La religion perenne"));
		System.out.println(p3.checkOutItem("La religion perenne")); 
		
		System.out.println("Test: Tentative de recheck du meme exemplaire par l'adulte => false");
		System.out.println(p3.checkOutItem("La religion perenne"));
		
		System.out.println("Test: Request par un second adulte de \"La religion perenne\" qui n'est plus disponible => true");
		System.out.println(p4.requestTitle("La religion perenne"));
		
		System.out.println("Test: Request une seconde fois par le meme second adulte de \"La religion perenne\" alors que sa 1ere demande est toujours en course => false");
		System.out.println(p4.requestTitle("La religion perenne"));
		
		System.out.println("Test: Retour par le premier adulte de \"La religion perenne\" => true");
		System.out.println("library va automatiquement appeler la methode checkOutItem(String title) du second adulte.");
		System.out.println(p3.returnCheckout("La religion perenne"));
		System.out.println("Test: verifions que le second adulte (ID: 4) a bien recu \"La religion perenne\" => true");
		p4.listCheckouts();
		
		System.out.println("============================================================================================================");
		
		library.listAllPatrons();
		library.listAllItems();
	}

}
