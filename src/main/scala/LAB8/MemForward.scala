package LAB8
import chisel3.util._
import chisel3._

class MemForward extends Module{
    val io = IO(new Bundle{
        val wr_ena = Input(Bool())
        val rdAddr = Input(UInt(8.W))
        val wrAddr = Input(UInt(8.W))
        val mask = Input(Vec(2,Bool()))
        val dataIN = Input(Vec(2,UInt(16.W)))
        val dataOUT = Output(Vec(2,UInt(16.W)))
    })
    val mem = SyncReadMem(1024, Vec(2,UInt(16.W)))
    val wrDataReg = RegNext(io.dataIN)
    val doForwardReg = RegNext(io.wrAddr === io.rdAddr && io.wr_ena)
    val memData = mem.read(io.rdAddr)
    when(io.wr_ena){
        mem.write(io.wrAddr, io.dataIN, io.mask)
    }
    io.dataOUT := Mux(doForwardReg, wrDataReg, memData)
}