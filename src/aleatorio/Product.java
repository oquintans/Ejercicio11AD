/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oracle
 */
public class Product {

    private String cod;
    private String descr;
    private int price;

    public Product() {
    }

    public Product(String cod, String descr, int price) {
        this.cod = cod;
        this.descr = descr;
        this.price = price;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String nf;
        return "Cod: " + cod + "\nDescripción: " + descr + "\nPrice: " + (nf = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(price));
    }

}
