package com.nadhem.Chansons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.entities.Chanson;

@SpringBootApplication
public class ChansonsApplication implements org.springframework.boot.CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ChansonsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Chanson.class,Album.class);
	}
	

}
