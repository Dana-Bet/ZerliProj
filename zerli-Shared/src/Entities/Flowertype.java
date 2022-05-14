package Entities;

public enum Flowertype {

	pot,branch,flower;
	
	public static Flowertype toFlowertype(String type) {

		switch (type) {
		case "pot": {
			return pot;
		}

		case "branch": {
			return branch;
		}

		case "flower": {
			return flower;
		}

		default: {
			return null;
		}

		}
	}
}
