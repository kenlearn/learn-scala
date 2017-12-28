package traits.ui

class Button(val label: String)
  extends Widget with Clickable {
  override protected def updateUI(): Unit = { /* update button UI */}
}
