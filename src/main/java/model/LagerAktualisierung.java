package model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LagerAktualisierung {
    private Integer id;
    private Date datum;
    private List<Map.Entry<String, Integer>> listeProdukte;

    public LagerAktualisierung() {
    }

    public LagerAktualisierung(Integer id, Date datum, List<Map.Entry<String, Integer>> listeProdukte) {
        this.id = id;
        this.datum = datum;
        this.listeProdukte = listeProdukte;
    }

    @Override
    public String toString() {
        return "LagerAktualisierung{" +
                "id=" + id +
                ", datum=" + datum +
                ", listeProdukte=" + listeProdukte +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LagerAktualisierung that = (LagerAktualisierung) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<Map.Entry<String, Integer>> getListeProdukte() {
        return listeProdukte;
    }

    public void setListeProdukte(List<Map.Entry<String, Integer>> listeProdukte) {
        this.listeProdukte = listeProdukte;
    }
}
