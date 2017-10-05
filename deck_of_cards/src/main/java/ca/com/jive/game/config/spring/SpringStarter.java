package ca.com.jive.game.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.com.jive.game.controller.SpringControllerScan;
import ca.com.jive.game.service.game.SpringServiceScan;

/**
 * Configs of SpringBoot Starter and packages to scan
 * @author Guilherme
 */
@SpringBootApplication(scanBasePackageClasses = {
	SpringControllerScan.class,
	SpringServiceScan.class
})
public class SpringStarter {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringStarter.class, args);
    }
}
