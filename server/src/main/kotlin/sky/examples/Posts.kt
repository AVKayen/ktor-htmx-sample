package sky.examples

import kotlinx.html.*

data class Post(val title: String, val author: String, val body: String)

val posts = arrayOf(
    Post("Whoa", "Sky", "whdhahdwhh"),
    Post("Whoa3", "Sky", "whdhahdwhh"),
    Post("Whoa2", "Sky", "dwdwd"),
)

fun BODY.post(index: Int?) {
    // returns HTML element with a rendered post from above array, with index as provided
    if (index != null && index < posts.size) {
        div {
            id = "post-view"
            h1 {
                +posts[index].title
            }
            h3 {
                +posts[index].author
            }
            p {
                +posts[index].body
            }
        }
    } else {
        h1 {
            +"Post not found"
        }
    }
}

fun BODY.form() {

    // input with ID parameter
    input(type = InputType.number) {
        name = "id"
    }

    button {
        // gets HTML from route /post on click
        attributes["hx-trigger"] = "click"
        attributes["hx-get"] = "/post"


        // swap innerHtml of the #post-view. BODY.post div in this case
        attributes["hx-target"] = "#post-view"
        attributes["hx-swap"] = "innerHtml"


        // attaches "id" of above input
        attributes["hx-include"] = "[name='id']"
        +"Find"
    }
}