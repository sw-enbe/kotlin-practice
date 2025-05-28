package org.swenbe.kotlinpractice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/")
class MessageController(
    private val messageService: MessageService
) {

    @GetMapping("/message")
    fun listMessage() = messageService.findMessages()

    @GetMapping("/message/{id}")
    fun getMessage(
        @PathVariable id: String,
    ): ResponseEntity<Message> = messageService.findMessageById(id).toResponseEntity()

    @PostMapping("/message")
    fun post(
        @RequestBody message: Message
    ): ResponseEntity<Message> {
        val savedMessage = messageService.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    private fun Message?.toResponseEntity(): ResponseEntity<Message> =
        // If the message is null (not found), set response code to 404
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}