package LAB5
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._

class EX3test extends FreeSpec with ChiselScalatestTester{
    " output using vectors" in {
        test(new EX3(2, UInt(32.W))(_+_)){ c =>
        c.io.in(0).poke(5.U)
        c.io.in(1).poke(5.U)
        // c.clock.step(1)
        // c.io.n.poke(2.U)
        c.io.output(0).expect(10.U)
        c.io.output(1).expect(10.U)
        c.clock.step(200)

        }
    }
}