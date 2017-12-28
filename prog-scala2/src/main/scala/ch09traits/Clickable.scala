package traits.ui

trait Clickable {
  def click(): Unit = updateUI()

  protected def updateUI(): Unit
}
