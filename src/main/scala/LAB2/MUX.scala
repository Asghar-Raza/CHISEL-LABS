package LAB2
import chisel3._

class MUX_IO extends Bundle{
    val in_A = Input(Bool())
    val in_B = Input(Bool())
    val select = Input(Bool())
    val output = Output(Bool())
}
class MUX extends Module{
    val io = IO(new MUX_IO)
    io.output := io.in_A & io.select | io.in_B & (~io.select)
}
// io.output = Mux(io.select, io.in_A, io.in_B)