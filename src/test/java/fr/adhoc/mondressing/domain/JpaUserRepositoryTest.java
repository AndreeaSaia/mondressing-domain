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
		UserRepository jpaUserRepository;
		
		@Test
		public void test() {
			User user = new User();
			user.setNom("Saia");
			user.setPrenom("Andreea");
			user.setEmail("andreea.saia@adhoc-international.com");
			
			jpaUserRepository.save(user);
			//System.out.println(x.getIdentifier() + " " + x.getEmail());
			User userFromBD = jpaUserRepository.findByEmail(user.getEmail());
			assertNotNull(userFromBD);
			System.out.println(userFromBD.getNom());
			System.out.println(userFromBD.getPrenom());
		}

	}

