package io.highcreeksoftware.vanitykt.core.link

import io.highcreeksoftware.vanitykt.core.serializers.LocalDateTimeSerializer
import io.highcreeksoftware.vanitykt.core.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.*

@Serializable
data class Link(@Serializable(with = UUIDSerializer::class) var id: UUID?,
                var slug: String,
                var target: String,
                @Serializable(with = LocalDateTimeSerializer::class) var created: LocalDateTime
)

@Serializable
data class NewLink(var slug: String, var target: String)

@Serializable
data class NewLinkDTO(var links: List<NewLink>)