
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color

/**
 * Created by Justin on 2018-03-01.
 */

class LameRandomizerBaseController {
    var view : VBox
    private var grid : GridPane
    private var button : Button

    init {
        view = VBox()
        grid = GridPane()
        button = Button("Randomize")

        view.children.addAll(grid, button)
        for (x in 0..2) {
            for (y in 0..2) {
                grid.add(VBox(Label()), x, y)
            }
        }

        button.onMouseClicked = EventHandler {
            runRandomizer()
        }
    }

    private fun runRandomizer() {
        grid.children.forEach {
            val child = it as VBox
            val element = getRandomElement()
            (child.children.single() as Label).textFill = Color.PURPLE
        }
    }

    private fun getRandomElement() : Element {
        val randomNumber = Math.random()*100
        return when {
            randomNumber < 72.0 -> Element.NonElemental
            randomNumber < 75.5 -> Element.Fire
            randomNumber < 79.0 -> Element.Ice
            randomNumber < 82.5 -> Element.Lightning
            randomNumber < 86.0 -> Element.Earth
            randomNumber < 89.5 -> Element.Poison
            randomNumber < 93.0 -> Element.Water
            randomNumber < 96.5 -> Element.Holy
            else -> Element.Wind
        }
    }
}

enum class Element(fillColour: Color, fontColour : Color, private val textValue : String? = null) {
    NonElemental(Color.FLORALWHITE, Color.BLACK, "Non-Elemental"),
    Fire(Color.WHITE, Color.BLACK),
    Ice(Color.DARKBLUE, Color.WHITE),
    Lightning(Color.YELLOW, Color.BLACK),
    Earth(Color.BROWN, Color.BLACK),
    Poison(Color.OLIVE, Color.BLACK),
    Water(Color.BLUE, Color.BLACK),
    Holy(Color.LIGHTYELLOW, Color.BLACK),
    Wind(Color.LIGHTBLUE, Color.BLACK);

    fun text() = textValue ?: name
}