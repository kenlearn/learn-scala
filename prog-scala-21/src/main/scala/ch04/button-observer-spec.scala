package ui

import org.specs._
import org.scalatest.FunSpec

import observer._

object ButtonObserverSpec extends FunSpec {
  describe("A button observer") {
    it("observe button clicks") {
      val observableButton = new ObservableButton("Ok")
      val buttonObserver = new ButtonCountObserver
      observableButton.addObserver(buttonObserver)

      for ( i <- 1 to 3) observableButton.click()
      assert(buttonObserver.count === 3)
    }
  }
}
