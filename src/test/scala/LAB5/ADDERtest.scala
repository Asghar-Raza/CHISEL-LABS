package LAB5
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._

class ADDERtest extends FreeSpec with ChiselScalatestTester{
    " Adder test" in {
        test(new ADDER(32)){ c=> 
        c.io.in0.poke(6.U)
        c.io.in1.poke(6.U)
        c.io.sum.expect(12.U)
        c.clock.step(200)
        }
        
    }
}