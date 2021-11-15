// package LAB2
// import org.scalatest._
// import chiseltest._
// import chisel3._

// class MUXbarreltest extends FreeSpec with ChiselScalatestTester {
//     " MUX barrel test" in {
//         test (new MUXbarrel){ c =>
//         c.io.in(0).poke(1.B)
//         c.clock.step(1)
//         c.io.in(1).poke(1.B)
//         c.clock.step(1)
//         c.io.in(2).poke(1.B)
//         c.clock.step(1)
//         c.io.in(3).poke(1.B)
//         c.clock.step(1)
//         c.io.sel(0).poke(0.B)
//         c.clock.step(1)
//         c.io.sel(1).poke(1.B)
//         c.clock.step(1)
//         c.io.shft.poke(0.B)
//         c.clock.step(1)
//         c.mux.expect(1.B)
//         c.clock.step(1)
//         c.mux1.expect(1.B)
//         c.clock.step(1)
//         c.mux2.expect(1.B)
//         c.clock.step(1)
//         c.mux3.expect(1.B)
//         c.clock.step(100)
//         }
//     }
// }