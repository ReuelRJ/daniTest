package arcaDenoe.model;

import java.util.Objects;

public class Movement {
	private String movement;

	public Movement(String movement) {
		super();
		this.movement = movement;
	}

	public Movement() {
		super();
	}

	@Override
	public String toString() {
		return "Movement [movement=" + movement + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(movement);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movement other = (Movement) obj;
		return Objects.equals(movement, other.movement);
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}
	
}
