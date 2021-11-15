package LAB6
import chisel3._
import org.scalatest._
import chiseltest._

class UpDownCountertest extends FreeSpec with ChiselScalatestTester{
    " up down counter test" in{
        test(new UpDownCounter){ c=> 
        c.io.up_down.poke(1.B)
        c.clock.step(100)
        }
    }
}