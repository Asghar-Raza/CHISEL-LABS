package LAB6
import chiseltest._
import org.scalatest._
import chisel3._

class ShhiftRegtest extends FreeSpec with ChiselScalatestTester{
    " parallel shift register" in {
        test (new ShhiftReg){ c => 
        c.io.load.poke(1.B)
        c.io.load_in(0).poke(0.B)
        c.io.load_in(1).poke(1.B)
        c.io.load_in(2).poke(1.B)
        c.io.in.poke(1.B)
        c.io.out(0).expect(0.B)
        c.io.out(1).expect(1.B)
        c.io.out(2).expect(1.B)
        c.clock.step(100)
        }
    }
}