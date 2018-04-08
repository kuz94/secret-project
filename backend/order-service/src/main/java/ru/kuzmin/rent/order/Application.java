/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.rent.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import ru.kuzmin.rent.order.dao.DaoConfig;
import ru.kuzmin.rent.order.services.ServiceConfig;

/**
 *
 * @author Антон
 */

@SpringBootApplication(scanBasePackageClasses = {DaoConfig.class, ServiceConfig.class})
@ImportResource("classpath:META-INF/spring-beans.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
