import chisel3._
import circt.stage.ChiselStage

class Toplevel() extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(Bool())
  })

  val dataIn = io.in
  io.out := !dataIn

}

// The Main object extending App to generate the Verilog code.
object Toplevel extends App {
  // Generate Verilog code for the Toplevel module at the specified path.
  ChiselStage.emitSystemVerilogFile(
    new Toplevel(),
    Array("--target-dir", "generated") ++ args,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info"),
  )
}
