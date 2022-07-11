package arcaDenoe.model;

import java.util.Objects;

public class Habitat {
	private String habitats;

	public Habitat(String habitats) {
		super();
		this.habitats = habitats;
	}

	public Habitat() {
		super();
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

	@Override
	public String toString() {
		return "Habitat [habitats=" + habitats + "]";
	}

	public String getHabitats() {
		return habitats;
	}

	public void setHabitats(String habitats) {
		this.habitats = habitats;
	}
	
}
