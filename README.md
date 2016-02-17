# PLTL-formula-compiler-

This project was done as a proof of concept for the work described in [this paper](https://hal.inria.fr/hal-00916882)

[I'm an inline-style link with title](https://www.google.com "Google's Homepage")

The detailed functionalities of the code is described in [this paper](https://www.dropbox.com/s/rg0jhyeya67req8/report.pdf?dl=0).

To run this command u need to install ANTLR (ANother Tool for Language Recognition). This tool is used as a parser generator. It takes a grammar rules and generate a parser. details about the tool can be found in [this link](http://www.antlr.org/).

Then execute 'run.sh' file. Make sure that all the files listed in 'run.sh' exist in the same folder (or it you need to edit 'run.sh')

The auto-generated .java files are stored in pre-compiled folder (you don't need this files because they will be automatically generated when you compile the .g4 files)

Domain file lists a set of contexts in the following format.

DOMAIN_NAME = {CONTEXT1_NAME, CONTEX2_NAME,...}

