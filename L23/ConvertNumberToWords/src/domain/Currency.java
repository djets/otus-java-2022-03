package src.domain;

public abstract class Currency {
    private String name;
        
    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
 
}
