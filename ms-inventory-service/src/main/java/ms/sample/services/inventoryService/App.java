package ms.sample.services.inventoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import ms.sample.services.inventoryService.configuration.InventoryWebConfiguration;

@Configuration
@Import({ InventoryWebConfiguration.class, EventuateDriverConfiguration.class })
@EnableAutoConfiguration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
