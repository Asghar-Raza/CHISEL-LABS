package LAB5
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._

import scala.util.Random
import ALU_OP._

class BUG_ALUtest extends FreeSpec with ChiselScalatestTester{
    "test ALU BUG" in {
        test (new ALU) { c =>
        var array_op = Array (ALU_ADD, ALU_SUB, ALU_SLT, ALU_SLTU, ALU_SRA, ALU_SRL, ALU_SLL, ALU_AND, ALU_OR, ALU_XOR, ALU_COPY_A, ALU_COPY_B, ALU_XXX)
        for (i <- 0 until 100 ){
            val src_a = Random.nextLong()& 0xFFFFFFFFL
            val src_b = Random.nextLong()& 0xFFFFFFFFL
            val opr = Random.nextInt()
            val aluop = array_op(opr)

            val result = aluop match{
                case ALU_ADD => src_a + src_b
                case ALU_SUB => src_a - src_b
                case ALU_SLT => if(src_a < src_b)
                                1
                            else
                                0
                case ALU_SLTU => if(src_a < src_b)
                                1
                            else
                                0
                case ALU_SRA => src_a >> (src_b & 0x1F)
                case ALU_SRL => src_a >> (src_b & 0x1F)
                case ALU_SLL => src_a << (src_b & 0x1F)
                case ALU_AND => src_a & src_b
                case ALU_OR => src_a | src_b
                case ALU_XOR => src_a ^ src_b
                case ALU_COPY_A => src_a
                case ALU_COPY_B => src_b
                case ALU_XXX => 0
            }
            val result1 : BigInt = if (result < 0)
                (BigInt(0xFFFFFFFFL) + result+1) & 0xFFFFFFFFL
            else (result & 0xFFFFFFFFL)


                c.io.in_A.poke(src_a.U)
                c.clock.step(1)
                c.io.in_B.poke(src_b.U)
                c.clock.step(1)
                c.io.alu_Op.poke(opr.U)
                c.clock.step(1)
                c.io.out.expect(result.U)
                c.clock.step(1)
                c.io.sum.expect(0.U)
        }
        }
    }
}