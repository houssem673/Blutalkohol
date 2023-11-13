package propra.woche3;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Component
public class AlkoholForm {
    @NotEmpty(message = "Gewicht muss angegeben werden")
    @NotNull private String geschlecht ;
    @Positive(message = "Gewicht muss positive sein")
    @NotNull private Double gewicht ;
    @Min(value =0 , message = "Menge muss positive sein")
    @Max(value =100 , message = "Menge muss maximal 100 % sein")
    @NotNull(message = "muss nich null sein") private Double bier;
    @Min(value =0 , message = "Menge muss positive sein")
    @Max(value =100 , message = "Menge muss maximal 100 % sein")
    @NotNull private Double wein;
    @Min(value =0 , message = "Menge muss positive sein")
    @Max(value =100 , message = "Menge muss maximal 100 % sein")
    @NotNull private Double korn;
    @Min(value =0 , message = "Menge muss positive sein")
    @Max(value =100 , message = "Menge muss maximal 100 % sein")
    @NotNull private Double vodka;
    @Min(value =0 , message = "Menge muss positive sein")
    @Max(value =100 , message = "Menge muss maximal 100 % sein")
    @NotNull private Double whiskey;

    public String getGeschlecht() {
        return geschlecht;
    }
    public Double getGewicht() {
        return gewicht;
    }
    public Double getBier() {
        return bier;
    }
    public Double getWein() {
        return wein;
    }
    public Double getKorn() {
        return korn;
    }
    public Double getVodka() {
        return vodka;
    }
    public Double getWhiskey() {
        return whiskey;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public void setBier(Double bier) {
        this.bier = bier;
    }

    public void setWein(Double wein) {
        this.wein = wein;
    }

    public void setKorn(Double korn) {
        this.korn = korn;
    }

    public void setVodka(Double vodka) {
        this.vodka = vodka;
    }

    public void setWhiskey(Double whiskey) {
        this.whiskey = whiskey;
    }
}
