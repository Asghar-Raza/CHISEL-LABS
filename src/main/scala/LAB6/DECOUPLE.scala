package LAB6
import chisel3.util._
import  chisel3._


class My_Queue extends Module{
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })
    val queue = Queue (io.in)
    val queue_1 = Queue (queue)
    queue.nodeq()
    queue_1.nodeq()
    io.out.bits := 0.U
    io.out.valid := 0.U
    io.out.valid (1.B)
    switch (queue_1.valid && io.out.ready){
        is(1.B){
            io.out.enq(queue_1.deq())
        }
    }
    
}