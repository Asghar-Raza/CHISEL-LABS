package LAB2
import org.scalatest._
import chiseltest._
import chisel3._

class MUX1test extends FreeSpec with ChiselScalatestTester {
    "MUX test 1" in {
        test (new MUX1()) { c=>
        c.io.in_A.poke(1.U)
        c.clock.step(1)
        c.io.in_B.poke(0.U)
        c.clock.step(1)
        c.io.select.poke(0.B)
        c.io.out.expect(0.U)
        c.clock.step(100)
        }
    }
}