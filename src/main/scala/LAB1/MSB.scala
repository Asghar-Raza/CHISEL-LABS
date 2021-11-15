package LAB1
import chisel3._
class MSB (max: UInt) extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
    })
    val count = RegInit(0.U(4.W))
    when (count === max) {
        count := 0.U
    }.otherwise {
        count := count+1.U
    }
    io.result:= count(3.U)
}