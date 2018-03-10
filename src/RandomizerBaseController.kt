
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import java.net.URL
import java.util.*
import javafx.scene.layout.BackgroundSize




class RandomizerBaseController : Initializable {
    @FXML lateinit var view : VBox

    val pathToAssets = javaClass.classLoader.getResource(".")

    @FXML private lateinit var box1 : VBox
    @FXML private lateinit var box2 : VBox
    @FXML private lateinit var box3 : VBox
    @FXML private lateinit var box4 : VBox
    @FXML private lateinit var box5 : VBox
    @FXML private lateinit var box6 : VBox
    @FXML private lateinit var box7 : VBox
    @FXML private lateinit var box8 : VBox
    @FXML private lateinit var box9 : VBox

    private lateinit var boxes : List<VBox>

    init {
        val fxmlLoader = FXMLLoader()
        fxmlLoader.setControllerFactory { this }
        fxmlLoader.location = javaClass.getResource("RandomizerBaseView.fxml")
        fxmlLoader.load<VBox>()
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        boxes = listOf(box1, box2, box3, box4, box5, box6, box7, box8, box9)
        runRandomizer()
    }

    @FXML fun onButtonClicked(event: MouseEvent) {
        runRandomizer()
    }

    private fun runRandomizer() {
        boxes.forEach {
            val element = getRandomElement()
//            it.style = "-fx-background-color: ${element.fillColour};"
            it.background = element.background
            val label = it.children.single() as Label
            label.text = element.text()
            label.textFill = element.fontColour
        }
    }

    private fun getRandomElement() : Element {
        val randomNumber = Math.random()*100
        return when {
            randomNumber < 72.0 -> Element.None
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

enum class Element(val fillColour: String, val fontColour : Color, private val textValue : String? = null) {
    None("#FFFFFF", Color.BLACK, "Non-Elemental"),
    Fire("#FF0000", Color.BLACK),
    Ice("#b4cffa", Color.BLACK),
    Lightning("#f0fb3e", Color.BLACK),
    Earth("#613318", Color.WHITE),
    Poison("#551A8B", Color.WHITE),
    Water("#40a4df", Color.BLACK),
    Holy("#FFE4E1", Color.BLACK),
    Wind("#6ABF51", Color.BLACK);

    private val image = Image(Element::class.java.getResource( "assets/$name.png" ).toString())
    val background : Background

    init {
        val backgroundSize = BackgroundSize(100.0, 100.0, true, true, true, false)
        val backgroundImage = BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)
        val backgroundColor = BackgroundFill(Paint.valueOf(fillColour), null, null)
        background = Background(listOf(backgroundColor), listOf(backgroundImage))
    }

    fun text() = textValue ?: name
}