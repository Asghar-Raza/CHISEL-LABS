package LAB7
import org.scalatest._
import chiseltest._
import chisel3._

class ManchesterEncodingtest extends FreeSpec with ChiselScalatestTester{
    " Machester encoder wave test " in {
        test(new Manchester_Encoding){ c=>
        c.io.in.poke(1.U)
        c.io.start .poke(1.B)
        c.clock.step(1)
        c.io.in.poke(0.U)
        c.io.start.poke(1.B)
        c.clock.step(1)
        }
    }
}