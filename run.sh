#!/bin/sh
export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java org.antlr.v4.runtime.misc.TestRig'

#compile the grammer using antler 
antlr4 -visitor PolicyGrammar.g4

#compile the generated java files
javac PolicyGrammar*.java 

# compile other java files including CompactVector.java InformationFlow.java ReachabilityList.java GetSubFormulas.java GetDomain.java
javac -Xlint Decision.java CompactVector.java InformationFlow.java ReachabilityList.java  SubFormula.java  GetSubFormulas.java GetDomain.java Replace.java ComputeVal.java Sat.java


#uncomment this line to see the out put of the parser in a given input
#grun PolicyGrammar 'stat' -gui inputfile
#run the parser

java Decision inputfile


#uncomment tis for testing the files under /TestFile folder
#for i in `ls TestFiles/Test*`; do
#   echo "***Trying to parse $i" 
#     #grun PolicyGrammar 'stat' -gui $i
#    echo $i "is finished" 
#    break
#done

echo "***** Done ******"
