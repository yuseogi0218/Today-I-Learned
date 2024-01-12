package rewards.internal.restaurant;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import common.money.Percentage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the JDBC restaurant repository with a test data source to verify data access and relational-to-object mapping
 * behavior works as expected.
 */
public class JdbcRestaurantRepositoryTests {

	private JdbcRestaurantRepository repository;

	@BeforeEach
	public void setUp() throws Exception {
		// simulate the Spring bean initialization lifecycle:

		// first, construct the bean
		repository = new JdbcRestaurantRepository();

		// then, inject its dependencies
		repository.setDataSource(createTestDataSource());

		// lastly, initialize the bean
		repository.populateRestaurantCache();
	}

	@AfterEach
	public void tearDown() {
		// simulate the Spring bean destruction lifecycle:

		// destroy the bean
		repository.clearRestaurantCache();
	}

	@Test
	public void findRestaurantByMerchantNumber() {
		Restaurant restaurant = repository.findByMerchantNumber("1234567890");
		assertNotNull(restaurant, "the restaurant should never be null");
		assertEquals("1234567890", restaurant.getNumber(), "the merchant number is wrong");
		assertEquals("AppleBees", restaurant.getName(), "the name is wrong");
		assertEquals(Percentage.valueOf("8%"), restaurant.getBenefitPercentage(), "the benefitPercentage is wrong");
	}

	@Test
	public void testFindRestaurantByBogusMerchantNumber() {
		assertThrows(EmptyResultDataAccessException.class, ()-> {
			repository.findByMerchantNumber("bogus");
		});
	}
	
	@Test
	public void restaurantCacheClearedAfterDestroy() throws Exception {
		// force early tear down
		tearDown();

		assertThrows(EmptyResultDataAccessException.class, ()-> {
			repository.findByMerchantNumber("1234567890");
		});
	}

	private DataSource createTestDataSource() {
		return new EmbeddedDatabaseBuilder()
			.setName("rewards")
			.addScript("/rewards/testdb/schema.sql")
			.addScript("/rewards/testdb/data.sql")
			.build();
	}
}
