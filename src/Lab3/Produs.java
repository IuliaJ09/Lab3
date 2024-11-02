package Lab3;

import java.time.LocalDate;
 class Produs {
    private String nume;
    private float pret;
    private int cantitate;
    private LocalDate data;
    public Produs(String nume, float pret, int cantitate, LocalDate data) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data = data;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public float getPret() {
        return pret;
    }
    public void setPret(float pret) {
        this.pret = pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
     public String toString() {
         // Returnează funcția sub forma specificată
         return nume + " " + pret + " " + cantitate + " " + data;
     }

}
