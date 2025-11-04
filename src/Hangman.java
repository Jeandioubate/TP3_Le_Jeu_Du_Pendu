
import java.util.Scanner;


public class Hangman {

	public static void main(String[] args) {
		 Scanner scanr = new Scanner(System.in);

	        // Liste prédéfinie de mots
	        String[] words = {"maison", "ordinateur", "java", "pendu",
	                          "developpeur", "clavier", "souris", "ecran"};

	        // Choisir un mot aléatoire
	        int indexWord = (int)(Math.random() * words.length);
	        String secretWord = words[indexWord];

	        // Variables du jeu
	        char[] foundLetters = new char[secretWord.length()];
	        char[] incorrectLetters = new char[10];
	        int errors = 0;
	        int correctLetters = 0;
	        int indexIncorrectLetters = 0;
	        boolean gameOver = false;

	        // Initialiser l'affichage avec des tirets
	        for (int i = 0; i < foundLetters.length; i++) {
	            foundLetters[i] = '_';
	        }

	        System.out.println("=== JEU DU PENDU ===");
	        System.out.println("Devinez le mot en proposant des lettres.");
	        System.out.println("Vous avez droit à 10 erreurs maximum.");

	        // Boucle principale du jeu
	        while (!gameOver) {
	            // Afficher l'état actuel du mot
	            System.out.print("\nMot à deviner: ");
	            for (int i = 0; i < foundLetters.length; i++) {
	                System.out.print(foundLetters[i] + " ");
	            }
	            System.out.println();

	            // Afficher les lettres incorrectes si elles existent
	            if (indexIncorrectLetters > 0) {
	                System.out.print("Lettres incorrectes: ");
	                for (int i = 0; i < indexIncorrectLetters; i++) {
	                    System.out.print(incorrectLetters[i] + " ");
	                }
	                System.out.println();
	            }

	            // Afficher le nombre d'erreurs
	            System.out.println("Erreurs: " + errors + "/10");

	            // Demander une lettre
	            System.out.print("Proposez une lettre: ");
	            String input = scanr.nextLine();

	            // Vérifier que l'input est une seule lettre
	            if (input.length() != 1) {
	                System.out.println("Veuillez entrer une seule lettre !");
	                continue;
	            }

	            char letter = input.charAt(0);

	            // Convertir en minuscule si nécessaire
	            if (letter >= 'A' && letter <= 'Z') {
	                letter = (char)(letter + 32);
	            }

	            // Vérifier si c'est une lettre valide
	            if (letter < 'a' || letter > 'z') {
	                System.out.println("Veuillez entrer une lettre valide !");
	                continue;
	            }

	            // Vérifier si la lettre a déjà été proposée
	            boolean letterAlreadyProposed = false;

	            // Vérifier dans les lettres trouvées
	            for (int i = 0; i < foundLetters.length; i++) {
	                if (foundLetters[i] == letter) {
	                    letterAlreadyProposed = true;
	                    break;
	                }
	            }

	            // Vérifier dans les lettres incorrectes
	            if (!letterAlreadyProposed) {
	                for (int i = 0; i < indexIncorrectLetters; i++) {
	                    if (incorrectLetters[i] == letter) {
	                        letterAlreadyProposed = true;
	                        break;
	                    }
	                }
	            }

	            if (letterAlreadyProposed) {
	                System.out.println("Vous avez déjà proposé cette lettre !");
	                continue;
	            }

	            // Vérifier si la lettre est dans le mot
	            boolean letterFound = false;
	            for (int i = 0; i < secretWord.length(); i++) {
	                if (secretWord.charAt(i) == letter) {
	                    foundLetters[i] = letter;
	                    letterFound = true;
	                    correctLetters++;
	                }
	            }

	            if (letterFound) {
	                System.out.println("Bien ! La lettre '" + letter + "' est dans le mot.");

	                // Vérifier si le mot est complètement trouvé
	                if (correctLetters == secretWord.length()) {
	                    System.out.println("\n=== FÉLICITATIONS ! ===");
	                    System.out.println("Vous avez trouvé le mot: " + secretWord);
	                    gameOver = true;
	                }
	            } else {
	                System.out.println("Dommage ! La lettre '" + letter + "' n'est pas dans le mot.");
	                incorrectLetters[indexIncorrectLetters] = letter;
	                indexIncorrectLetters++;
	                errors++;

	                // Vérifier si le joueur a perdu
	                if (errors >= 10) {
	                    System.out.println("\n=== GAME OVER ===");
	                    System.out.println("Vous avez atteint 10 erreurs !");
	                    System.out.println("Le mot était: " + secretWord);
	                    gameOver = true;
	                } else {
	                    System.out.println("Il vous reste " + (10 - errors) + " erreurs possibles.");
	                }
	            }
	        }

	        scanr.close();
	        System.out.println("\nMerci d'avoir joué !");

	}

}
