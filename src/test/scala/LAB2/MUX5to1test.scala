package LAB2
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class MUX5to1test extends FreeSpec with ChiselScalatestTester{
    " Mux 5 to 1 test" in {
        test (new MUX5to1()){ c =>
        c.io.s0.poke(0.B)
        //c.clock.step(1)
        c.io.s1.poke(1.B)
        //c.clock.step(1)
        c.io.s2.poke(0.B)
        c.clock.step(1)
       // c.io.out.expect(16.U)

        }
    }
}