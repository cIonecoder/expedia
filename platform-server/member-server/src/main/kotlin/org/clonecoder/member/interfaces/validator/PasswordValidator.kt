package org.clonecoder.member.interfaces.validator

import org.springframework.stereotype.Component
import java.text.MessageFormat
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
class PasswordValidator: ConstraintValidator<Password, String> {

    companion object {
        private const val MIN_SIZE = 12
        private const val MAX_SIZE = 20
        private const val pattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@!%*#?&])[A-Za-z0-9$@!%*#?&]{$MIN_SIZE,$MAX_SIZE}$"
    }

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        val isValidPassword = value.matches(Regex(pattern))

        if (!isValidPassword) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate(
                MessageFormat.format("{0}자 이상의 {1}자 이하의 숫자, 영문자, 특수문자를 포함하여야 합니다.", MIN_SIZE, MAX_SIZE)
            ).addConstraintViolation()
        }

        return isValidPassword
    }
}