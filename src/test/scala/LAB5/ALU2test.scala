package LAB5
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._
import scala.util.Random

import ALUOP._
class ALU2test extends FreeSpec with ChiselScalatestTester{
    "test for 2nd ALU" in{
        test(new ALU2) { c => 
        val array_op = Array(ALU_ADD, ALU_SUB, ALU_AND, ALU_OR, ALU_XOR, ALU_SLL, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B, ALU_XXX)
        for (i <- 0 until 100 ){
            val src_a = Random.nextLong()& 0xFFFFFFFFL
            val src_b = Random.nextLong()& 0xFFFFFFFFL
            val opr = Random.nextInt(11)
            val op = array_op(opr)

            println(src_a)

            val result = op match{
                case ALU_ADD => src_a + src_b
                case ALU_SUB => src_a - src_b
                case ALU_AND => src_a & src_b
                case ALU_OR => src_a | src_b
                case ALU_XOR => src_a ^ src_b
                case ALU_SLL => src_a << (src_b & 0x1F)
                case ALU_SRL => src_a >> (src_b & 0x1F)
                case ALU_SRA => src_a >> (src_b & 0x1F)
                case ALU_COPY_A => src_a
                case ALU_COPY_B => src_b
                case ALU_XXX => 0
            }
            val result1 : BigInt = if (result < 0)
                (BigInt(0xFFFFFFFFL) + result+1) & 0xFFFFFFFFL
            else (result & 0xFFFFFFFFL)

                println(result)

                c.io.in_A.poke(src_a.U)
                c.clock.step(1)
                c.io.in_B.poke(src_b.U)
                c.clock.step(1)
                c.io.alu_Op.poke(op)
                c.clock.step(1)
                c.io.out.expect(result1.U)
            }   
        c.clock.step(200)
        }
    }
}