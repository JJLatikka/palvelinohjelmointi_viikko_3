package sprbootjdbc.domain;

public class Customer {

	private long id;
	private String name;

	public Customer() {
	}

	public Customer(String n) {
		this.name = n;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	@Override
	public String toString() {
		return String.format("Customer{name=%s}", name);
	}

}
