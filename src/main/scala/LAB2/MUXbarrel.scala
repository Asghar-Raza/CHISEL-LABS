// package LAB2
// import chisel3._
// import chisel3.util._

// class MUXbarrel extends Module{
//     val io = IO(new Bundle {
//         val in = Vec(4, Input(Bool()))
//         val sel = Vec(2, Input(Bool()))
//         val shft = Input(Bool())
//         val out = Vec (4, Output(Bool()))
//         val sout = Vec (3, Output(Bool()))
//     })
//         val mux = Mux(io.sel(1), Mux(io.sel(0), io.in(3), io.in(2)), Mux(io.sel(0), io.in(1), io.in(0)))
//         val smux1 = Mux(io.shft, io.in(0), 0.U)
//         io.sout(0):= smux1
//         // io.in(3) := io.sout(1)
        
//         val mux1 = Mux(io.sel(1),Mux(io.sel(0), io.sout(0), io.in(2)),Mux(io.sel(0),io.in(1),io.in(0)))
//         val smux2 = Mux(io.shft, io.in(1),0.U)
//         io.sout(1) := smux2
//         // io.in(2) := io.sout(2)
        
//         val mux2 = Mux (io.sel(1), Mux(io.sel(0), io.sout(1), io.sout(0)), Mux(io.sel(0),io.in(1),io.in(0)))
//         val smux3 = Mux(io.shft, io.in(2), 0.U)
//         io.sout(2) := smux3
//         //io.in(1) := io.sout(3)
        
//         val mux3 = Mux (io.sel(1), Mux(io.sel(0), io.sout(2), io.sout(1)), Mux(io.sel(0),io.sout(0), io.in(0)))

    
//     io.out(0) := mux
//     io.out(1) := mux1
//     io.out(2) := mux2
//     io.out(3) := mux3
// }