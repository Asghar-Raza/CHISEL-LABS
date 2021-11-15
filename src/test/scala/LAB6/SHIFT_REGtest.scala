package LAB6
import chiseltest._
import org.scalatest._
import chisel3._

class SHIFT_REGtest extends FreeSpec with ChiselScalatestTester{
    "shift register test" in {
        test(new SHIFT_REG(1){ c =>
        c.io.in.poke(3.U)
        c.io.out.expect(3.U)

        })
    }
}