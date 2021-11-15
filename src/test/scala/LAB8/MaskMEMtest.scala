package LAB8
import chiseltest._
import org.scalatest._
import chisel3._

class MaskMEMtest extends FreeSpec with ChiselScalatestTester{
    " masking memory test" in {
        test(new MaskMEM){ c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(15.U)
        c.io.mask.poke(1.U)
        c.io.dataIN.poke(555.U)
        c.clock.step(5)
        }
    }
}