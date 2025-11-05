import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Scanner scanr = new Scanner(System.in);

        // Tableau contenant les mots possibles à deviner
        String[] words = {"maison", "ordinateur", "java", "pendu", "clavier", "souris", "ecran"};

        // Choix aléatoire du mot secret
        int indexWord = (int)(Math.random() * words.length);
        String secretWord = words[indexWord];

        // Tableaux pour suivre les lettres trouvées et les lettres incorrectes
        char[] foundLetters = new char[secretWord.length()];
        char[] incorrectLetters = new char[10];

        int errors = 0;                  // Compteur d’erreurs
        int correctLetters = 0;          // Nombre de lettres correctes trouvées
        int indexIncorrectLetters = 0;   // Position d’ajout dans le tableau des lettres incorrectes
        boolean gameOver = false;        // Booléen pour savoir si la partie est terminée

        // Initialisation du mot affiché avec des tirets
        for (int i = 0; i < foundLetters.length; i++) {
            foundLetters[i] = '_';
        }

        System.out.println("=== JEU DU PENDU ===");
        System.out.println("Devinez le mot en proposant des lettres (10 erreurs maximum).");

        // Boucle principale du jeu
        while (!gameOver) {
            // Affiche le mot avec les lettres déjà trouvées
            System.out.print("\nMot à deviner: ");
            for (char c : foundLetters) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Affiche les lettres incorrectes si présentes
            if (indexIncorrectLetters > 0) {
                System.out.print("Lettres incorrectes: ");
                for (int i = 0; i < indexIncorrectLetters; i++) {
                    System.out.print(incorrectLetters[i] + " ");
                }
                System.out.println();
            }

            System.out.println("Erreurs: " + errors + "/10");
            System.out.print("Proposez une lettre: ");

            // Lecture et conversion directe en minuscule
            String input = scanr.nextLine().toLowerCase();

            // Vérifie que l’utilisateur a bien entré une seule lettre
            if (input.length() != 1) {
                System.out.println("Veuillez entrer une seule lettre !");
                continue;
            }

            char letter = input.charAt(0);

            // Vérifie que la saisie est bien une lettre alphabétique
            if (letter < 'a' || letter > 'z') {
                System.out.println("Veuillez entrer une lettre valide !");
                continue;
            }

            // Vérifie si la lettre a déjà été proposée
            boolean letterAlreadyProposed = false;

            for (char c : foundLetters) {
                if (c == letter) {
                    letterAlreadyProposed = true;
                    break;
                }
            }

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

            // Recherche de la lettre dans le mot secret
            boolean letterFound = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter && foundLetters[i] != letter) {
                    foundLetters[i] = letter;
                    letterFound = true;
                    correctLetters++;
                }
            }

            // Si la lettre est trouvée
            if (letterFound) {
                System.out.println("Bien ! La lettre '" + letter + "' est dans le mot.");

                // Vérifie si le mot est complètement trouvé
                if (correctLetters == secretWord.length()) {
                    System.out.println("\n=== FÉLICITATIONS ! ===");
                    System.out.println("Vous avez trouvé le mot: " + secretWord);
                    gameOver = true;
                }

            // Si la lettre n’est pas dans le mot
            } else {
                System.out.println("Dommage ! La lettre '" + letter + "' n'est pas dans le mot.");
                incorrectLetters[indexIncorrectLetters++] = letter;
                errors++;

                // Vérifie la fin du jeu (10 erreurs)
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
