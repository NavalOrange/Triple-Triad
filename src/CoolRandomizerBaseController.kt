
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import java.net.URL
import java.util.*


class CoolRandomizerBaseController : Initializable {
    @FXML lateinit var view : VBox

    @FXML private lateinit var grid : GridPane
    @FXML private lateinit var button : Button

    init {
        val fxmlLoader = FXMLLoader()
        fxmlLoader.setControllerFactory { this }
        fxmlLoader.location = javaClass.getResource("RandomizerBaseView.fxml")
        fxmlLoader.load<VBox>()
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        view
        grid
        button
    }

    @FXML fun onButtonClicked(event: MouseEvent) {
        runRandomizer()
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