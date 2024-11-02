package Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class p2 {
    public static void main (String[]args) throws IOException {
            int opt=0,c,can;
            String num;
            FileWriter fw= new FileWriter("out.txt");
            float minn=0;
            List<Produs> listaProdus = new ArrayList<>();
            String[] linie;
            Scanner abc = new Scanner(System.in);
            Scanner s = new Scanner(System.in);
            Scanner sc = new Scanner(System.in);
            Scanner scann = new Scanner(new File("C:\\Users\\Aquiris\\IdeaProjects\\Laboreator3\\src\\Lab3\\peoduse.csv"));
            while(scann.hasNextLine()){
                linie=scann.nextLine().split(",");
                Produs prod=new Produs(linie[0],Float.parseFloat(linie[1]),Integer.parseInt(linie[2]), LocalDate.parse(linie[3]));
                listaProdus.add(prod);
                minn=prod.getPret();
            }

            do{
                System.out.println("1.afișarea tuturor produselor din colecția List");
                System.out.println("2.afișarea produselor expirate ");
                System.out.println("3.vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc. ");
                System.out.println("4.afișarea produselor cu prețul minim");
                System.out.println("5.salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură într-un fișier de ieșire. ");
                System.out.println("Da-ti optiunea");
                opt=sc.nextInt();

                switch(opt){
                    case 1:
                        for(Produs prod:listaProdus){
                            System.out.println(prod.toString());
                        }
                        break;
                        case 2:
                            for(Produs prod:listaProdus){
                                if(prod.getData().isBefore(LocalDate.now())){
                                    System.out.println(prod.toString());
                                }
                            }
                            break;
                    case 3:
                        System.out.println("Da-ti numele produsului dorit:");
                        num=abc.nextLine();
                        System.out.println("Da-ti cantitatea:");
                        can=abc.nextInt();
                        for(Produs prod:listaProdus){
                            if(num.compareTo(prod.getNume())==0)
                                if(prod.getCantitate()>=can) {
                                    listaProdus.remove(prod);
                                    System.out.println("Produs vandut");
                                }
                                else
                                    System.out.println("Cantitate insuficienta");

                        }
                        break;
                    case 4:
                        for(Produs prod:listaProdus){
                            if(prod.getPret()<minn)
                                minn=prod.getPret();
                        }
                        for(Produs prod:listaProdus){
                            if(prod.getPret()==minn)
                                System.out.println(prod.toString());
                        }
                        break;
                        case 5:
                            c=s.nextInt();

                            for(Produs prod:listaProdus){
                                if(prod.getCantitate()<c)
                                    fw.write(prod.toString());

                            }

                            break;

                }
            }while(opt!=0);
            abc.close();
        s.close();
        fw.close();
        sc.close();
        scann.close();
        }
}
