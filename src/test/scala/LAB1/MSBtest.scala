package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class MSBtest extends FreeSpec with ChiselScalatestTester {

    "MSB" in {
        test (new MSB(8.U)) { c =>
        c.clock.step(100)
        }

    }
}