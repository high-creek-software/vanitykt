package io.highcreeksoftware.vanitykt.controllers

import io.highcreeksoftware.vanitykt.core.link.LinkManager
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse

class LinkController(val linkManager: LinkManager) {

    fun getLink(ctx: Context) {
        val slug = ctx.pathParam("slug")
        println("Found slug: $slug")

        val link = linkManager.findLink(slug) ?: throw NotFoundResponse()
        println("Found link: $link")
        ctx.redirect(link.target, 302)
    }
}