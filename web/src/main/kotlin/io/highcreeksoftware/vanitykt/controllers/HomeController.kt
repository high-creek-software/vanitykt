package io.highcreeksoftware.vanitykt.controllers

import io.javalin.http.Context

class HomeController {

    fun getHome(ctx: Context) {
        ctx.result("Vanity KT")
    }
}