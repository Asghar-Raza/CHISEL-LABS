package LAB8
import org.scalatest._
import chiseltest._
import chisel3._

class MemForwardtest extends FreeSpec with ChiselScalatestTester{
    " memory forwarding test" in{
        test(new MemForward){ c=>
        c.io.wr_ena.poke(1.B)
        c.io.rdAddr.poke(4.U)
        c.io.wrAddr.poke(4.U)
        c.io.dataIN(0).poke(15.U)
        c.io.mask(0).poke(1.B)
        c.clock.step(5)
        c.io.wr_ena.poke(1.B)
        c.io.rdAddr.poke(4.U)
        c.io.wrAddr.poke(4.U)
        c.io.dataIN(1).poke(15.U)
        c.io.mask(1).poke(1.B)
        }
    }
}