package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class upDowntest extends FreeSpec with ChiselScalatestTester{
    "up down counter" in {
        test(new upDown(3)){ c =>
        c.clock.step(100)


        }
    }
}
