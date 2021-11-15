package LAB2
import  chisel3._
import chisel3.util._

class LM_interface extends Bundle{
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    val out = Output(UInt(32.W))
}
class MUX5to1 extends Module{
    val io = IO(new LM_interface)
    val con = Cat (io.s2,io.s1,io.s0)
    io.out:=0.U
    when (con === "b000".U){
        io.out := 0.U
    }.elsewhen (con === "b001".U){
        io.out := 8.U
    }.elsewhen (con === "b010".U){
        io.out := 16.U
    }.elsewhen(con === "b011".U){
        io.out := 24.U
    }.elsewhen(con === "b100".U){
        io.out := 32.U
    }

    
}