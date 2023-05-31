package state

import javax.swing.JFrame

object StateMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val frame = JFrame()
        frame.title = "State pattern"
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.add(ServerPanel())
        frame.pack()
        frame.isVisible = true
    }
}
