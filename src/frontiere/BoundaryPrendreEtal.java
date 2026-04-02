package frontiere;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
		this.controlVerifierIdentite = 
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut être habitant de notre village pour commercer ici\n");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé\n");
			}
			else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !\n Il me faudrait quelques renseignements");
		String produit = Clavier.entrerChaine("Que souhaitez vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre\n");
		controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

	}
}