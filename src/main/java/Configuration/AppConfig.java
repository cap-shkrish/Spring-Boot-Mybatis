package Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ClassLoaderPackage.Car;
import ClassLoaderPackage.Vehicle;


@Configuration
public class AppConfig {

  @Bean
  @Profile(PROFILE_LOCAL)
  public Vehicle dataServiceLocal() {
      return new Vehicle();
  }

  @Bean
  @Profile(PROFILE_REMOTE)
  public Vehicle dataServiceRemote() {
	  return new Car();
  }

  public static final String PROFILE_LOCAL = "local";
  public static final String PROFILE_REMOTE = "remote";
}