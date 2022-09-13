package sprbootjdbc.domain;

public class Customer {
	
	private long id;
	private String name;
	
	public Customer() {
		this.id = 0;
		this.name = null;
	}
	
    public Customer (String n) {
        this.id = 0;
        this.name = n;
    }
    
    public Customer(long id, String n) {
    	this.id = id;
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

}
