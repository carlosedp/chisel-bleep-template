[![Scala CI](https://github.com/carlosedp/chisel-template/actions/workflows/scala.yml/badge.svg)](https://github.com/carlosedp/chisel-template/actions/workflows/scala.yml)

This is a template project to demonstrate [Chisel](https://www.chisel-lang.org/) functionality using the the Scala [Bleep build](https://bleep.build) tool.

The project includes a simple module (to be replaced with your design) and also have a test spec written with the [scalatest](https://www.scalatest.org/) and [chiseltest](https://github.com/ucb-bar/chiseltest) frameworks. The repository also have a GitHub Action to run automated tests on main branch and PRs.

Chisel Learning Resources:

- [Chisel Book](https://github.com/schoeberl/chisel-book)
- [Chisel Documentation](https://www.chisel-lang.org/chisel3/)
- [Chisel API](https://www.chisel-lang.org/api/latest/chisel3/index.html)

Software requirements:

- Bleep build tool
- Firtool, the Chisel Firttl compiler

- Verilator (as an option for simulation) - Optional
- GTKWave (to visualize VCD files) - Optional

## Installing the Requirements

I recommend [using Coursier](https://get-coursier.io/docs/cli-installation#native-launcher) to manage all installation tooling related to Scala as it will download a Java SDK and the build tool:

On Windows, download and install using the [Windows Installer](https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-win32.zip).

```sh
# For Linux
curl -fL "https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz" | gzip -d > cs
# For MacOS
curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-apple-darwin.gz | gzip -d > cs

chmod +x cs
./cs setup

# Install Bleep build tool:
cs install --channel https://raw.githubusercontent.com/oyvindberg/bleep/master/coursier-channel.json bleep
```

Then install Chisel Firtool that compiles the generated code to SystemVerilog from <https://github.com/llvm/circt/releases/latest>, downloading the binary for your platform and adding it to the $PATH.

## Generating Verilog

Verilog code can be generated from Chisel by using the build tool

```sh
bleep run toplevel
```

The output verilog files are generated in the `./generated` directory.

Running tests can be done with:

```sh
bleep test
```
