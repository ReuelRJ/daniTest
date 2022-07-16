package arcaDeNoe.model;

import java.util.Objects;

public class Habitat {
    private String habitats;

    private void getHabitats() {
        this.habitats = habitats;
    }

    private String setHabitats(String habitats) {
        return this.habitats;
    }

    @Override
    public String toString() {
        return "Habitat [habitats=" + habitats + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitats);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Habitat other = (Habitat) obj;
        return Objects.equals(habitats, other.habitats);
    }

    //--Constructs--

    public Habitat() {
        super();
    }

    public Habitat(String habitats) {
        super();
        this.habitats = habitats;
    }
}