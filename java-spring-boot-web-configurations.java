// import necessary packages:

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;

//@Configuration: annotation marks this class as a source of bean definitions. It's used to configure Spring Components, in this CORS.
@Configuration
  public class WebConfigurations{
    @Bean
    // Configuring Cross-Origin Resource Sharing (CORS) in a Spring Boot application using a **CorsFilter** bean
    public CorsFilter corsFilter(){

      //Setting up cors:
      CorsConfiguration corsConfiguration=new CorsConfiguration();
      //Allows cookies and credentials (like authorization, headers) in cross-origin request.
      corsConfiguration.setAllowCredentials(true);
      //For production specific:
      //corsConfiguration.setAllowedOrigins(Arrays.asList("http://domainname")
      
      //for development specific:
      corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
      
      corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
      corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));


      //Applies this CORS configuration to all URL paths in your application.
      UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", corsConfiguration);
      return new CorsFilter(source);
    }
}
