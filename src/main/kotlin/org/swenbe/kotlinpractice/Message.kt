package org.swenbe.kotlinpractice

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MESSAGES")
data class Message(

    @Id
    val id: String? = null,
    val text: String,
)
