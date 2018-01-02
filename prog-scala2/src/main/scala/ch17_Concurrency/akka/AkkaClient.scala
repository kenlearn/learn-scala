package progscala2.concurrency.akka

import akka.actor.{ActorRef, ActorSystem, Props}
import java.lang.{NumberFormatException => NFE}

object AkkaClient {
    import Messages._

    private var system: Option[ActorSystem] = None

    def main(args: Array[String]) = {
        processArgs(args)
        val sys = ActorSystem("AkkaClient")
        system = Some(sys)

        val server = ServerActor.make(sys)
        val numOfWorkers = 
            sys.settings.config.getInt("server.number-workers")

        server ! Start(numOfWorkers)

        processInput(server)
    }

    private def processArgs(args: Seq[String]): Unit =
        args match {
            case Nil =>
            case ("-h" | "--help") +: tail => exit(help, 0)
            case head +: tail => exit(s"Unknown input ${head}!\n" + help, 1)
        }

    private def processInput(server: ActorRef): Unit = {
        val blankRE = """^\s*(?:#.*)?\s*$""".r
        val badCrashRE = """^\s*[Cc][Rr][Aa][Ss][Hh]\s*$""".r
        val crashRE = """^\s*[Cc][Rr][Aa][Ss][Hh]\s+(\d+)\s*$""".r
        val dumpRE = """^\s*[Dd][Uu][Mm][Pp](\s+\d+)?\s*$""".r
        val charNumberRE = """^\s*(\w)\s+(\d+)\s*$""".r
        val charNumberStringRE = """^\s*(\w)\s+(\d+)\s+(.*)$""".r

        def prompt() = print(">> ")
        def missingActorNumber() =
            println("Crash command requires an actor number.")
        def invalidInput(s: String) =
            println(s"Unrecognized command: ${s}")
        def invalidCommand(c: String): Unit =
            println(s"Expected 'c', 'r', 'u', 'd'. Got ${c}")
        def invalidNumber(s: String): Unit =
            println(s"Expected number. Got ${s}")
        def expectedString(): Unit =
            println("Expected a string after the command and number")
        def unexpectedString(c: String, n: Int): Unit =
            println(s"Extra arguments after command and number '$c $n'")
        def finished(): Nothing = exit("Goodbye!", 0)


    }
}
