package LAB6
import chiseltest._
import chisel3._
import org.scalatest._

class COUNTERtest extends FreeSpec with ChiselScalatestTester{
    "counter test" in{
        test(new COUNTER(3, 0){ c =>
        c.io.out.expect(13.U)

        })
    }
}