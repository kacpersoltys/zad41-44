/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.util.Scanner;

import java.io.IOException;

class Main {
  
  public static void main(String[] args) {
    try {
      System.out.println("1.Dodaj nowego studenta");
      System.out.println("2.Wyświetl listę studentów");
      System.out.println("3.Wyszukaj studenta po imieniu");
      System.out.println("0.Wyjście");
      Scanner scanner = new Scanner(System.in);
      int choose = scanner.nextInt();
      Service s = new Service();

      if (choose == 1) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź imię studenta: ");
        String imie = scanner2.nextLine();
        System.out.println("Wprowadź nazwisko studenta: ");
        String nazwisko = scanner2.nextLine();
        System.out.println("Wprowadz wiek: ");
        int wiek = scanner.nextInt();
        System.out.println("Wprowadz datę urodzenia (w formacie dd-mm-yyyy): ");
        String dataUrodzenia = scanner2.nextLine();
        System.out.println("Wprowadz adres: ");
        String adres = scanner2.nextLine();
        s.addStudent(new Student(imie, nazwisko, wiek, dataUrodzenia, adres));
      } else if (choose == 2) {
        var students = s.getStudents();
        for (Student current : students) {
          System.out.println(current.ToString());
        }
      } else if (choose == 3) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadz imię studenta, którego chcesz wyszukac: ");
        String imie = scanner2.nextLine();
        var student = s.findStudentByName(imie);
        if (student != null) {
          System.out.println("Nie znaleziono studenta o takim imieniu.");
        }
      } else {
        System.out.println("Zamykanie :)");
        scanner.close();
        System.exit(0);
      }
    } catch (IOException e) {
        System.out.println("Błąd" + e.getMessage());
    }
  }
}