import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class TripleTriadRandomizer : Application() {
    override fun start(primaryStage: Stage) {
        val controller = RandomizerBaseController()
        primaryStage.title = "Triple Triad Randomizer"
        primaryStage.scene = Scene(controller.view)
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(TripleTriadRandomizer::class.java, *args)
}