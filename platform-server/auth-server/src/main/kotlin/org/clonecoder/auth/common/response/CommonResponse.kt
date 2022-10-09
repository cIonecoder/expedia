package org.clonecoder.auth.common.response


class CommonResponse<T> {

    private var result: Result? = null
    private var data: T? = null
    private var message: String? = null
    private var errorCode: String? = null
    private var errorFields: List<ErrorField>? = emptyList()

    enum class Result {
        SUCCESS, FAIL
    }

    companion object {
        fun <T> success(data: T): CommonResponse<T> {
            return success(data, "")
        }

        fun <T> success(data: T, message: String): CommonResponse<T> {
            return CommonResponse<T>().apply {
                result = Result.SUCCESS
                this.data = data
                this.message = message
            }
        }

        fun fail(errorCode: ErrorCode): CommonResponse<*> {
            return CommonResponse<String>().apply {
                result = Result.FAIL
                this.message = errorCode.message
                this.errorCode = errorCode.code
            }
        }

        fun fail(errorCode: ErrorCode, errorFields: List<ErrorField>): CommonResponse<*> {
            return CommonResponse<String>().apply {
                result = Result.FAIL
                this.message = errorCode.message
                this.errorCode = errorCode.code
                this.errorFields = errorFields
            }
        }

        fun fail(message: String): CommonResponse<*> {
            return CommonResponse<String>().apply {
                result = Result.FAIL
                this.message = message
                this.errorCode = ErrorCode.BAD_REQUEST.code
            }
        }
    }
}