package sprbootjdbc.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveCustomer(Customer c) {
		String sql = "insert into customers(name) values(?)";
		Object[] param = new Object[] { c.getName() };
		jdbcTemplate.update(sql, param);

	}
	
	public Customer findOneCustomer(int id) {
		String sql = "select id, name from customers where id = ?";
		Object[] param = new Object[] { id };
		RowMapper<Customer> cRm = new CustomerRowMapper();
		return jdbcTemplate.queryForObject(sql, cRm, param);
	} 

	public List<Customer> findAllCustomers() {
		String sql = "select * from customers";
		RowMapper<Customer> cRm = new CustomerRowMapper();
		return jdbcTemplate.query(sql, cRm);
	}

}
