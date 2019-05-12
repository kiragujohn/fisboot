
package com.njoroge.fis;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@EntityScan( "com.njoroge.fis.domain" )
@SpringBootApplication
public class StartFisBoot {

    public static void main( String[] args ) {
        SpringApplication.run( StartFisBoot.class, args );
    }
}
