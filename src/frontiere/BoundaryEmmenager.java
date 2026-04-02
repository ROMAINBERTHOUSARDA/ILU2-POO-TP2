package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur + ".\n");
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Quelle est votre force ?\n");
					int forceVisiteur = Clavier.entrerEntier(questionForce.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,forceVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionPotionMin = new StringBuilder();
		StringBuilder questionPotionMax = new StringBuilder();
		boolean ValPotionOK = false;
		int potionMin = 0;
	    int potionMax = 0;

		questionPotionMin.append("Quelle est la force de la potion la plus faible que vous produisez ?\n");
		questionPotionMax.append("Quelle est la force de la potion la plus forte que vous produisez ?\n");
		
		while (!ValPotionOK) {
			potionMin = Clavier.entrerEntier(questionPotionMin.toString());
			potionMax = Clavier.entrerEntier(questionPotionMax.toString());
			
			if (potionMin <= potionMax) {
				ValPotionOK = true;
			} else {
				System.out.println("Attention Druide, vous vous êtes trompés entre le max et le min");
			}
		}
		StringBuilder questionForceDruide = new StringBuilder();
		questionForceDruide.append("Quelle est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(questionForceDruide.toString());
		controlEmmenager.ajouterDruide( nomVisiteur, forceDruide, potionMin, potionMax);

	}

}
