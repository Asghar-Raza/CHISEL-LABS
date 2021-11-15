package LAB6
import chisel3.util._
import chisel3._

class SHIFT_REG (val init : Int = 1) extends Module{
    val io = IO(new Bundle{
        val in = Input(UInt(4.W))
        val out = Output(UInt(4.W))
    })
    val state = RegInit(init.U(4.W))
    val Nextstate = (state << 1) | io.in
    state := Nextstate
    io.out := state
}