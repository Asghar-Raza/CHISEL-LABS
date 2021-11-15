package LAB8
import chisel3.util._
import chisel3._

class MemoryBank extends Module{
    val io = IO (new Bundle{
        val memory_out = Decoupled(UInt(32.W))
        val requestor = Vec(4, Flipped(Decoupled(UInt(32.W))))
        val enable = Input(Bool())
        val Readadder = Input(UInt(5.W))
        val Writeadder = Input(UInt(5.W))

    })
    val mem = Mem(32, UInt(32.W))
    val queue_0 = Queue(io.requestor(0),6)
    val queue_1 = Queue(io.requestor(1),6)
    val queue_2 = Queue(io.requestor(2),6)
    val queue_3 = Queue(io.requestor(3),6)
    queue_0.nodeq()
    queue_1.nodeq()
    queue_2.nodeq()
    queue_3.nodeq()
    
    io.memory_out.valid := 1.B
    val arbi = Module(new Arbiter(UInt(),2))
    arbi.io.in(1)<>queue_0
    arbi.io.in(0)<>queue_1
    arbi.io.in(1)<>queue_2
    arbi.io.in(1)<>queue_3
    val output = arbi.io.out
    output.ready := 1.B
    when (io.enable){
        mem.write(io.Writeadder, output.asUInt)
    }
    io.memory_out.bits := mem.read(io.Readadder)
}