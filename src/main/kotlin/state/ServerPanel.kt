package state

import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.JScrollPane
import javax.swing.JTextArea
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.OutputStream
import java.io.PrintStream

class ServerPanel : JPanel() {
    private var server: Server? = null
    private var messageCounter = 0

    init {
        initComponents()

        val defaultPrinter = System.out
        val interceptor = TextAreaPrinter(defaultPrinter)
        System.setOut(interceptor)

        server = Server()
    }

    private inner class TextAreaPrinter(out: OutputStream) : PrintStream(out, true) {
        override fun print(line: String?) {
            println(line)
        }

        override fun println(line: String?) {
            val newLine = "$line\n"
            super.print(newLine)
            jTextArea1.append(newLine)
            jTextArea1.caretPosition = jTextArea1.document.length
        }
    }

    private fun initComponents() {
        jLabel1 = JLabel()
        jPanel1 = JPanel()
        jLabel5 = JLabel()
        jScrollPane1 = JScrollPane()
        jTextArea1 = JTextArea()
        btnSendMessage = JButton()
        btnStart = JButton()

        border = javax.swing.BorderFactory.createEtchedBorder()

        jLabel1.icon = javax.swing.ImageIcon(javaClass.getResource("server.png")) // NOI18N

        jPanel1.border = javax.swing.BorderFactory.createEtchedBorder()
        jPanel1.alignmentY = 0.0f
        jPanel1.layout = javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS)
        jPanel1.add(jLabel5)

        jTextArea1.columns = 20
        jTextArea1.rows = 5
        jScrollPane1.setViewportView(jTextArea1)

        jPanel1.add(jScrollPane1)

        btnSendMessage.text = "sendMessage"
        btnSendMessage.addActionListener { sendMessageEvent(it) }

        btnStart.text = "Start"
        btnStart.addActionListener { startAction(it) }

        val layout = javax.swing.GroupLayout(this)
        this.layout = layout
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE.toInt())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE.toInt()
                            )
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1))
                        .addComponent(btnSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            Short.MAX_VALUE.toInt()
                        ))
                    .addContainerGap())
        )
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE.toInt())
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSendMessage)
                    .addContainerGap())
        )
    }

    private fun sendMessageEvent(evt: ActionEvent) {
        server?.handleMessage("Send Message + " + ++messageCounter)
    }

    private fun startAction(evt: ActionEvent) {
        val state = server?.getState()
        if (state is StopServerState) {
            btnStart.text = "Stop"
            server?.setState(StartingServerState(server!!))
        } else {
            if (state is StartingServerState) {
                server?.setState(StopServerState(server!!))
            } else {
                btnStart.text = "Start"
                server?.setState(StopServerState(server!!))
            }
        }
    }

    private lateinit var jLabel1: JLabel
    private lateinit var jPanel1: JPanel
    private lateinit var jLabel5: JLabel
    private lateinit var jScrollPane1: JScrollPane
    private lateinit var jTextArea1: JTextArea
    private lateinit var btnSendMessage: JButton
    private lateinit var btnStart: JButton

    companion object {
        private const val serialVersionUID = 1L
    }
}
