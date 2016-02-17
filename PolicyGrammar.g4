
grammar PolicyGrammar;

import LexerGrammar;

stat       	: policy+ ;

policy 	   	: assignment NEWLINE? 							# printDecision_method 	
	   		| NEWLINE										# blank_method
	   		;

assignment 	: var '=' formula								# assign_method
           	;

formula    	: '(' formula ')'								# parens_method
	   		| PREVIOUS '(' formula ')'   					# y_method
	   		| formula SINCE formula							# s_method
	   		| EPAST '(' formula ')'      					# p_method
	   		| GPAST '(' formula ')'   						# h_method
	   		| NOT formula 	  								# not_method
	   		| formula AND formula  							# and_method
	   		| formula OR formula							# or_method
	   		| EXIST var IN termdom formula					# exist_method
	   		| ALL var IN termdom formula					# all_method
	   		| atom 											# atom_method
	   		;

atom   		: (termctx | var) FLOW (termctx | var)			# flow_method
	   		| (termctx | var) IFLOW (termctx | var)			# iflow_method
	   		| (termdom | termctx) ELEMENT termdom 			# elem_method
	   		| (termctx | var) EQU (termctx | var) 			# equ_ctx_method
	   		| (termdom | var) EQU (termdom | var)			# equ_dom_method
       		;


termctx   	: CTX											# ctx_method 
	   		;			

termdom   	: DOM											# dom_method 
	   		;			

var			: ID 											# var_method
			;