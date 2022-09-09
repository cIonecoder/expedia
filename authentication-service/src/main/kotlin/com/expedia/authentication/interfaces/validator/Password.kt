package com.expedia.authentication.interfaces.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention
@Constraint(validatedBy = [PasswordValidator::class])
annotation class Password(
    val message: String = "",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

