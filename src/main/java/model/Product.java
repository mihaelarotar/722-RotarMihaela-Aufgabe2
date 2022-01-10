package model;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private int preis;
    private String sku;
    private int anzahl;

    public Product() {
    }

    public Product(Integer id, String name, int preis, String sku, int anzahl) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.sku = sku;
        this.anzahl = anzahl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preis=" + preis +
                ", sku='" + sku + '\'' +
                ", anzahl=" + anzahl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
