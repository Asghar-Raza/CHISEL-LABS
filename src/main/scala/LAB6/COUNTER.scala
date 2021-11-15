package LAB6
import chisel3.util._
import chisel3._

class COUNTER(val max: Int, val min: Int = 13) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
    })
    val counter = RegInit(min.U(log2Ceil(max).W))
    val count_buffer = Mux((isPow2(max) && (counter == 0.U)).B, counter+1.U, Mux(counter === max.U, min.U, counter + 1.U) )
    counter := count_buffer
    io.out := counter
}