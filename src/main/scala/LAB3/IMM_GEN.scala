// package LAB3
// import chisel3.util._
// import chisel3._

// class IMM_GEN_IO extends Bundle{
//     val ins = Input(UInt(32.W))
//     val PC = Input(UInt(32.W))
//     val out = Output(SInt(32.W))
//     // val OP = Input(UInt(7.W))
// }
// object IMM_OP{
//     val I_Imm = 19.U 
//     val S_Imm = 35.U
//     val L_Imm = 3.U
//     val SB_Imm = 99.U
//     val U_Imm = 55.U
//     val UJ_Imm = 111.U
// }
// import IMM_OP._
// class IMM_GEN extends Module{
//     val io = IO(new IMM_GEN_IO)
//     val imm7 = io.ins(7)
// 	val imm11 = io.ins(11,8)
// 	val imm19 = io.ins(19,12)
// 	val imm20 = io.ins(20)
// 	val imm24 = io.ins(24,21)
// 	val imm30 = io.ins(30,25)
// 	val imm31 = io.ins(31)
//     val OP = io.ins(6,0)

//     io.out := 0.S
//     switch(io.ins(6,0)){
//         is(I_Imm){
//             io.out := Cat(Fill(20,imm31),imm31,imm30,imm24,imm20).asSInt
//         }
//         is(S_Imm){
//             io.out := Cat(Fill(20,imm31),imm31,imm30,imm11,imm7).asSInt
//         }
//         is(SB_Imm){
//             io.out := Cat(Fill(19,imm31),imm31,imm7,imm30,imm11,0.U).asSInt + io.PC.asSInt
//         }
//         is(U_Imm){
//             io.out := (Cat(Fill(12,imm31),imm31,imm30,imm24,imm20,imm19) << "hc".U).asSInt
//         }
//         is (UJ_Imm){
//             io.out := Cat(Fill(11,imm31),imm31,imm19,imm20,imm30,imm24,0.U).asSInt + io.PC.asSInt
//         }
//         is (L_Imm){
//             io.out := Cat(Fill(20,imm31),imm31,imm30,imm24,imm20).asSInt
//         }
//     }
//     when (io.ins(6,0)=== 3.U | 13.U){
//         io.out := Cat(Fill(20,imm31),imm31,imm30,imm24,imm20).asSInt
//     }.elsewhen(io.ins(6,0) === 23.U){
//         io.out := Cat(Fill(20,imm31),imm31,imm30,imm11,imm7).asSInt
//     }.elsewhen(io.ins(6,0) === 63.U){
//         io.out := Cat(Fill(19,imm31),imm31,imm7,imm30,imm11,0.U).asSInt + io.PC.asSInt
//     }.elsewhen(io.ins(6,0)=== 37.U){
//         io.out := (Cat(Fill(12,imm31),imm31,imm30,imm24,imm20,imm19) << "hc".U).asSInt
//     }.elsewhen(io.ins(6,0)=== "h6F".U){
//         io.out := Cat(Fill(11,imm31),imm31,imm19,imm20,imm30,imm24,0.U).asSInt + io.PC.asSInt
//     }

//     io.I_Imm := Cat(Fill(20,imm31),imm31,imm30,imm24,imm20).asSInt
// 	io.S_Imm := Cat(Fill(20,imm31),imm31,imm30,imm11,imm7).asSInt
// 	io.SB_Imm := Cat(Fill(19,imm31),imm31,imm7,imm30,imm11,0.U).asSInt + io.PC.asSInt
// 	io.U_Imm := (Cat(Fill(12,imm31),imm31,imm30,imm24,imm20,imm19) << "hc".U).asSInt
// 	io.UJ_Imm := Cat(Fill(11,imm31),imm31,imm19,imm20,imm30,imm24,0.U).asSInt + io.PC.asSInt
// }