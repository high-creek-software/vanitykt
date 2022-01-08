package io.highcreeksoftware.vanitykt.core.link

import java.util.*

interface LinkManager {
    fun findLink(slug: String): Link?
    fun saveLink(newLink: NewLink): Link
    fun deleteLink(id: UUID)
    fun updateLink(link: Link)
}

class LinkManagerImpl(val repo: LinkRepo): LinkManager {
    override fun findLink(slug: String): Link? {
        return repo.findLink(slug)
    }

    override fun saveLink(newLink: NewLink): Link {
        TODO("Not yet implemented")
    }

    override fun deleteLink(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun updateLink(link: Link) {
        TODO("Not yet implemented")
    }
}