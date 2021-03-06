package com.kreait.slack.api.contract.jackson.group.conversations

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.kreait.slack.api.contract.jackson.util.JacksonDataClass

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ok",
        visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = SuccessfulConversationCloseResponse::class, name = "true"),
        JsonSubTypes.Type(value = ErrorConversationCloseResponse::class, name = "false")
)

@JacksonDataClass
sealed class ConversationCloseResponse constructor(@JsonProperty("ok") open val ok: Boolean)

/**
 * Success-response of this request.
 *
 * @property ok will be true
 * @property alreadyClosed true if the conversation was already closed
 */
data class SuccessfulConversationCloseResponse(
        override val ok: Boolean,
        @JsonProperty("no_op") val noOp: Boolean?,
        @JsonProperty("already_closed") val alreadyClosed: Boolean?
) : ConversationCloseResponse(ok) {
    companion object
}

/**
 * Failure-response of this request
 *
 * @property ok will be false
 * @property error contains the error description
 */
data class ErrorConversationCloseResponse constructor(
        override val ok: Boolean,
        @JsonProperty("error") val error: String
) : ConversationCloseResponse(ok) {
    companion object
}

/**
 * Closes a direct message or multi-person direct message.
 *
 * @property channel the channel-id you want to close
 */
data class ConversationCloseRequest(@JsonProperty("channel") val channel: String) {
    companion object
}
