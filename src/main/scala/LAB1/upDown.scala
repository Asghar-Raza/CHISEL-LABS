package LAB1

import chisel3._
import chisel3.util._
import java.io.File

class upDown(n:Int) extends Module {
    val io = IO (new Bundle{
        val data_in = Input(UInt(n.W))
        val reload = Input(Bool())
        val out = Output(Bool())
    })
    val count = RegInit(0.U(n.W))
    val max = RegInit(6.U(n.W))
    // Your code
    var flag = RegInit (1.B)
    when (count === max){
        count := count - 1.U
        count:= 0.U
        when (count === 0.U){
            flag = 1.B
            
        }.otherwise {
            flag = 0.B
        }
    }.otherwise {
        count := count + 1.U
        when(count === max){
            count:= max
            flag = 0.B
        }.otherwise{
            flag = 1.B
        }
    }
    io.out := count(2.U)
}

