package me.dgahn.exception

import me.dgahn.user.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@RestController
@ControllerAdvice // 예외 상황이 발생했을 때, 이 Handler를 사용하도록 설정한다.
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class) // 어떤 에러가 발생했을 때 핸들러가 작동할지 작성한다.
    fun handleAllExceptions(ex: Exception, request: WebRequest) =
        ResponseEntity(
            ExceptionResponse(LocalDateTime.now(), ex.message ?: "", request.getDescription(false)),
            HttpStatus.INTERNAL_SERVER_ERROR
        )

    @ExceptionHandler(UserNotFoundException::class) // 어떤 에러가 발생했을 때 핸들러가 작동할지 작성한다.
    fun handleUserNotFoundExceptions(ex: Exception, request: WebRequest) =
        ResponseEntity(
            ExceptionResponse(LocalDateTime.now(), ex.message ?: "", request.getDescription(false)),
            HttpStatus.NOT_FOUND
        )

}
