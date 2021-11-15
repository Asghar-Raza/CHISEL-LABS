// package LAB5
// import chisel3._
// import chisel3.util._
// import org.scalatest._
// import chiseltest._

// class Routertest extends FreeSpec with ChiselScalatestTester{
//     " Router test" in{
//         test (new Router(6.U)){ c=>
//         c.io.recieve.poke(2.U)
//         c.io.in.poke(5.U)
//         c.io.transmit.expect(9.U)
//         c.io.out.expect(7.U)
        
//         }
//         test(new data_packets(5.U)){ c=>
//         c.io.address.poke(4.U)
//         c.io.address1.poke(4.U)
//         c.io.sel.poke(0.B)
//         c.io.Out.expect(4.U)
//         c.io.Out1.expect(4.U)
//         }
        
//     }
// }