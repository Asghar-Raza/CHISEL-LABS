package LAB3
import chisel3.util._
import chisel3._

class ALU_IO extends Bundle{
    val in_a = Input(UInt(32.W))
    val in_b = Input(UInt(32.W))
    val sel = Input(UInt(5.W))
    val out = Output(UInt(32.W))
}
object ALU_OP {
    val ADD = 0.U(8.W)
    val SUB = 1.U(8.W)
    val AND = 2.U(8.W)
    val OR = 3.U(8.W)
    val XOR = 4.U(8.W)
    val SLT = 5.U(8.W)
    val SLL = 6.U(8.W)
    val SLTU = 7.U(8.W)
    val SRL = 8.U(8.W)
    val SRA = 9.U(8.W)
    // val COPY_A = 10.U(8.W)
    // val COPY_B = 11.U(8.W)
    // val ZERO = 15.U(8.W)
}
import ALU_OP._
class ALU extends Module{
    val io = IO(new ALU_IO)
    io.out := 0.U
    switch (io.sel){
        is (ADD){
            io.out := io.in_a + io.in_b
        }
        is (SUB){
            io.out := io.in_a - io.in_b
        }
        is (AND){
            io.out := io.in_a & io.in_b
        }
        is (OR){
            io.out := io.in_a | io.in_b
        }
        is (XOR){
            io.out := io.in_a ^ io.in_b
        }
        is (SLT){
            io.out := io.in_a < io.in_b
        }
        is (SLL){
            io.out := io.in_a << io.in_b(4,0)
        }
        is (SLTU){
            io.out := io.in_a < io.in_b
        }
        is (SRL){
            io.out := io.in_a >> io.in_b(4,0)
        }
        is (SRA){
            io.out := (io.in_a >> io.in_b(4,0))
        }
        // is (COPY_A){
        //     io.out := io.in_a
        // }
        // is (COPY_B){
        //     io.out := io.in_b
        // }
        // is (ZERO){
        //     io.out := 0.U
        // }
    }
    
}