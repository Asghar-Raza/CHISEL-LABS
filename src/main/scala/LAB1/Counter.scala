package LAB1
import chisel3._
class Counter ( counterBits : UInt ) extends Module {
    val io = IO ( new Bundle {
        val result = Output ( Bool () )
    })
    val max = (1.S << counterBits ) - 1.S
    val count = RegInit (0.S (4. W ) )
    when ( count === max ) {
        count := 0.S
    }.otherwise{
        count := count + 1.S
    }
    io.result := count(3)
}