package practices.movie.MovieProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

//Tu powinny zostać na ten moment tylko 3 jak nie 1 ;)
// I to do package movie
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"practices.*"})
@ComponentScan(basePackages = "practices.*")
@EnableJpaRepositories("practices.*")
@CrossOrigin(origins = "*")
public class MovieProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProjApplication.class, args);
	}

}
