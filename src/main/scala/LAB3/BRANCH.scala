package LAB3
import chisel3.util._
import chisel3._

class Branch_IO extends Bundle{
    val fun3 = Input(UInt(3.W))
    val in_a = Input(UInt(32.W))
    val in_b = Input(UInt(32.W))
    val branch = Input(Bool())
    val br_taken = Output(Bool())
    val out = Output(UInt(32.W))
}

object BRANCH_OP {
    val BEQ = 0
    val BNE = 1
    val BGE = 2
    val BLT = 3
    val BLTU = 4
    val BGEU = 5
}
import BRANCH_OP._
class BRANCH extends Module{
    val io = IO(new Branch_IO)
    io.out := 0.U
    switch (io.fun3){
        is(BEQ.U){
            when (io.in_a === io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
        is (BNE.U){
            when(io.in_a != io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
        is (BGE.U){
            when(io.in_a >= io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
        is (BLT.U){
            when(io.in_a < io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
        is (BLTU.U){
            when(io.in_a < io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
        is (BGEU.U){
            when(io.in_a >= io.in_b){
                io.out := 1.U
            }.otherwise{
                io.out := 0.U
            }
        }
    }
    when ((io.out === 1.U & io.fun3(2,1)) === (("b010".U) & io.branch === 1.U)){
        io.br_taken := 1.B
    }.otherwise{
        io.br_taken := 0.B
    }
}
