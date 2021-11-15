package LAB2
import org.scalatest._
import chiseltest._
import chisel3._

class MUXtest extends FreeSpec with ChiselScalatestTester {
    "mux 2 to 1" in{
        test (new MUX()){c =>
        c.io.in_A.poke(1.B)
        c.clock.step(1)
        c.io.in_B.poke(0.B)
        c.clock.step(1)
        c.io.select.poke(1.B)
        c.io.output.expect(1.B)
        c.clock.step(100)
        }
    }
}