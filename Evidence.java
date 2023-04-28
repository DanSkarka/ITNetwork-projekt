/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itnetwork.cz.appevidencepojistencu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author dansk
 */
public class Evidence {
    private Scanner sc = new Scanner (System.in, "Windows-1250");
    private LinkedList<Pojistenec> pojistenci = new LinkedList<>();
    private Pojistenec pojistenec;
    
    public void program(){
        String prikaz = "";
        
        while(!prikaz.equals("4")){
            vytiskniMenu();
                                    
            prikaz = sc.nextLine().trim();
            
            switch(prikaz){
                case "1":
                    novyPojistenec();
                    break;
                case "2":
                    System.out.println();                    
                    seznamPojistencu();
                    break;
                case "3":
                    System.out.println();
                    if (pojistenci.size() != 0){
                        najdiPojistence();                        
                    }
                    else {
                        System.out.println("\n Seznam pojištěnců je prázdný, prosím vytvořte nový záznam.\n");
                    }
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Program ukončen.");
                    break;
            }
        }
    }
    
    public void vytiskniMenu(){
        System.out.println("--------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("--------------------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec\n");        
    }    
    
    public void pocetPojistencu(){
        System.out.printf("Počet záznamů: %d\n\n", pojistenci.size());
    }    
    
    public void novyPojistenec(){        
        System.out.println();
        System.out.println("Zadejte jméno pojištěného:");        
        String vlozJmeno = sc.nextLine().trim();
        
        System.out.println("Zadejte příjmení:");
        String vlozPrijmeni = sc.nextLine().trim();
        
        long vlozTelCislo = 0;
        int vlozVek = 0;
        boolean jeSpravne = false;
        while(!jeSpravne){
            try {
                System.out.println("Zadejte telefonní číslo:");
                vlozTelCislo = Long.parseLong(sc.nextLine().trim()); 
                jeSpravne = true;                    
            } catch(Exception e){
                System.out.println("Chyba při zadávání údajů.");                
            }            
        }         
        boolean jeOk = false;
        while(!jeOk){            
            try {
                System.out.println("Zadejte věk: ");
                vlozVek = Integer.parseInt(sc.nextLine().trim()); 
                jeOk = true;                    
            } catch(Exception e){
                System.out.println("Chyba při zadávání údajů.");                
            }
        }     
        
        Pojistenec pojistenec = new Pojistenec(vlozJmeno, vlozPrijmeni, vlozVek, vlozTelCislo);
        pojistenci.add(pojistenec);
        this.pojistenec = pojistenec;
        
        System.out.println("Data byla uložena. Pokračujte libovolnou klávesou...");
        sc.nextLine();
    }
    
    public void seznamPojistencu(){
        pocetPojistencu();
        
        for (int i = 0; i < pojistenci.size(); i++) {
            System.out.printf("%-10s    %-15s   %-5d    %-15d\n", pojistenci.get(i).getJmeno(), pojistenci.get(i).getPrijmeni(), pojistenci.get(i).getVek(), pojistenci.get(i).getTelCislo());
        }
        System.out.println("Pokračujte libovolnou klávesou...");  
        sc.nextLine();
    }
    
    public void najdiPojistence(){
        boolean jeSpravne = false;
        while(!jeSpravne){
            try {
                System.out.println("Zadejte jméno pojištěného:");
                String jmeno = sc.nextLine().trim();
                
                System.out.println("Zadejte příjmení pojištěného");
                String prijmeni = sc.nextLine().trim();
                
                for (int i = 0; i < pojistenci.size(); i++) {
                    if (pojistenci.get(i).getJmeno().equals(jmeno) && pojistenci.get(i).getPrijmeni().equals(prijmeni)){
                        System.out.printf("\n%-10s  %-15s  %-5d  %-15d\n", pojistenci.get(i).getJmeno(), pojistenci.get(i).getPrijmeni(), pojistenci.get(i).getVek(), pojistenci.get(i).getTelCislo());
                        jeSpravne = true;
                    }           
                }
                if (!jeSpravne){
                    System.out.println("Pojištěnec nebyl nalezen. Zkuste to znovu.");
                }         
                    
            } catch(Exception e){
                System.out.println("Chyba při zadávání údajů.");
            }
        }
        System.out.println("\nPokračujte libovolnou klávesou...");
        sc.nextLine();
    }
}
