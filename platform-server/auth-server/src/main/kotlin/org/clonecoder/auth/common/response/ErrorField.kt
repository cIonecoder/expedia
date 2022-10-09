package org.clonecoder.auth.common.response

import org.apache.commons.lang3.StringUtils
import org.springframework.validation.Errors
import java.util.*
import java.util.stream.Collectors

class ErrorField {
    private var field: String? = null
    private var value: String? = null
    private var reason: String? = null

    companion object {
        fun of(errors: Errors?): List<ErrorField> {
            return if (errors == null) {
                Collections.emptyList()
            } else errors.fieldErrors
                .stream()
                .map { fieldError ->
                    ErrorField().apply {
                        field = fieldError.field
                        value = fieldError.rejectedValue?.let { getOrEmpty(it) }
                        value = fieldError.defaultMessage?.let { getOrEmpty(it) }
                    }
                }
                .collect(Collectors.toList())
        }

        private fun getOrEmpty(target: Any): String {
            return if (Objects.isNull(target)) {
                StringUtils.EMPTY
            } else target.toString()
        }
    }
}