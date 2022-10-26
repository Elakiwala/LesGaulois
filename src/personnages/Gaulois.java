package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nb_trophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " \" " + texte + " \" ");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup das la machoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	public Equipement[] getTrophees() {
		return trophees;
	}
	
	public void setTrophees(Equipement[] trophees) {
		this.trophees = trophees;
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + effetPotion + " fois déculplée");
	}
	
	public void faireUneDonnation(Musee musee) {
		if (this.nb_trophees > 0) {
			this.parler(" Je donne au musee tous mes trophees ");

			for (int i = 0; trophees[i] != null && i < this.nb_trophees; i++) {
				System.out.println("je te donne un " + trophees[i] + "!");
				Gaulois gauloise = new Gaulois(this.nom, this.force);
				musee.donnerTrophees(gauloise, trophees[i]);

			}
		}

	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);

		asterix.boirePotion(6);
	}

}
