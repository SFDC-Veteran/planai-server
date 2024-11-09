package com.veteran.planai.domain.auth.service

import com.veteran.planai.domain.auth.exception.EmailExistsException
import com.veteran.planai.domain.auth.exception.EmailNotVerifiedException
import com.veteran.planai.domain.auth.exception.UnableToSendEmailException
import com.veteran.planai.domain.user.domain.repository.jpa.UserJpaRepository
import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.time.Duration
import java.util.*

@Component
class EmailUtil(
    private val emailSender: JavaMailSender,
    private val redisTemplate: StringRedisTemplate,
    private val userJpaRepository: UserJpaRepository
) {
    val AUTH_CODE_PREFIX: String = "AuthCode_"
    private val authCodeExpirationMillis: Long = 300000L
    fun sendEmail(to: String?, subject: String?, body: String?) {
        try {
            val message: MimeMessage = emailSender.createMimeMessage()
            message.setRecipients(MimeMessage.RecipientType.TO, to)
            message.subject = subject
            message.setText(body, "UTF-8", "html")
            emailSender.send(message)
        } catch (e: MessagingException) {
            throw UnableToSendEmailException.EXCEPTION
        }
    }

    fun checkEmailDuplicate(email: String): Boolean {
        if (userJpaRepository.existsById(email)) throw EmailExistsException.EXCEPTION
        return true
    }

    fun verifyCode(email: String, code: String): String {
        checkEmailDuplicate(email)
        val deCodedEmail:String = URLDecoder.decode(email, StandardCharsets.UTF_8)
        println("----------------------------$deCodedEmail")
        val authCode = redisTemplate.opsForValue().get(AUTH_CODE_PREFIX + deCodedEmail)
        println("----------------------------$authCode")
        if(StringUtils.hasText(authCode) && authCode == code) return "인증 완료"
        else throw EmailNotVerifiedException.EXCEPTION
    }

    fun sendVerificationCodeToEmail(email: String) {
        URLDecoder.decode(email, StandardCharsets.UTF_8)
        checkEmailDuplicate(email)
        val authCode: String = createAuthCode()
        sendEmail(email, "[Planai] 회원가입을 위한 이메일 인증", createVerificationEmailHtmlBody(authCode))
        redisTemplate.opsForValue().set(
            AUTH_CODE_PREFIX + email,
            authCode,
            Duration.ofMillis(authCodeExpirationMillis)
        )
    }

    private fun createVerificationEmailHtmlBody(authCode: String): String {
        var body = ""
        body += "<h1>" + "안녕하세요." + "</h1>"
        body += "<h1>" + "Planai 입니다." + "</h1>"
        body += "<h3>" + "회원가입을 위한 요청하신 인증 번호입니다." + "</h3><br>"
        body += "<h2>" + "아래 코드를 회원가입 창으로 돌아가 입력해주세요." + "</h2>"
        body += "<div align='center' style='border:1px solid black; font-family:verdana;'>"
        body += "<h2>" + "회원가입 인증 코드입니다." + "</h2>"
        body += "<h1 style='color:blue'>$authCode</h1>"
        body += "</div><br>"
        body += "<h3>" + "감사합니다." + "</h3>"
        return body
    }

    private fun createAuthCode(): String {
        val lenth = 6
        try {
            val random: Random = SecureRandom.getInstanceStrong()
            val builder = StringBuilder()
            for (i in 0 until lenth) {
                builder.append(random.nextInt(10))
            }
            return builder.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw UnableToSendEmailException.EXCEPTION
        }
    }

}