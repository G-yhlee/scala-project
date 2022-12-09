import cats.effect.{IO, IOApp}

object HelloWorld extends IOApp.Simple {
  val run = IO.println("Hello, World!")

}

// object Main extends App {
//   // val test = Left[Int, Int](2)
//   // println(test.fold[Int](a => a * a, a => a))

//   println(HelloWorld.run)

// }
