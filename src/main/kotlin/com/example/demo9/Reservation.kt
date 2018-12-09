package com.example.demo9

import org.seasar.doma.*


@Entity(immutable = true)
data class Reservation(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(sequence = "aaaa_id_seq")
        val id: Int? = null,
        val bbb: Json
)