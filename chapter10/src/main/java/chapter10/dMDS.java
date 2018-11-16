package chapter10;
public class dMDS{
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3309/sampledb");
	ds.setUsername("root");
	ds.setPassword("rootroot");
	Connection actualCon = ds.getConnection();
}