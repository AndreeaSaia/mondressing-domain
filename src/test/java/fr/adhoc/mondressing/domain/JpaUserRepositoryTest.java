package fr.adhoc.mondressing.domain;


	
	

	import static org.junit.Assert.*;

	import java.util.Date;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	import fr.adhoc.mondressing.domain.entities.User;
import fr.adhoc.mondressing.domain.repositories.UserRepository;
import fr.adhoc.mondressing.domain.repositories.impl.JpaUserRepository;

	@RunWith(SpringJUnit4ClassRunner.class)
	//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
	@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
	public class JpaUserRepositoryTest {

		@Autowired
		UserRepository userRepository;
		
		@Test
		public void test() {
			User user = new User();
			user.setNom("Saia");
			user.setPrenom("Andreea");
			user.setEmail("andreea.saia@adhoc-international.com");
			
			userRepository.save(user);
			//System.out.println(x.getIdentifier() + " " + x.getEmail());
			User userFromBD = userRepository.findByEmail(user.getEmail());
			assertNotNull(userFromBD);
			assertEquals(userFromBD.getNom(), user.getNom());
			assertEquals(userFromBD.getPrenom(), user.getPrenom());
		}

	}

