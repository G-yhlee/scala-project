import cats._
import cats.effect._
import cats.implicits._
import cats.effect.implicits
import cats.effect.unsafe.implicits.global

import scala.io.StdIn

object MyApp extends IOApp {
  object Console {
    def putStrLn(s: String): IO[Unit] = IO(println(s))
    def readLine(text: String): IO[String] = IO(StdIn.readLine(text))
  }

  override def run(args: List[String]): IO[ExitCode] = {
    import Console._
    for {
      s <- readLine("enter somthing:") 
      t <- readLine("enter another thing:")
      _ <- putStrLn(s ++ t)
    } yield ExitCode.Success
  }
}
