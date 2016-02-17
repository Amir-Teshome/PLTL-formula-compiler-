# PLTL-formula-compiler-

This project was doen as a proof of concept for the work described in this paper. 

The detailed functinalities of the code is described in this paper. 

To run this command u need to install ANTLR (ANother Tool for Language Recognition). This tool is used as a parser generator. It takes a gramer rules and generate a parser. details about the tool can be found in this link.

Then execute 'run.sh' file. Make sure that all the files listed in 'run.sh' exist in the same folde (or it you need to edit 'run.sh')

The auto-generated .java files are stored in pre-compiled folder (you don't need this files becouse they will be automatically generated when you compile the .g4 files)

Domain file lists a set of contexts in the following format. 

DOMAIN_NAME = {CONTEXT1_NAME, CONTEX2_NAME,...}
