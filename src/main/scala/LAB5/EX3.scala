package LAB5
import chisel3.util._
import chisel3._

class EX3 [T <: Data] (n: Int, generic: T) (op: (T,T) => T) extends Module{
    require(n>0)
    val io = IO(new Bundle{
        val in = Input(Vec(n, generic))
        val output = Output(Vec(n, generic))

    })
    io.output(0):= io.in.reduce(op)
    io.output(1):= io.in.reduce(op)
}