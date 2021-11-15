package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class Countertest extends FreeSpec with ChiselScalatestTester {

    "Counter test" in {
        test (new Counter(4.U)){ c=>
        c.clock.step(100)
        } 
        
    }
}
