package exmp
import org.scalatest._
import chiseltest._
import chisel3._

class HALFADDERtest extends FreeSpec with ChiselScalatestTester {

    "HALF-ADDER Gate Test" in {
        test (new HALFADDER()){ c=> 
        c.io.a.poke(1.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.otp.expect(0.U)
        c.io.otp1.expect(0.U)
        c.clock.step(10)

        }
    }
}