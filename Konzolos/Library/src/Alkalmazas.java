import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alkalmazas {
    private ArrayList<Kolcsonzok> kolcsonzokLista = new ArrayList<>();
    private ArrayList<Kolcsonzes> kolcsonzesLista = new ArrayList<>();

    public void importKolcsonzok(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                if (data.length >= 3) {
                    int id = Integer.parseInt(data[0]);
                    String szulIdo = data[2];

                    Kolcsonzok kolcsonzo = new Kolcsonzok(id, szulIdo, szulIdo);
                    kolcsonzokLista.add(kolcsonzo);
                } else {
                    System.out.println("Hiányzó adatok: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: nincs fájl!");
            e.printStackTrace();
        }
    }

    public void importKolcsonzesek(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                int id = Integer.parseInt(data[0]);
                int kolcsonzoId = Integer.parseInt(data[1]);
                String iro = data[2];
                String mufaj = data[3];
                String cim = data[4];

                Kolcsonzes kolcsonzes = new Kolcsonzes(id, kolcsonzoId, iro, mufaj, cim);
                kolcsonzesLista.add(kolcsonzes);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: Nincs fájl!");
            e.printStackTrace();
        }
    }

    public void run() {
        importKolcsonzok("Kolcsonzok.csv");
        importKolcsonzesek("Kolcsonzesek.csv");

        System.out.println("Kölcsönzések importálása sikeres!");
        System.out.println("Kölcsönzők száma: " + kolcsonzokLista.size());
        System.out.println("Kölcsönzések száma: " + kolcsonzesLista.size());
    }

    public static void main(String[] args) {
        Alkalmazas app = new Alkalmazas();
        app.run();
    }
}
