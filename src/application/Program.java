package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Bill;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Bill bill = new Bill();
		bill.gender = readGender(sc);
		bill.beer = readNonNegative(sc, "cervejas");
		bill.softDrink = readNonNegative(sc, "refrigerantes");
		bill.barbecue = readNonNegative(sc, "espetinhos");

		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.printf("Consumo = R$ %.2f%n", bill.feeding());

		double cover = bill.cover();
		if (cover > 0.0) {
			System.out.printf("Couvert = R$ %.2f%n", cover);
		} else {
			System.out.println("Isento de Couvert");
		}

		System.out.printf("Ingresso = R$ %.2f%n", bill.ticket());
		System.out.println();
		System.out.printf("Valor a pagar = R$ %.2f%n", bill.total());

		sc.close();
	}

	public static char readGender(Scanner sc) {
		System.out.print("Sexo: ");
		char value = Character.toUpperCase(sc.next().charAt(0));
		while (value != 'F' && value != 'M') {
			System.out.print("Erro: sexo inválido! Digite apenas M ou F: ");
			value = Character.toUpperCase(sc.next().charAt(0));
		}

		return value;
	}

	public static int readNonNegative(Scanner sc, String label) {
		System.out.print("Quantidade de " + label + ": ");
		int value = sc.nextInt();

		while (value < 0) {
			System.out.print("Erro: quantidade de " + label + " inválida! Digite um valor maior ou igual a zero: ");
			value = sc.nextInt();
		}

		return value;
	}

}
