// package LAB5
// import chisel3.util._
// import chisel3._

// class Router_IO [T <: Data](gen:T) extends Bundle{
//     val recieve = Input(gen)
//     val transmit = Output(gen)
// }
// class data_packets[F <: Data](data_field: F) extends Bundle{
//     val address = Input(UInt(10.W))
//     val address1 = Input(data_field)
//     val Out = Output(F)
//     val Out1 = Output(F)
//     val sel = Input(Bool())
// }

// class Router [T <: Data](gen:T) extends Module{
//     val io = IO(new Router_IO(UInt(32.W)),new data_packets(UInt(32.W)){
//         val in = Input(gen)
//         val out = Output(gen)
//     })
//     io.out := (io.in + io.recieve)
//     io.transmit := io.recieve + io.out
    
//     when (io.sel){
//         io.Out := io.address
//         io.Out1 := io.address1
//     }.otherwise{
//         io.Out := io.address1
//         io.Out1 := io.address
//     }
    
// }