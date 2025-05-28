package org.swenbe.kotlinpractice

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String> {
}