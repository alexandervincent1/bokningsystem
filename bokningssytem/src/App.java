import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in); 

        
        int[] platser = new int[20];
        for (int i = 0; i < platser.length; i++) {
            platser[i] = 0;
        }

        // en loop för huvudmenyn
        while (true) {
            // Skriver ut menyalternativ
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Visa tillgängliga platser");
            System.out.println("2. Boka plats");
            System.out.println("3. Visa vinst");
            System.out.println("4. Avsluta");
            System.out.print("Ange ditt val: ");
            // tar emot användarens val
            int val = scanner.nextInt();
            //jämför valet med olika värden (menyval)
            // om siffran är 1
            if (val == 1) {
                //visar ledia plats alltså dem platser som inte har värdet 1
                System.out.println("Lediga platser:");
                for (int i = 0; i < platser.length; i++) {
                    if (platser[i] == 0) {
                        System.out.println("Plats " + (i + 1) + " är ledig");
                    }
                }
            } 
            // annars om siffran är 2
            else if (val == 2) {
                // Implementera bokning av plats
                System.out.print("Ange platsnummer att boka: ");
                int platsnummer = scanner.nextInt();

                // checkar att platsen är giltig
                if (platsnummer >= 1 && platsnummer <= platser.length) {
                    //checkar om platsen är bokad
                    if (platser[platsnummer - 1] != 0) {
                        System.out.println("Platsen är redan bokad av en annan person.");
                    } else {
                        // bokar platsen och sparar födelseåret
                        System.out.print("Ange ditt födelseår för att bekräfta bokningen: ");
                        int fodelsear = scanner.nextInt();
                        platser[platsnummer - 1] = fodelsear;
                        System.out.println("Plats " + platsnummer + " har bokats av dig.");
                    }
                } else {
                    System.out.println("Ogiltigt platsnummer.");
                }
            } 
            // annars om siffran är 3
            else if (val == 3) {
                //variabler för att hjälpa och visa vinst
                int antalBokadePlatser = 0;
                double barnpris = 149.90;
                double vuxenpris = 299.90; 
                int dettaAr = 2024;
                int fodelsear = 0;
                double vinst = 0;
                for (int i = 0; i < platser.length; i++) {
                    if (platser[i] != 0) {
                        fodelsear = platser [i];
                        if ((dettaAr-fodelsear)>=18) {
                            vinst = vinst + vuxenpris;
                        }
                        else{
                            vinst = vinst + barnpris;
                        }
                    }
                }
                System.out.println("Vinsten är: " + vinst + " kr");
            } 
            // annars om siffran är 4
            else if (val == 4) {
                System.out.println("Programmet avslutas.");
                break; // Avsluta while-loopen
            } 
            // annars
            else {
                System.out.println("Ogiltit val. Vänligen välj igen.");
            }
        }
    }
}
