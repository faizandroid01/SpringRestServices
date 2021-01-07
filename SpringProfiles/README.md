**Spring Profiles**

Multiple ways to create spring profiles

1. Through various application-properties / applciation.yml files .

Default - application.properties / application.yml
Dev - application-dev.properties / application-dev.yml
Prod - application-prod.properties / application-prod.yml


2. Through overriding the default application.properties file to use for other profile.
    - Use 'spring.profile.active=dev' to override the general properties with the dev one .
    
3. Through Configuration classes and @Profile annotation-

   eg- 	@Profile("dev")
		@Configuration
		public class DevConfiguration {

		@PostConstruct
		public void postConstruct() {
			System.out.println("FROM DEV ENVIRONMENT.");
		}

		}    
		
keyNote : Use Java Application run and run configurations to set environment variable - spring.profiles.active - dev/prod/qa to test spring profile ,
          but not the spring boot run		
    