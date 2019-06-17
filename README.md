# PLTL-formula-compiler-

This project was done as a proof of concept for the work described in [this paper](https://hal.inria.fr/hal-00916882)

The detailed functionalities of the code is described in [this paper](https://www.dropbox.com/s/rg0jhyeya67req8/report.pdf?dl=0).

To run the code, you need to install ANTLR (ANother Tool for Language Recognition). This tool is used as a parser generator. It takes grammar rules and generate a parser. Details about the tool can be found in [this link](http://www.antlr.org/).

Then execute 'run.sh' file. Make sure that all the files listed in 'run.sh' exist in the same folder (or you need to edit 'run.sh')

The auto-generated .java files are stored in pre-compiled folder (you don't need these files because they will be automatically generated when you compile the .g4 files)

Domain file lists set of contexts in the following format.

DOMAIN_NAME = {CONTEXT1_NAME, CONTEX2_NAME,...}

