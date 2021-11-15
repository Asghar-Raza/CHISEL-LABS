package LAB2
import chisel3._

class MUX1_IO extends Bundle {
    val in_A = Input(UInt(32.W))
    val in_B = Input(UInt(32.W))
    val select = Input(Bool())
    val out = Output (UInt())
}   
class MUX1 extends Module {
    val io = IO(new MUX1_IO)
    io.out := io.in_A & (io.select).asUInt | io.in_B & (~io.select).asUInt
}