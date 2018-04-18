package learn_map;

public class Data implements NodeKey{
	
	private int value;
	
	Data(int data) {
		this.value = data;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public int compareTo(NodeKey o) {
		if(this.value > o.getValue()) {
			return 1;
		} else if(this.value == o.getValue()) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
}
