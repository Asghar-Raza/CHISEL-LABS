// package LAB3
// import org.scalatest._
// import chiseltest._
// import chisel3._

// class ValidDecodertest extends FreeSpec with ChiselScalatestTester{
//     "Decoder with Valid test" in{
//         test (new ValidDecoder){c =>
//         c.io.in.poke("b10".U)
//         c.clock.step(1)
//         c.io.out.expect("b0100".U)
//         c.clock.step(1)
//         c.io.in_a.poke("b0100"..U)
//         c.clock.step(1)
//         c.io.in_b.expect("b10".U)
//         c.clock.step(100)
//         }
//     }
// }