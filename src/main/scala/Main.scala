import cats._
import cats.effect._
import cats.implicits._
import cats.effect.implicits
import cats.effect.unsafe.implicits.global

import scala.io.StdIn

object MyApp{
  object Console {
    def putStrLn(s: String): IO[Unit] = IO(println(s))
    def readLine(text: String): IO[String] = IO(StdIn.readLine(text))
  }

  def main(args: Array[String]):Unit = {
    import Console._ 

    val program1 = readLine("Enter your name:").flatMap { name =>
      putStrLn(s"Hello $name") 
    }
 
    val program2 = for {
      name <- readLine("Enter you name: ")
      _ <- putStrLn(s"Hello $name")
    } yield ()

    val program3 = putStrLn("hello") *> putStrLn("world")

    // IO monad test
    program1.unsafeRunSync() 
    program2.unsafeRunSync()
    program3.unsafeRunSync()
  }
}
