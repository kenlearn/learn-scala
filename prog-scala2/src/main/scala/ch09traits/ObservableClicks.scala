package traits.ui

import traits.observer._

trait ObservableClicks
  extends Clickable
  with Subject[Clickable] {
  abstract override def click(): Unit = {
    super.click()
    notifyObservers(this)
  }
}
