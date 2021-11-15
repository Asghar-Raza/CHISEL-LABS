package LAB3
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._
import scala.util.Random
import BRANCH_OP._

class BRANCHtest extends FreeSpec with ChiselScalatestTester{
    " branch test" in {
        test (new BRANCH){ c=>
        var array_fun3 = Array(BEQ, BNE, BGE, BLT, BLTU, BGEU)
        for (i <- 0 until 100){
            val inpt_a =7 //Random.nextLong() & 0xFFFFFFFFL
            val inpt_b = 8//Random.nextLong() & 0xFFFFFFFFL
            val op_r = 2//Random.nextInt(5)
            val op = array_fun3(op_r)

            println(inpt_a)
            println(inpt_b)
            // val result = op match {
            //     case BEQ => if (inpt_a === inpt_b)
            //                     1
            //                 else
            //                     0
            //     case BNE => if(inpt_a != inpt_b)
            //                     1
            //                 else
            //                     0
            //     case BGE => if(inpt_a >= inpt_b)
            //                     1
            //                 else
            //                     0
            //     case BLT => if(inpt_a < inpt_b)
            //                     1
            //                 else
            //                     0
            //     case BLTU => if(inpt_a < inpt_b)
            //                     1
            //                 else
            //                     0
            //     case BGEU => if(inpt_a >= inpt_b)
            //                     1
            //                 else
            //                     0
            // }
            
            // println(result)
                c.io.in_a.poke(inpt_a.U)
                c.io.in_b.poke(inpt_b.U)
                c.io.fun3.poke(op.U)
                c.clock.step(1)
                c.io.out.expect(1.B)
        }
        c.clock.step(200)
        }
    }
}
