package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		 return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois: ");
		for(int i=0; i<nbVillageois;i++) {
			
			System.out.println("- " + villageois[i]);
		}
	}
	public static void main(String[] args) {
		Village village;
		village = new Village("Village des Irréductibles", 30);
		
		//Gaulois gaulois = village.trouverHabitant(30);
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
		//at personnages.Village.trouverHabitant(Village.java:28)
		//at personnages.Village.main(Village.java:34)
		//parce que le gaulois num�ro 30 n'est pas clairement d�finit
		
		Chef abraracourcix;
		abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix;
		asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//affiche null
		//parce que toutes les cases sont vides et pour avoir asterix il faut mettre a 0
		
		Gaulois obelix;
		obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
	
}

