/**
 */
package ca.udacity.saad.library;

public class Card {
	private final int cardNumber;

	protected Card(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (cardNumber: ");
		result.append(cardNumber);
		result.append(')');
		return result.toString();
	}

}
