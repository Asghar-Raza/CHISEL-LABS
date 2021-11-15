package LAB6
import chisel3.util._
import chisel3._

class ShhiftReg (val length : Int = 3, max : Int = 5) extends Module{
    val io = IO (new Bundle{
        val out = Vec(length, Output(Bool()))
        val load_in = Vec (length, Input(Bool()))
        val in = Input(Bool())
        val load = Input(Bool())
    })
    val mux_1 = Mux(io.load, io.load_in(0),io.in)
    val mux_2 = Mux(io.load, io.load_in(1), mux_1)
    val mux_3 = Mux(io.load, io.load_in(2), mux_2)

    val reg_1 = RegInit(0.U(log2Ceil(max).W))
    val reg_2 = RegInit(0.U(log2Ceil(max).W))
    val reg_3 = RegInit(0.U(log2Ceil(max).W))

    reg_1 := mux_1
    reg_2 := mux_2
    reg_3 := mux_3

    io.out(0) := reg_1
    io.out(1) := reg_2
    io.out(2) := reg_3
}