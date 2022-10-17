package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert(force>0):"force négative";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + " \" " + texte + " \" ");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert (force>0):"force négative";
		int forceav = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (forceav < force):"la force d'un Romain n'a pas diminué";
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2:
			{
				System.out.println("Le soldat "+ nom +" est déjà bien protégé !");
				break;
			}
			case 1:
			{
				if(equipements[0] == equipement) {
					System.out.println("Le soldat "+ nom +" possède déjà un "+ equipement+" !");
					break;
				}
				else {
					equipement(equipement);
					System.out.println("Le soldat "+ nom +" s'équipe avec un "+ equipement +".");
					break;
				}
			}
			default:{
				equipement(equipement);
				System.out.println("Le soldat "+ nom +" s'équipe avec un "+ equipement +".");
				break;
			}
		}
	}
		
	private void equipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
