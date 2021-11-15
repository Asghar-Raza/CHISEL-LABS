package exmp 
import chisel3._

class AND extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(1.W))
        val b =  Input(UInt(1.W))
        val otp = Output(UInt(1.W))
    } )
    io.otp := io.a & io.b
}