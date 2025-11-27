package com.nadhem.Chansons;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.entities.Chanson;
import com.nadhem.Chansons.repos.ChansonRepository;

@SpringBootTest
class ChansonsApplicationTests {

	@Autowired
	private ChansonRepository chansonRepository;

	@Test
	public void testCreateProduit() {
		Chanson chan = new Chanson("Expresso", 2.48, new Date());
		chansonRepository.save(chan);
	}

	@Test
	public void testFindChanson() {
		chansonRepository.findById(1L)
				.ifPresentOrElse(
						c -> System.out.println("this is the id" + c),
						() -> System.out.println("Chanson with id=1 not found"));
	}

	@Test
	public void testUpdateChanson() {
		chansonRepository.findById(1L)
				.ifPresentOrElse(
						c -> {
							c.setDuree(1.0);
							chansonRepository.save(c);
						},
						() -> System.out.println("Chanson with id=1 not found"));
	}

	@Test
	public void testDeleteChanson() {
		chansonRepository.deleteById(1L);
		;

	}

	@Test
	public void testListerTousChanson() {
		List<Chanson> chans = chansonRepository.findAll();
		for (Chanson c : chans) {
			System.out.println(c);
		}
	}

	@Test
	public void testFindByTitreChanson() {
		List<Chanson> chans = chansonRepository.findByTitreChanson("Expresso");
		for (Chanson c : chans) {
			System.out.println(c);
		}
	}

	@Test
	public void testFindByTitreChansonContains() {
		List<Chanson> chans = chansonRepository.findByTitreChansonContains("Exp");
		for (Chanson c : chans) {
			System.out.println(c);
		}
	}

	@Test
	public void testFindByTitreDuree() {
		List<Chanson> chans = chansonRepository.findByTitreDuree("Exp", 1.0);
		assertNotNull(chans);
		System.out.println("testFindByTitreDuree " + chans.size());
		chans.forEach(System.out::println);
	}

	@Test
	public void testFindByAlbum() {
		Album alb = new Album();
		alb.setIdAlb(1L);
		List<Chanson> chans = chansonRepository.findByAlbum(alb);
		System.out.println("testFindByAlbum " + chans.size());
	}

	@Test
	public void testFindByAlbumIdAlb() {
		List<Chanson> chans = chansonRepository.findByAlbumIdAlb(1L);
		System.out.println("testFindByAlbumIdAlb " + chans.size());
	}
}
