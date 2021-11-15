package LAB8
import chisel3.util._
import chisel3._

class MaskMEM extends Module{
    val io = IO(new Bundle{
        val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val mask = Input(UInt(2.W))
        val dataIN = Input(UInt(32.W))
        val dataOUT = Output(UInt(32.W))
    })
    val mem = SyncReadMem(1024, UInt(32.W))
    when(io.mask === 0.U){
        mem.write (io.addr, io.dataIN(7,0))
    }.elsewhen(io.mask === 1.U){
        mem.write(io.addr, io.dataIN(15,8))
    }.otherwise{
        mem.write(io.addr, io.dataIN)
    }
    io.dataOUT := mem.read(io.addr, io.enable)
}
