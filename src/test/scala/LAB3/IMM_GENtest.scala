// package LAB3
// import chisel3.util._
// import chisel3._
// import chiseltest._
// import org.scalatest._
// import scala.util.Random
// import IMM_OP._

// class IMM_GENtest extends FreeSpec with ChiselScalatestTester{
//     " immediate generation test" in {
//         test (new IMM_GEN){ c=>
//         val array = Array(3146387, 19923603,5251619, 4292866287 )
//         // for (i <- 0 until 100){
//         val pc = 0
//         val op_r = 0//Random.nextInt(4)
//         val op = array(op_r)

//             // println(inp_a)
//             // println(inp_b)

//         val result = op match{
//             case 3146387   => 3  //load
//             case 19923603 => 19  //I
//             case 5251619 => 4 // s
//             case 4292866287 => -4 // jal UJ
//             case 
//         }
//         println(result)
//             c.io.ins.poke(op_r.U)   
//             c.io.PC.poke(pc.U)
//             // c.io.OP.poke(op.U)
//             c.clock.step(1)
//             c.io.out.expect(result.S)
//         // }
//     c.clock.step(200)
//         }
//     }
// }
