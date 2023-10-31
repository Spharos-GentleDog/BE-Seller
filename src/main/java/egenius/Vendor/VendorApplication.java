package egenius.Vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorApplication.class, args);
	}

}
