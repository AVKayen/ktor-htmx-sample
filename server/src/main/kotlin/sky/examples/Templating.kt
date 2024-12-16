package sky.examples

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureTemplating() {
    routing {
        get("/") {
            call.respondHtml {
                head {
                    script(src = "https://unpkg.com/htmx.org@2.0.4") {}
                }
                body {
                    post(1)
                    form()
                }

            }
        }

        // helper route for htmx to fetch a singular post
        get("/post") {
            call.respondHtml {
                body {
                    post(call.request.queryParameters["id"]?.toInt())
                }
            }

        }
    }
}
