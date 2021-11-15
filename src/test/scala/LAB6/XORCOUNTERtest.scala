package LAB6
import chiseltest._
import org.scalatest._
import chisel3._

class XORCOUNTERtest extends FreeSpec with ChiselScalatestTester{
    " counter using XOR" in{
        test(new XorCounter){ c =>
        
        c.clock.step(100)

        }
    }
}