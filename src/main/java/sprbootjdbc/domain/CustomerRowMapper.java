package sprbootjdbc.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int row) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getLong("id"));
		c.setName(rs.getString("name"));
		return c;
	}
	
}
