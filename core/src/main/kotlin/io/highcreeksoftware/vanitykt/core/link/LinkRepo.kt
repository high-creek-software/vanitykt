package io.highcreeksoftware.vanitykt.core.link

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

interface LinkRepo {
    fun findLink(slug: String): Link?
    fun saveLink(link: Link): UUID
    fun deleteLink(id: UUID)
    fun updateLink(link: Link)
}

class LinkRepoFileImpl(file: File): LinkRepo {

    val store: MutableMap<String, Link> = mutableMapOf()

    init {
        val data = file.readText(Charsets.UTF_8)
        val newLinkDto = Json.decodeFromString<NewLinkDTO>(data)

        newLinkDto.links.forEach {
            store[it.slug] = Link(UUID.randomUUID(), it.slug, it.target, LocalDateTime.now(ZoneOffset.UTC))
        }
    }

    override fun findLink(slug: String): Link? {
        return store[slug]
    }

    override fun saveLink(link: Link): UUID {
        val id = UUID.randomUUID()
        link.id = id
        store[link.slug] = link
        return id
    }

    override fun deleteLink(id: UUID) {
        var link: Link? = null
        store.forEach { _, u ->
            if(u.id == id) {
                link = u
            }
        }

        link?.let {
            store.remove(it.slug)
        }
    }

    override fun updateLink(link: Link) {
        store[link.slug] = link
    }
}