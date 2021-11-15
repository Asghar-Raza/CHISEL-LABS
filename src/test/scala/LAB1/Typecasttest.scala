package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class Typecasttest extends FreeSpec with ChiselScalatestTester {
    "Type cast test" in {
        test (new Typecast(3, 7)) { c =>
        c.clock.step(100)
        } 
        
    }
}