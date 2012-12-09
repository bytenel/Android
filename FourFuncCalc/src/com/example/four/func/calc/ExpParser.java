package com.example.four.func.calc;
// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/Exp.g 2012-09-05 00:14:57

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Number", "WS", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int WS=5;
    public static final int Number=4;
    public static final int T__11=11;
    public static final int T__10=10;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators


        public ExpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpParser.tokenNames; }
    public String getGrammarFileName() { return "src/Exp.g"; }



    // $ANTLR start "eval"
    // src/Exp.g:3:1: eval returns [double value] : exp= additionExp ;
    public final double eval() throws RecognitionException {
        double value = 0.0;

        double exp = 0.0;


        try {
            // src/Exp.g:4:5: (exp= additionExp )
            // src/Exp.g:4:10: exp= additionExp
            {
            pushFollow(FOLLOW_additionExp_in_eval23);
            exp=additionExp();

            state._fsp--;

            value = exp;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "eval"


    // $ANTLR start "additionExp"
    // src/Exp.g:7:1: additionExp returns [double value] : m1= multiplyExp ( '+' m2= multiplyExp | '-' m2= multiplyExp )* ;
    public final double additionExp() throws RecognitionException {
        double value = 0.0;

        double m1 = 0.0;

        double m2 = 0.0;


        try {
            // src/Exp.g:8:5: (m1= multiplyExp ( '+' m2= multiplyExp | '-' m2= multiplyExp )* )
            // src/Exp.g:8:10: m1= multiplyExp ( '+' m2= multiplyExp | '-' m2= multiplyExp )*
            {
            pushFollow(FOLLOW_multiplyExp_in_additionExp51);
            m1=multiplyExp();

            state._fsp--;

            value =  m1;
            // src/Exp.g:9:10: ( '+' m2= multiplyExp | '-' m2= multiplyExp )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==6) ) {
                    alt1=1;
                }
                else if ( (LA1_0==7) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // src/Exp.g:9:12: '+' m2= multiplyExp
            	    {
            	    match(input,6,FOLLOW_6_in_additionExp73); 
            	    pushFollow(FOLLOW_multiplyExp_in_additionExp77);
            	    m2=multiplyExp();

            	    state._fsp--;

            	    value += m2;

            	    }
            	    break;
            	case 2 :
            	    // src/Exp.g:10:12: '-' m2= multiplyExp
            	    {
            	    match(input,7,FOLLOW_7_in_additionExp93); 
            	    pushFollow(FOLLOW_multiplyExp_in_additionExp97);
            	    m2=multiplyExp();

            	    state._fsp--;

            	    value -= m2;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "additionExp"


    // $ANTLR start "multiplyExp"
    // src/Exp.g:14:1: multiplyExp returns [double value] : a1= atomExp ( '*' a2= atomExp | '/' a2= atomExp )* ;
    public final double multiplyExp() throws RecognitionException {
        double value = 0.0;

        double a1 = 0.0;

        double a2 = 0.0;


        try {
            // src/Exp.g:15:5: (a1= atomExp ( '*' a2= atomExp | '/' a2= atomExp )* )
            // src/Exp.g:15:10: a1= atomExp ( '*' a2= atomExp | '/' a2= atomExp )*
            {
            pushFollow(FOLLOW_atomExp_in_multiplyExp138);
            a1=atomExp();

            state._fsp--;

            value =  a1;
            // src/Exp.g:16:10: ( '*' a2= atomExp | '/' a2= atomExp )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==8) ) {
                    alt2=1;
                }
                else if ( (LA2_0==9) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // src/Exp.g:16:12: '*' a2= atomExp
            	    {
            	    match(input,8,FOLLOW_8_in_multiplyExp159); 
            	    pushFollow(FOLLOW_atomExp_in_multiplyExp163);
            	    a2=atomExp();

            	    state._fsp--;

            	    value *= a2;

            	    }
            	    break;
            	case 2 :
            	    // src/Exp.g:17:12: '/' a2= atomExp
            	    {
            	    match(input,9,FOLLOW_9_in_multiplyExp179); 
            	    pushFollow(FOLLOW_atomExp_in_multiplyExp183);
            	    a2=atomExp();

            	    state._fsp--;

            	    value /= a2;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "multiplyExp"


    // $ANTLR start "atomExp"
    // src/Exp.g:21:1: atomExp returns [double value] : (n= Number | '(' exp= additionExp ')' );
    public final double atomExp() throws RecognitionException {
        double value = 0.0;

        Token n=null;
        double exp = 0.0;


        try {
            // src/Exp.g:22:5: (n= Number | '(' exp= additionExp ')' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Number) ) {
                alt3=1;
            }
            else if ( (LA3_0==10) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/Exp.g:22:10: n= Number
                    {
                    n=(Token)match(input,Number,FOLLOW_Number_in_atomExp224); 
                    value = Double.parseDouble((n!=null?n.getText():null));

                    }
                    break;
                case 2 :
                    // src/Exp.g:23:10: '(' exp= additionExp ')'
                    {
                    match(input,10,FOLLOW_10_in_atomExp252); 
                    pushFollow(FOLLOW_additionExp_in_atomExp256);
                    exp=additionExp();

                    state._fsp--;

                    match(input,11,FOLLOW_11_in_atomExp258); 
                    value = exp;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "atomExp"

    // Delegated rules


 

    public static final BitSet FOLLOW_additionExp_in_eval23 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplyExp_in_additionExp51 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_6_in_additionExp73 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_multiplyExp_in_additionExp77 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_7_in_additionExp93 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_multiplyExp_in_additionExp97 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_atomExp_in_multiplyExp138 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_8_in_multiplyExp159 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_atomExp_in_multiplyExp163 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_9_in_multiplyExp179 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_atomExp_in_multiplyExp183 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_Number_in_atomExp224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_atomExp252 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_additionExp_in_atomExp256 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_atomExp258 = new BitSet(new long[]{0x0000000000000002L});

}