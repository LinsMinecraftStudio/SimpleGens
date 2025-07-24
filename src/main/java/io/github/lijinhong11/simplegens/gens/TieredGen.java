package io.github.lijinhong11.simplegens.gens;

public class TieredGen {
    private final String id;
    private final GenDrop drop;

    public TieredGen(String id, GenDrop drop) {
        this.id = id;
        this.drop = drop;
    }

    public void findDropLocation() {}
}
