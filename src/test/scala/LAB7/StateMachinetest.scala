package LAB7
import org.scalatest._
import chiseltest._
import chisel3._

class StateMachinetest extends FreeSpec with ChiselScalatestTester{
    " state machine test" in {
        test (new My_Queue){ c =>
        c.io.f1.poke(1.B)
        c.io.f2.poke(1.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(1.B)
        }
    }
}