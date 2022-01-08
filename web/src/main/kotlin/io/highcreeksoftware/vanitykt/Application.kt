package io.highcreeksoftware.vanitykt

import io.highcreeksoftware.vanitykt.controllers.HomeController
import io.highcreeksoftware.vanitykt.controllers.LinkController
import io.highcreeksoftware.vanitykt.core.link.LinkManager
import io.highcreeksoftware.vanitykt.core.link.LinkManagerImpl
import io.highcreeksoftware.vanitykt.core.link.LinkRepo
import io.highcreeksoftware.vanitykt.core.link.LinkRepoFileImpl
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import java.io.File

class Application {

    val javalin = Javalin.create {
        it.enableDevLogging()
    }

    val linkRepo: LinkRepo = LinkRepoFileImpl(File("links.json"))
    val linkManager: LinkManager = LinkManagerImpl(linkRepo)

    val homeController = HomeController()
    val linkController = LinkController(linkManager)

    init {
        javalin.routes {
            get(homeController::getHome)
            // mydomain.com/l/my-meeting
            path("l") {
                path("{slug}") {
                    get(linkController::getLink)
                }
            }
        }
    }

    fun start() {
        javalin.start(3000)
    }
}