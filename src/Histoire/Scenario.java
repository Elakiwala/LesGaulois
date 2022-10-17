package Histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 6);

		Gaulois obelix = new Gaulois("Obélix", 400);
		Druide panoramix = new Druide("Panoramix", 5, 10);

		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);

		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");


		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}