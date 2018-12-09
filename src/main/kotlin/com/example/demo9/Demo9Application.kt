package com.example.demo9

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class Demo9Application {

    @Autowired var reservationDao: ReservationDao? = null

    @Bean
    fun runner(): CommandLineRunner {
        return CommandLineRunner {
            run {
                val r = Reservation(bbb = Json("{\"aaa\": \"bbb\"}"))
                reservationDao?.insert(r)
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Demo9Application>(*args)
}
