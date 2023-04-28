/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itnetwork.cz.appevidencepojistencu;

/**
 *
 * @author dansk
 */
public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private long telCislo;

    
    public Pojistenec(String jmeno, String prijmeni, int vek, long telCislo){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }
    
    public String getJmeno(){
        return jmeno;
    }
    public String getPrijmeni(){
        return prijmeni;
    }
    public int getVek(){
        return vek;
    }
    public long getTelCislo(){
        return telCislo;
    }
}
