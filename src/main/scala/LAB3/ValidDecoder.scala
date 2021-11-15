// package LAB3
// import chisel3.util._
// import chisel3._

// class ValidDecoder_IO extends Bundle{
//     val in = Input(UInt(2.W))
//     val out = Valid (UInt(4.W))
// }
// class ValidDecoder extends Module{
//     val io = IO(new ValidDecoder_IO)
//     switch (io.in){
//         is ("b00".U){
//             io.out := "b0001".U
//         }
//         is ("b01".U){
//             io.out := "b0010".U
//         }
//         is ("b10".U){
//             io.out := "b0100".U
//         }
//         is ("b11".U){
//             io.out := "b1000".U
//         }
//     }
//     val in_a = Flipped(Valid(UInt(4.W)))
//     val in_b = Output(UInt(2.W))
//     io.in_b := Flipped(Valid(UInt(2.W)))

// }