package LAB6
import chisel3.util._
import chisel3._

class XorCounter (val max : Int = 5) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt((log2Ceil(max).W)))
    })

    val reg = RegInit(0.U(log2Ceil(max).W))
    val mux = Mux((1.B ^ reg(log2Ceil(max)-1)),reg+1.U,0.U)
    reg := mux
    io.out := reg
    
}