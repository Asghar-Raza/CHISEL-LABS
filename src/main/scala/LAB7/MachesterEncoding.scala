package LAB7
import chisel3.util._
import chisel3._

class Manchester_Encoding extends Module{
    val io = IO(new Bundle{
        val in = Input(UInt(1.W))
        val start = Input(Bool())
        val out = Output(UInt(8.W))
        // val flag = Output(UInt(1.W))
    })
    val s0 :: s1 :: Nil = Enum(2)
    val state = RegInit(s0)
    val reg = RegInit(0.U(8.W))
    io.out := 0.U
    switch (state){
        is (s0){
            when (!io.start){
                state := s1
            }.otherwise{
                io.out := reg
            }
        }
        is(s1){
            when(!io.start){
                state := s0
            }.otherwise{
                reg := (reg << 1) | io.in
                io.out := reg
            }
        }
    }
}