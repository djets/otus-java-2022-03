package src.domain;

public class CurrencyRubles extends Currency {
    private String shortName;

    public CurrencyRubles(String name, String shortName) {
        super(name);
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
  
}
