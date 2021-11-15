package LAB6
import chiseltest._
import org.scalatest._
import chisel3._

class DECOUPLEDtest extends FreeSpec with ChiselScalatestTester{
    "Decouple queue test" in {
        test(new My_Queue){ c=>
        c.io.in.valid.poke(1.B)
        c.io.in.bits.poke(24.U)
        c.io.out.ready.poke(1.B)
        c.clock.step(100)

        }
    }
}