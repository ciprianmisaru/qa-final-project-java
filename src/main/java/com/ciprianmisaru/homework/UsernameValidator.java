package com.ciprianmisaru.homework;

import java.util.Scanner;

/**
 * Tema Sesiunea 6 - Validator de Username.
 * Cere repetat un username (bucla do-while) pana cand respecta toate regulile:
 *   1. lungime intre 6 si 12 caractere (inclusiv);
 *   2. fara spatii (verificat caracter cu caracter, cu bucla for);
 *   3. cel putin o cifra (verificat tot cu bucla for).
 */
public class UsernameValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean esteValid;

        // Bucla do-while: ruleaza cel putin o data si repeta cat timp username-ul NU e valid.
        do {
            esteValid = true; // presupunem ca e valid pana gasim o problema

            System.out.print("Introdu un username: ");
            username = scanner.nextLine();

            // --- Regula 1: lungimea trebuie sa fie intre 6 si 12 caractere ---
            if (username.length() < 6 || username.length() > 12) {
                System.out.println("Eroare: Username-ul trebuie sa aiba intre 6 si 12 caractere.");
                esteValid = false;
                continue; // re-cere input; nu mai verificam celelalte reguli pentru inputul curent
            }

            // --- Regula 2: nu trebuie sa contina spatii (iteram prin caractere cu for) ---
            boolean areSpatii = false;
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) == ' ') {
                    areSpatii = true;
                    break; // am gasit un spatiu, nu mai are rost sa continuam cautarea
                }
            }
            if (areSpatii) {
                System.out.println("Eroare: Username-ul nu poate contine spatii.");
                esteValid = false;
                continue; // re-cere input fara a mai verifica regula urmatoare
            }

            // --- Regula 3: trebuie sa contina cel putin o cifra (iteram prin caractere cu for) ---
            boolean areCifra = false;
            for (int i = 0; i < username.length(); i++) {
                if (Character.isDigit(username.charAt(i))) {
                    areCifra = true;
                    break; // o singura cifra e suficienta
                }
            }
            if (!areCifra) {
                System.out.println("Eroare: Username-ul trebuie sa contina cel putin o cifra.");
                esteValid = false;
            }

        } while (!esteValid);

        // Daca am iesit din bucla, username-ul respecta toate regulile.
        System.out.println("Username acceptat: " + username);

        scanner.close();
    }
}
