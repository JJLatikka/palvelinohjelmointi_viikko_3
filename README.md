# palvelinohjelmointi_viikko_3

Halusin ehdottomasti kokeilla myös tätä jo pelkästään sen takia, että jo kauan minun on ollut tarkoitus aloittaa tuon mysql-tietokannan käyttö,
mutta huomasin varsin pian, että kurssimateriaalin esimerkki 'StudentListJDBC' ei sellaisenaan toimi. Syy on ilmeisesti se, että siinä on käytetty java8:aa, eikä java 17:aa, niinkuin nykyään käytetään. - Mutta sisäinen 'Teppo Testaajani' ei antanut minulle rauhaa, ja sain selville, että parilla pienellä muutoksella tuon kurssimateriaaliesimerkin mukainen toteutus toimii java17:ssakin.

Ensinnäkin:

Tiedostoon 'application.properties' pitää lisätä seuraava suluissa oleva rivi: (spring.sql.init.mode=always). Ilman tuota riviä java17 ei ilmeisesti
osaa tuota tietokannan taulujen luomiseen tarkoitettua schema.sql-tiedostoa hyödyntää.

Toiseksi:

Käytettäessä JdbcTemplate-rajapinnan tarjoamaa metodia 'queryForObject', metodin parametrit on syötettävä järjestyksessä: ( String ) sql-kysely,
RowMapper-olio ja lopuksi sql-kyselyyn liitettävät ( Object[ ] ) parametrit, eli vaikka näin:

```
public Customer findOneCustomer(int id) {
	String sql = "select id, name from customers where id = ?";
	Object[] param = new Object[] { id };
	RowMapper<Customer> cRm = new CustomerRowMapper();
	return jdbcTemplate.queryForObject(sql, cRm, param);
}
```

'StudentListJDBC'-esimerkissä se meni näin:

```
public Student findOne(int id) {
	String sql = "select student_id, first_name, last_name from student where student_id = ?";
	Object[] parameters = new Object[] { id };
	RowMapper<Student> mapper = new StudentRowMapper();

	Student student = jdbcTemplate.queryForObject(sql, parameters, mapper);
	return student;
}
```
