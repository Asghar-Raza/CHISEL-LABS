package LAB4
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._

import scala.util.Random
import ALU_OP._

class ALU1test extends FreeSpec with ChiselScalatestTester{
    "test ALU 1" in {
        test (new ALU) { c =>
        var array_op = Array (ADD, SUB, AND, OR, XOR, SLT, SLL, SLTU, SRL,SRA)
        for (i <- 0 until 100 ){
            val src_a = Random.nextLong()& 0xFFFFFFFFL
            val src_b = Random.nextLong()& 0xFFFFFFFFL
            val opr = Random.nextInt(9)
            val alu_op = array_op(opr)

            println(src_a)
            println(src_b)

            val result = alu_op match{
                case ADD => src_a + src_b
                case SUB => src_a - src_b
                case AND => src_a & src_b
                case OR => src_a | src_b
                case XOR => src_a ^ src_b
                case SLT => if(src_a < src_b)
                                1
                            else
                                0
                case SLL => src_a << (src_b & 0x1F)
                case SLTU => if(src_a < src_b)
                                1
                            else
                                0
                case SRL => src_a >> (src_b & 0x1F)
                case SRA => src_a >> (src_b & 0x1F)
                // case COPY_A => src_a
                // case COPY_B => src_b
                // case ZERO => 0
             }
            val result1 : BigInt = if (result < 0)
                (BigInt(0xFFFFFFFFL) + result+1) & 0xFFFFFFFFL
                else (result & 0xFFFFFFFFL)
                
            println(result)
                c.io.in_a.poke(src_a.U)
                c.io.in_b.poke(src_b.U)
                c.io.sel.poke(alu_op)
                c.clock.step(1)
                c.io.out.expect(result1.U)
            }
            c.clock.step(200)
        }
    }
}