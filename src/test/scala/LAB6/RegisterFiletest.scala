package LAB6
import chiseltest._
import org.scalatest._
import chisel3._

class RegisterFiletest extends FreeSpec with ChiselScalatestTester{
    "Register file test" in {
        test(new RegFile{ c=>
        c.io.raddr1.poke(5.U)
        c.io.raddr2.poke(5.U)
        c.io.rdata1.expect(5.U)
        c.io.rdata2.expect(5.U)
        c.io.wen.poke(1.B)
        c.io.wdata.poke(3.U)
        c.io.waddr.expect(3.U)
        })
    }
}