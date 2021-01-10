package guru.springframework.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryITTest {

	@Autowired
	UnitOfMeasureRepository unitofMeasureRepository;

	@Before
	public void setUp() {

	}

	@Test
	@DirtiesContext
	void testFindByUomdescription() {
		Optional<UnitOfMeasure> uomOptional = unitofMeasureRepository.findByUomdescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getUomdescription());
	}

	@Test
	void testFindByUomdescriptionCup() {
		Optional<UnitOfMeasure> uomOptional = unitofMeasureRepository.findByUomdescription("Cup");
		assertEquals("Cup", uomOptional.get().getUomdescription());
	}
}
