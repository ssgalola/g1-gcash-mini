package ph.apper.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProductApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }
}
