package LAB3
import org.scalatest._
import chiseltest._
import chisel3._

class Encoder4to2test extends FreeSpec with ChiselScalatestTester {
    "Encoder 4 to 2 test" in {
        test (new Encoder4to2) { c =>
        c.io.in.poke("b0100".U)
        c.clock.step(1)
        c.io.out.expect("b10".U)
        c.clock.step(100)
        }
    }
}