package LAB8
import org.scalatest._
import chiseltest._
import chisel3._

class InstMemtest extends FreeSpec with ChiselScalatestTester{
    " instruction memory test" in {
        test(new InstMem){ c=>
        c.io.addr.poke(1.U)
        c.io.inst.expect(1010567.U)
        c.clock.step(5)
        }
    }
}