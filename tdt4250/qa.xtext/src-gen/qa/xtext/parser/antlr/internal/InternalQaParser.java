package qa.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import qa.xtext.services.QaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Title: '", "'try'", "'times'", "'reveal'", "'correct'", "'answer'", "'ID'", "'?'", "'!'", "'Candidates'", "':'", "','", "'Next'", "'if'", "'tries'", "'Section'", "'{'", "'}'", "'+-'", "'no'", "'yes'", "'#'", "'='", "'-'", "'.'", "'E'", "'e'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalQaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQaParser.tokenNames; }
    public String getGrammarFileName() { return "../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g"; }



     	private QaGrammarAccess grammarAccess;
     	
        public InternalQaParser(TokenStream input, QaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "QATest";	
       	}
       	
       	@Override
       	protected QaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleQATest"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:67:1: entryRuleQATest returns [EObject current=null] : iv_ruleQATest= ruleQATest EOF ;
    public final EObject entryRuleQATest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQATest = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:68:2: (iv_ruleQATest= ruleQATest EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:69:2: iv_ruleQATest= ruleQATest EOF
            {
             newCompositeNode(grammarAccess.getQATestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQATest_in_entryRuleQATest75);
            iv_ruleQATest=ruleQATest();

            state._fsp--;

             current =iv_ruleQATest; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQATest85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQATest"


    // $ANTLR start "ruleQATest"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:76:1: ruleQATest returns [EObject current=null] : (otherlv_0= 'Title: ' ( (lv_title_1_0= ruleEString ) ) ( (lv_options_2_0= ruleQAContainerOptions ) )? ( (lv_parts_3_0= ruleQAPart ) )* ) ;
    public final EObject ruleQATest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_title_1_0 = null;

        EObject lv_options_2_0 = null;

        EObject lv_parts_3_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:79:28: ( (otherlv_0= 'Title: ' ( (lv_title_1_0= ruleEString ) ) ( (lv_options_2_0= ruleQAContainerOptions ) )? ( (lv_parts_3_0= ruleQAPart ) )* ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:80:1: (otherlv_0= 'Title: ' ( (lv_title_1_0= ruleEString ) ) ( (lv_options_2_0= ruleQAContainerOptions ) )? ( (lv_parts_3_0= ruleQAPart ) )* )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:80:1: (otherlv_0= 'Title: ' ( (lv_title_1_0= ruleEString ) ) ( (lv_options_2_0= ruleQAContainerOptions ) )? ( (lv_parts_3_0= ruleQAPart ) )* )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:80:3: otherlv_0= 'Title: ' ( (lv_title_1_0= ruleEString ) ) ( (lv_options_2_0= ruleQAContainerOptions ) )? ( (lv_parts_3_0= ruleQAPart ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleQATest122); 

                	newLeafNode(otherlv_0, grammarAccess.getQATestAccess().getTitleKeyword_0());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:84:1: ( (lv_title_1_0= ruleEString ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:85:1: (lv_title_1_0= ruleEString )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:85:1: (lv_title_1_0= ruleEString )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:86:3: lv_title_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getQATestAccess().getTitleEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleQATest143);
            lv_title_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQATestRule());
            	        }
                   		set(
                   			current, 
                   			"title",
                    		lv_title_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:102:2: ( (lv_options_2_0= ruleQAContainerOptions ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:103:1: (lv_options_2_0= ruleQAContainerOptions )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:103:1: (lv_options_2_0= ruleQAContainerOptions )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:104:3: lv_options_2_0= ruleQAContainerOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getQATestAccess().getOptionsQAContainerOptionsParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_ruleQATest164);
                    lv_options_2_0=ruleQAContainerOptions();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQATestRule());
                    	        }
                           		set(
                           			current, 
                           			"options",
                            		lv_options_2_0, 
                            		"QAContainerOptions");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:120:3: ( (lv_parts_3_0= ruleQAPart ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_STRING||LA2_0==17||LA2_0==26) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:121:1: (lv_parts_3_0= ruleQAPart )
            	    {
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:121:1: (lv_parts_3_0= ruleQAPart )
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:122:3: lv_parts_3_0= ruleQAPart
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQATestAccess().getPartsQAPartParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleQAPart_in_ruleQATest186);
            	    lv_parts_3_0=ruleQAPart();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQATestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parts",
            	            		lv_parts_3_0, 
            	            		"QAPart");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQATest"


    // $ANTLR start "entryRuleQAContainerOptions"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:146:1: entryRuleQAContainerOptions returns [EObject current=null] : iv_ruleQAContainerOptions= ruleQAContainerOptions EOF ;
    public final EObject entryRuleQAContainerOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQAContainerOptions = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:147:2: (iv_ruleQAContainerOptions= ruleQAContainerOptions EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:148:2: iv_ruleQAContainerOptions= ruleQAContainerOptions EOF
            {
             newCompositeNode(grammarAccess.getQAContainerOptionsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_entryRuleQAContainerOptions223);
            iv_ruleQAContainerOptions=ruleQAContainerOptions();

            state._fsp--;

             current =iv_ruleQAContainerOptions; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQAContainerOptions233); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQAContainerOptions"


    // $ANTLR start "ruleQAContainerOptions"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:155:1: ruleQAContainerOptions returns [EObject current=null] : (otherlv_0= 'try' ( (lv_maxTries_1_0= RULE_INT ) ) otherlv_2= 'times' ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )? ) ;
    public final EObject ruleQAContainerOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_maxTries_1_0=null;
        Token otherlv_2=null;
        Token lv_revealAnswer_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:158:28: ( (otherlv_0= 'try' ( (lv_maxTries_1_0= RULE_INT ) ) otherlv_2= 'times' ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )? ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:159:1: (otherlv_0= 'try' ( (lv_maxTries_1_0= RULE_INT ) ) otherlv_2= 'times' ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )? )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:159:1: (otherlv_0= 'try' ( (lv_maxTries_1_0= RULE_INT ) ) otherlv_2= 'times' ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )? )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:159:3: otherlv_0= 'try' ( (lv_maxTries_1_0= RULE_INT ) ) otherlv_2= 'times' ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleQAContainerOptions270); 

                	newLeafNode(otherlv_0, grammarAccess.getQAContainerOptionsAccess().getTryKeyword_0());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:163:1: ( (lv_maxTries_1_0= RULE_INT ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:164:1: (lv_maxTries_1_0= RULE_INT )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:164:1: (lv_maxTries_1_0= RULE_INT )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:165:3: lv_maxTries_1_0= RULE_INT
            {
            lv_maxTries_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleQAContainerOptions287); 

            			newLeafNode(lv_maxTries_1_0, grammarAccess.getQAContainerOptionsAccess().getMaxTriesINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQAContainerOptionsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"maxTries",
                    		lv_maxTries_1_0, 
                    		"INT");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleQAContainerOptions304); 

                	newLeafNode(otherlv_2, grammarAccess.getQAContainerOptionsAccess().getTimesKeyword_2());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:185:1: ( ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:185:2: ( (lv_revealAnswer_3_0= 'reveal' ) ) otherlv_4= 'correct' otherlv_5= 'answer'
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:185:2: ( (lv_revealAnswer_3_0= 'reveal' ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:186:1: (lv_revealAnswer_3_0= 'reveal' )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:186:1: (lv_revealAnswer_3_0= 'reveal' )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:187:3: lv_revealAnswer_3_0= 'reveal'
                    {
                    lv_revealAnswer_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleQAContainerOptions323); 

                            newLeafNode(lv_revealAnswer_3_0, grammarAccess.getQAContainerOptionsAccess().getRevealAnswerRevealKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQAContainerOptionsRule());
                    	        }
                           		setWithLastConsumed(current, "revealAnswer", true, "reveal");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleQAContainerOptions348); 

                        	newLeafNode(otherlv_4, grammarAccess.getQAContainerOptionsAccess().getCorrectKeyword_3_1());
                        
                    otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleQAContainerOptions360); 

                        	newLeafNode(otherlv_5, grammarAccess.getQAContainerOptionsAccess().getAnswerKeyword_3_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQAContainerOptions"


    // $ANTLR start "entryRuleQAPart"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:216:1: entryRuleQAPart returns [EObject current=null] : iv_ruleQAPart= ruleQAPart EOF ;
    public final EObject entryRuleQAPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQAPart = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:217:2: (iv_ruleQAPart= ruleQAPart EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:218:2: iv_ruleQAPart= ruleQAPart EOF
            {
             newCompositeNode(grammarAccess.getQAPartRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAPart_in_entryRuleQAPart398);
            iv_ruleQAPart=ruleQAPart();

            state._fsp--;

             current =iv_ruleQAPart; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQAPart408); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQAPart"


    // $ANTLR start "ruleQAPart"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:225:1: ruleQAPart returns [EObject current=null] : (this_Question_0= ruleQuestion | this_QASection_1= ruleQASection ) ;
    public final EObject ruleQAPart() throws RecognitionException {
        EObject current = null;

        EObject this_Question_0 = null;

        EObject this_QASection_1 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:228:28: ( (this_Question_0= ruleQuestion | this_QASection_1= ruleQASection ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:229:1: (this_Question_0= ruleQuestion | this_QASection_1= ruleQASection )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:229:1: (this_Question_0= ruleQuestion | this_QASection_1= ruleQASection )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING||LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==26) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:230:5: this_Question_0= ruleQuestion
                    {
                     
                            newCompositeNode(grammarAccess.getQAPartAccess().getQuestionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_ruleQAPart455);
                    this_Question_0=ruleQuestion();

                    state._fsp--;

                     
                            current = this_Question_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:240:5: this_QASection_1= ruleQASection
                    {
                     
                            newCompositeNode(grammarAccess.getQAPartAccess().getQASectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQASection_in_ruleQAPart482);
                    this_QASection_1=ruleQASection();

                    state._fsp--;

                     
                            current = this_QASection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQAPart"


    // $ANTLR start "entryRuleAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:256:1: entryRuleAnswer returns [EObject current=null] : iv_ruleAnswer= ruleAnswer EOF ;
    public final EObject entryRuleAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:257:2: (iv_ruleAnswer= ruleAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:258:2: iv_ruleAnswer= ruleAnswer EOF
            {
             newCompositeNode(grammarAccess.getAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_entryRuleAnswer517);
            iv_ruleAnswer=ruleAnswer();

            state._fsp--;

             current =iv_ruleAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnswer527); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnswer"


    // $ANTLR start "ruleAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:265:1: ruleAnswer returns [EObject current=null] : (this_TextAnswer_0= ruleTextAnswer | this_NumberAnswer_1= ruleNumberAnswer | this_YesNoAnswer_2= ruleYesNoAnswer | this_OptionAnswer_3= ruleOptionAnswer | this_ExpressionAnswer_4= ruleExpressionAnswer ) ;
    public final EObject ruleAnswer() throws RecognitionException {
        EObject current = null;

        EObject this_TextAnswer_0 = null;

        EObject this_NumberAnswer_1 = null;

        EObject this_YesNoAnswer_2 = null;

        EObject this_OptionAnswer_3 = null;

        EObject this_ExpressionAnswer_4 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:268:28: ( (this_TextAnswer_0= ruleTextAnswer | this_NumberAnswer_1= ruleNumberAnswer | this_YesNoAnswer_2= ruleYesNoAnswer | this_OptionAnswer_3= ruleOptionAnswer | this_ExpressionAnswer_4= ruleExpressionAnswer ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:269:1: (this_TextAnswer_0= ruleTextAnswer | this_NumberAnswer_1= ruleNumberAnswer | this_YesNoAnswer_2= ruleYesNoAnswer | this_OptionAnswer_3= ruleOptionAnswer | this_ExpressionAnswer_4= ruleExpressionAnswer )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:269:1: (this_TextAnswer_0= ruleTextAnswer | this_NumberAnswer_1= ruleNumberAnswer | this_YesNoAnswer_2= ruleYesNoAnswer | this_OptionAnswer_3= ruleOptionAnswer | this_ExpressionAnswer_4= ruleExpressionAnswer )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt5=1;
                }
                break;
            case RULE_INT:
            case 34:
                {
                alt5=2;
                }
                break;
            case 30:
            case 31:
                {
                alt5=3;
                }
                break;
            case 32:
                {
                alt5=4;
                }
                break;
            case 33:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:270:5: this_TextAnswer_0= ruleTextAnswer
                    {
                     
                            newCompositeNode(grammarAccess.getAnswerAccess().getTextAnswerParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTextAnswer_in_ruleAnswer574);
                    this_TextAnswer_0=ruleTextAnswer();

                    state._fsp--;

                     
                            current = this_TextAnswer_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:280:5: this_NumberAnswer_1= ruleNumberAnswer
                    {
                     
                            newCompositeNode(grammarAccess.getAnswerAccess().getNumberAnswerParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumberAnswer_in_ruleAnswer601);
                    this_NumberAnswer_1=ruleNumberAnswer();

                    state._fsp--;

                     
                            current = this_NumberAnswer_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:290:5: this_YesNoAnswer_2= ruleYesNoAnswer
                    {
                     
                            newCompositeNode(grammarAccess.getAnswerAccess().getYesNoAnswerParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleYesNoAnswer_in_ruleAnswer628);
                    this_YesNoAnswer_2=ruleYesNoAnswer();

                    state._fsp--;

                     
                            current = this_YesNoAnswer_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:300:5: this_OptionAnswer_3= ruleOptionAnswer
                    {
                     
                            newCompositeNode(grammarAccess.getAnswerAccess().getOptionAnswerParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOptionAnswer_in_ruleAnswer655);
                    this_OptionAnswer_3=ruleOptionAnswer();

                    state._fsp--;

                     
                            current = this_OptionAnswer_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:310:5: this_ExpressionAnswer_4= ruleExpressionAnswer
                    {
                     
                            newCompositeNode(grammarAccess.getAnswerAccess().getExpressionAnswerParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpressionAnswer_in_ruleAnswer682);
                    this_ExpressionAnswer_4=ruleExpressionAnswer();

                    state._fsp--;

                     
                            current = this_ExpressionAnswer_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnswer"


    // $ANTLR start "entryRuleQuestion"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:326:1: entryRuleQuestion returns [EObject current=null] : iv_ruleQuestion= ruleQuestion EOF ;
    public final EObject entryRuleQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuestion = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:327:2: (iv_ruleQuestion= ruleQuestion EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:328:2: iv_ruleQuestion= ruleQuestion EOF
            {
             newCompositeNode(grammarAccess.getQuestionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_entryRuleQuestion717);
            iv_ruleQuestion=ruleQuestion();

            state._fsp--;

             current =iv_ruleQuestion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuestion727); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuestion"


    // $ANTLR start "ruleQuestion"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:335:1: ruleQuestion returns [EObject current=null] : ( (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_text_2_0= ruleEString ) ) (otherlv_3= '?' )? ( (lv_correct_4_0= ruleAnswer ) ) (otherlv_5= '!' )? (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )? ( (lv_nextRules_11_0= ruleNextRule ) )* ) ;
    public final EObject ruleQuestion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_text_2_0 = null;

        EObject lv_correct_4_0 = null;

        EObject lv_candidates_8_0 = null;

        EObject lv_candidates_10_0 = null;

        EObject lv_nextRules_11_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:338:28: ( ( (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_text_2_0= ruleEString ) ) (otherlv_3= '?' )? ( (lv_correct_4_0= ruleAnswer ) ) (otherlv_5= '!' )? (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )? ( (lv_nextRules_11_0= ruleNextRule ) )* ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:339:1: ( (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_text_2_0= ruleEString ) ) (otherlv_3= '?' )? ( (lv_correct_4_0= ruleAnswer ) ) (otherlv_5= '!' )? (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )? ( (lv_nextRules_11_0= ruleNextRule ) )* )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:339:1: ( (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_text_2_0= ruleEString ) ) (otherlv_3= '?' )? ( (lv_correct_4_0= ruleAnswer ) ) (otherlv_5= '!' )? (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )? ( (lv_nextRules_11_0= ruleNextRule ) )* )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:339:2: (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_text_2_0= ruleEString ) ) (otherlv_3= '?' )? ( (lv_correct_4_0= ruleAnswer ) ) (otherlv_5= '!' )? (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )? ( (lv_nextRules_11_0= ruleNextRule ) )*
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:339:2: (otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:339:4: otherlv_0= 'ID' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleQuestion765); 

                        	newLeafNode(otherlv_0, grammarAccess.getQuestionAccess().getIDKeyword_0_0());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:343:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:344:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:344:1: (lv_name_1_0= RULE_ID )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:345:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQuestion782); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getQuestionAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQuestionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:361:4: ( (lv_text_2_0= ruleEString ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:362:1: (lv_text_2_0= ruleEString )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:362:1: (lv_text_2_0= ruleEString )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:363:3: lv_text_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getQuestionAccess().getTextEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleQuestion810);
            lv_text_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQuestionRule());
            	        }
                   		set(
                   			current, 
                   			"text",
                    		lv_text_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:379:2: (otherlv_3= '?' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:379:4: otherlv_3= '?'
                    {
                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleQuestion823); 

                        	newLeafNode(otherlv_3, grammarAccess.getQuestionAccess().getQuestionMarkKeyword_2());
                        

                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:383:3: ( (lv_correct_4_0= ruleAnswer ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:384:1: (lv_correct_4_0= ruleAnswer )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:384:1: (lv_correct_4_0= ruleAnswer )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:385:3: lv_correct_4_0= ruleAnswer
            {
             
            	        newCompositeNode(grammarAccess.getQuestionAccess().getCorrectAnswerParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_ruleQuestion846);
            lv_correct_4_0=ruleAnswer();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQuestionRule());
            	        }
                   		set(
                   			current, 
                   			"correct",
                    		lv_correct_4_0, 
                    		"Answer");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:401:2: (otherlv_5= '!' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:401:4: otherlv_5= '!'
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleQuestion859); 

                        	newLeafNode(otherlv_5, grammarAccess.getQuestionAccess().getExclamationMarkKeyword_4());
                        

                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:405:3: (otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:405:5: otherlv_6= 'Candidates' otherlv_7= ':' ( (lv_candidates_8_0= ruleAnswer ) ) (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )*
                    {
                    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleQuestion874); 

                        	newLeafNode(otherlv_6, grammarAccess.getQuestionAccess().getCandidatesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleQuestion886); 

                        	newLeafNode(otherlv_7, grammarAccess.getQuestionAccess().getColonKeyword_5_1());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:413:1: ( (lv_candidates_8_0= ruleAnswer ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:414:1: (lv_candidates_8_0= ruleAnswer )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:414:1: (lv_candidates_8_0= ruleAnswer )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:415:3: lv_candidates_8_0= ruleAnswer
                    {
                     
                    	        newCompositeNode(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_ruleQuestion907);
                    lv_candidates_8_0=ruleAnswer();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQuestionRule());
                    	        }
                           		add(
                           			current, 
                           			"candidates",
                            		lv_candidates_8_0, 
                            		"Answer");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:431:2: (otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==22) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:431:4: otherlv_9= ',' ( (lv_candidates_10_0= ruleAnswer ) )
                    	    {
                    	    otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleQuestion920); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getQuestionAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:435:1: ( (lv_candidates_10_0= ruleAnswer ) )
                    	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:436:1: (lv_candidates_10_0= ruleAnswer )
                    	    {
                    	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:436:1: (lv_candidates_10_0= ruleAnswer )
                    	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:437:3: lv_candidates_10_0= ruleAnswer
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_ruleQuestion941);
                    	    lv_candidates_10_0=ruleAnswer();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getQuestionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"candidates",
                    	            		lv_candidates_10_0, 
                    	            		"Answer");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:453:6: ( (lv_nextRules_11_0= ruleNextRule ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:454:1: (lv_nextRules_11_0= ruleNextRule )
            	    {
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:454:1: (lv_nextRules_11_0= ruleNextRule )
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:455:3: lv_nextRules_11_0= ruleNextRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQuestionAccess().getNextRulesNextRuleParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNextRule_in_ruleQuestion966);
            	    lv_nextRules_11_0=ruleNextRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQuestionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nextRules",
            	            		lv_nextRules_11_0, 
            	            		"NextRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuestion"


    // $ANTLR start "entryRuleNextRule"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:479:1: entryRuleNextRule returns [EObject current=null] : iv_ruleNextRule= ruleNextRule EOF ;
    public final EObject entryRuleNextRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextRule = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:480:2: (iv_ruleNextRule= ruleNextRule EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:481:2: iv_ruleNextRule= ruleNextRule EOF
            {
             newCompositeNode(grammarAccess.getNextRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNextRule_in_entryRuleNextRule1003);
            iv_ruleNextRule=ruleNextRule();

            state._fsp--;

             current =iv_ruleNextRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextRule1013); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextRule"


    // $ANTLR start "ruleNextRule"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:488:1: ruleNextRule returns [EObject current=null] : ( () otherlv_1= 'Next' otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )? ) ;
    public final EObject ruleNextRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_tries_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:491:28: ( ( () otherlv_1= 'Next' otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )? ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:492:1: ( () otherlv_1= 'Next' otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )? )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:492:1: ( () otherlv_1= 'Next' otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )? )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:492:2: () otherlv_1= 'Next' otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )?
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:492:2: ()
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:493:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNextRuleAccess().getNextRuleAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNextRule1059); 

                	newLeafNode(otherlv_1, grammarAccess.getNextRuleAccess().getNextKeyword_1());
                
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNextRule1071); 

                	newLeafNode(otherlv_2, grammarAccess.getNextRuleAccess().getColonKeyword_2());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:506:1: ( (otherlv_3= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:507:1: (otherlv_3= RULE_ID )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:507:1: (otherlv_3= RULE_ID )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:508:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNextRuleRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNextRule1091); 

                    		newLeafNode(otherlv_3, grammarAccess.getNextRuleAccess().getNextQAPartCrossReference_3_0()); 
                    	

                    }


                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:519:3: (otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:519:5: otherlv_4= 'if' ( (lv_tries_5_0= RULE_INT ) ) otherlv_6= 'tries'
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNextRule1105); 

                        	newLeafNode(otherlv_4, grammarAccess.getNextRuleAccess().getIfKeyword_4_0());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:523:1: ( (lv_tries_5_0= RULE_INT ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:524:1: (lv_tries_5_0= RULE_INT )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:524:1: (lv_tries_5_0= RULE_INT )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:525:3: lv_tries_5_0= RULE_INT
                    {
                    lv_tries_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNextRule1122); 

                    			newLeafNode(lv_tries_5_0, grammarAccess.getNextRuleAccess().getTriesINTTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNextRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"tries",
                            		lv_tries_5_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNextRule1139); 

                        	newLeafNode(otherlv_6, grammarAccess.getNextRuleAccess().getTriesKeyword_4_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextRule"


    // $ANTLR start "entryRuleQASection"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:553:1: entryRuleQASection returns [EObject current=null] : iv_ruleQASection= ruleQASection EOF ;
    public final EObject entryRuleQASection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQASection = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:554:2: (iv_ruleQASection= ruleQASection EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:555:2: iv_ruleQASection= ruleQASection EOF
            {
             newCompositeNode(grammarAccess.getQASectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQASection_in_entryRuleQASection1177);
            iv_ruleQASection=ruleQASection();

            state._fsp--;

             current =iv_ruleQASection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQASection1187); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQASection"


    // $ANTLR start "ruleQASection"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:562:1: ruleQASection returns [EObject current=null] : (otherlv_0= 'Section' (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )? ( (lv_title_3_0= ruleEString ) ) ( (lv_options_4_0= ruleQAContainerOptions ) )? otherlv_5= '{' ( (lv_questions_6_0= ruleQuestion ) )* otherlv_7= '}' ) ;
    public final EObject ruleQASection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_options_4_0 = null;

        EObject lv_questions_6_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:565:28: ( (otherlv_0= 'Section' (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )? ( (lv_title_3_0= ruleEString ) ) ( (lv_options_4_0= ruleQAContainerOptions ) )? otherlv_5= '{' ( (lv_questions_6_0= ruleQuestion ) )* otherlv_7= '}' ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:566:1: (otherlv_0= 'Section' (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )? ( (lv_title_3_0= ruleEString ) ) ( (lv_options_4_0= ruleQAContainerOptions ) )? otherlv_5= '{' ( (lv_questions_6_0= ruleQuestion ) )* otherlv_7= '}' )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:566:1: (otherlv_0= 'Section' (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )? ( (lv_title_3_0= ruleEString ) ) ( (lv_options_4_0= ruleQAContainerOptions ) )? otherlv_5= '{' ( (lv_questions_6_0= ruleQuestion ) )* otherlv_7= '}' )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:566:3: otherlv_0= 'Section' (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )? ( (lv_title_3_0= ruleEString ) ) ( (lv_options_4_0= ruleQAContainerOptions ) )? otherlv_5= '{' ( (lv_questions_6_0= ruleQuestion ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleQASection1224); 

                	newLeafNode(otherlv_0, grammarAccess.getQASectionAccess().getSectionKeyword_0());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:570:1: (otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:570:3: otherlv_1= 'ID' ( (lv_name_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleQASection1237); 

                        	newLeafNode(otherlv_1, grammarAccess.getQASectionAccess().getIDKeyword_1_0());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:574:1: ( (lv_name_2_0= RULE_ID ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:575:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:575:1: (lv_name_2_0= RULE_ID )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:576:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQASection1254); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getQASectionAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQASectionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:592:4: ( (lv_title_3_0= ruleEString ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:593:1: (lv_title_3_0= ruleEString )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:593:1: (lv_title_3_0= ruleEString )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:594:3: lv_title_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getQASectionAccess().getTitleEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleQASection1282);
            lv_title_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQASectionRule());
            	        }
                   		set(
                   			current, 
                   			"title",
                    		lv_title_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:610:2: ( (lv_options_4_0= ruleQAContainerOptions ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==12) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:611:1: (lv_options_4_0= ruleQAContainerOptions )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:611:1: (lv_options_4_0= ruleQAContainerOptions )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:612:3: lv_options_4_0= ruleQAContainerOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getQASectionAccess().getOptionsQAContainerOptionsParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_ruleQASection1303);
                    lv_options_4_0=ruleQAContainerOptions();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQASectionRule());
                    	        }
                           		set(
                           			current, 
                           			"options",
                            		lv_options_4_0, 
                            		"QAContainerOptions");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleQASection1316); 

                	newLeafNode(otherlv_5, grammarAccess.getQASectionAccess().getLeftCurlyBracketKeyword_4());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:632:1: ( (lv_questions_6_0= ruleQuestion ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING||LA16_0==17) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:633:1: (lv_questions_6_0= ruleQuestion )
            	    {
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:633:1: (lv_questions_6_0= ruleQuestion )
            	    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:634:3: lv_questions_6_0= ruleQuestion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQASectionAccess().getQuestionsQuestionParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_ruleQASection1337);
            	    lv_questions_6_0=ruleQuestion();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQASectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"questions",
            	            		lv_questions_6_0, 
            	            		"Question");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleQASection1350); 

                	newLeafNode(otherlv_7, grammarAccess.getQASectionAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQASection"


    // $ANTLR start "entryRuleTextAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:662:1: entryRuleTextAnswer returns [EObject current=null] : iv_ruleTextAnswer= ruleTextAnswer EOF ;
    public final EObject entryRuleTextAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:663:2: (iv_ruleTextAnswer= ruleTextAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:664:2: iv_ruleTextAnswer= ruleTextAnswer EOF
            {
             newCompositeNode(grammarAccess.getTextAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTextAnswer_in_entryRuleTextAnswer1386);
            iv_ruleTextAnswer=ruleTextAnswer();

            state._fsp--;

             current =iv_ruleTextAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextAnswer1396); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextAnswer"


    // $ANTLR start "ruleTextAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:671:1: ruleTextAnswer returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleTextAnswer() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:674:28: ( ( (lv_text_0_0= ruleEString ) ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:675:1: ( (lv_text_0_0= ruleEString ) )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:675:1: ( (lv_text_0_0= ruleEString ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:676:1: (lv_text_0_0= ruleEString )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:676:1: (lv_text_0_0= ruleEString )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:677:3: lv_text_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTextAnswerAccess().getTextEStringParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleTextAnswer1441);
            lv_text_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTextAnswerRule());
            	        }
                   		set(
                   			current, 
                   			"text",
                    		lv_text_0_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextAnswer"


    // $ANTLR start "entryRuleNumberAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:701:1: entryRuleNumberAnswer returns [EObject current=null] : iv_ruleNumberAnswer= ruleNumberAnswer EOF ;
    public final EObject entryRuleNumberAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:702:2: (iv_ruleNumberAnswer= ruleNumberAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:703:2: iv_ruleNumberAnswer= ruleNumberAnswer EOF
            {
             newCompositeNode(grammarAccess.getNumberAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumberAnswer_in_entryRuleNumberAnswer1476);
            iv_ruleNumberAnswer=ruleNumberAnswer();

            state._fsp--;

             current =iv_ruleNumberAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberAnswer1486); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberAnswer"


    // $ANTLR start "ruleNumberAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:710:1: ruleNumberAnswer returns [EObject current=null] : ( ( (lv_number_0_0= ruleEDouble ) ) (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )? ) ;
    public final EObject ruleNumberAnswer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;

        AntlrDatatypeRuleToken lv_epsilon_2_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:713:28: ( ( ( (lv_number_0_0= ruleEDouble ) ) (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )? ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:714:1: ( ( (lv_number_0_0= ruleEDouble ) ) (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )? )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:714:1: ( ( (lv_number_0_0= ruleEDouble ) ) (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )? )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:714:2: ( (lv_number_0_0= ruleEDouble ) ) (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )?
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:714:2: ( (lv_number_0_0= ruleEDouble ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:715:1: (lv_number_0_0= ruleEDouble )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:715:1: (lv_number_0_0= ruleEDouble )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:716:3: lv_number_0_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getNumberAnswerAccess().getNumberEDoubleParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleNumberAnswer1532);
            lv_number_0_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumberAnswerRule());
            	        }
                   		set(
                   			current, 
                   			"number",
                    		lv_number_0_0, 
                    		"EDouble");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:732:2: (otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:732:4: otherlv_1= '+-' ( (lv_epsilon_2_0= ruleEDouble ) )
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNumberAnswer1545); 

                        	newLeafNode(otherlv_1, grammarAccess.getNumberAnswerAccess().getPlusSignHyphenMinusKeyword_1_0());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:736:1: ( (lv_epsilon_2_0= ruleEDouble ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:737:1: (lv_epsilon_2_0= ruleEDouble )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:737:1: (lv_epsilon_2_0= ruleEDouble )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:738:3: lv_epsilon_2_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumberAnswerAccess().getEpsilonEDoubleParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleNumberAnswer1566);
                    lv_epsilon_2_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNumberAnswerRule());
                    	        }
                           		set(
                           			current, 
                           			"epsilon",
                            		lv_epsilon_2_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberAnswer"


    // $ANTLR start "entryRuleYesNoAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:762:1: entryRuleYesNoAnswer returns [EObject current=null] : iv_ruleYesNoAnswer= ruleYesNoAnswer EOF ;
    public final EObject entryRuleYesNoAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleYesNoAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:763:2: (iv_ruleYesNoAnswer= ruleYesNoAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:764:2: iv_ruleYesNoAnswer= ruleYesNoAnswer EOF
            {
             newCompositeNode(grammarAccess.getYesNoAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleYesNoAnswer_in_entryRuleYesNoAnswer1604);
            iv_ruleYesNoAnswer=ruleYesNoAnswer();

            state._fsp--;

             current =iv_ruleYesNoAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleYesNoAnswer1614); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleYesNoAnswer"


    // $ANTLR start "ruleYesNoAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:771:1: ruleYesNoAnswer returns [EObject current=null] : ( ( () otherlv_1= 'no' ) | ( (lv_yes_2_0= 'yes' ) ) ) ;
    public final EObject ruleYesNoAnswer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_yes_2_0=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:774:28: ( ( ( () otherlv_1= 'no' ) | ( (lv_yes_2_0= 'yes' ) ) ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:1: ( ( () otherlv_1= 'no' ) | ( (lv_yes_2_0= 'yes' ) ) )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:1: ( ( () otherlv_1= 'no' ) | ( (lv_yes_2_0= 'yes' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            else if ( (LA18_0==31) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:2: ( () otherlv_1= 'no' )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:2: ( () otherlv_1= 'no' )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:3: () otherlv_1= 'no'
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:775:3: ()
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:776:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getYesNoAnswerAccess().getYesNoAnswerAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleYesNoAnswer1661); 

                        	newLeafNode(otherlv_1, grammarAccess.getYesNoAnswerAccess().getNoKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:786:6: ( (lv_yes_2_0= 'yes' ) )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:786:6: ( (lv_yes_2_0= 'yes' ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:787:1: (lv_yes_2_0= 'yes' )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:787:1: (lv_yes_2_0= 'yes' )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:788:3: lv_yes_2_0= 'yes'
                    {
                    lv_yes_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleYesNoAnswer1686); 

                            newLeafNode(lv_yes_2_0, grammarAccess.getYesNoAnswerAccess().getYesYesKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getYesNoAnswerRule());
                    	        }
                           		setWithLastConsumed(current, "yes", true, "yes");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleYesNoAnswer"


    // $ANTLR start "entryRuleOptionAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:809:1: entryRuleOptionAnswer returns [EObject current=null] : iv_ruleOptionAnswer= ruleOptionAnswer EOF ;
    public final EObject entryRuleOptionAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:810:2: (iv_ruleOptionAnswer= ruleOptionAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:811:2: iv_ruleOptionAnswer= ruleOptionAnswer EOF
            {
             newCompositeNode(grammarAccess.getOptionAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionAnswer_in_entryRuleOptionAnswer1735);
            iv_ruleOptionAnswer=ruleOptionAnswer();

            state._fsp--;

             current =iv_ruleOptionAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionAnswer1745); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionAnswer"


    // $ANTLR start "ruleOptionAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:818:1: ruleOptionAnswer returns [EObject current=null] : (otherlv_0= '#' ( (lv_optionNumber_1_0= ruleEInt ) ) ) ;
    public final EObject ruleOptionAnswer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_optionNumber_1_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:821:28: ( (otherlv_0= '#' ( (lv_optionNumber_1_0= ruleEInt ) ) ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:822:1: (otherlv_0= '#' ( (lv_optionNumber_1_0= ruleEInt ) ) )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:822:1: (otherlv_0= '#' ( (lv_optionNumber_1_0= ruleEInt ) ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:822:3: otherlv_0= '#' ( (lv_optionNumber_1_0= ruleEInt ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleOptionAnswer1782); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionAnswerAccess().getNumberSignKeyword_0());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:826:1: ( (lv_optionNumber_1_0= ruleEInt ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:827:1: (lv_optionNumber_1_0= ruleEInt )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:827:1: (lv_optionNumber_1_0= ruleEInt )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:828:3: lv_optionNumber_1_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getOptionAnswerAccess().getOptionNumberEIntParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleOptionAnswer1803);
            lv_optionNumber_1_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionAnswerRule());
            	        }
                   		set(
                   			current, 
                   			"optionNumber",
                    		lv_optionNumber_1_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionAnswer"


    // $ANTLR start "entryRuleExpressionAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:852:1: entryRuleExpressionAnswer returns [EObject current=null] : iv_ruleExpressionAnswer= ruleExpressionAnswer EOF ;
    public final EObject entryRuleExpressionAnswer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAnswer = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:853:2: (iv_ruleExpressionAnswer= ruleExpressionAnswer EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:854:2: iv_ruleExpressionAnswer= ruleExpressionAnswer EOF
            {
             newCompositeNode(grammarAccess.getExpressionAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpressionAnswer_in_entryRuleExpressionAnswer1839);
            iv_ruleExpressionAnswer=ruleExpressionAnswer();

            state._fsp--;

             current =iv_ruleExpressionAnswer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpressionAnswer1849); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionAnswer"


    // $ANTLR start "ruleExpressionAnswer"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:861:1: ruleExpressionAnswer returns [EObject current=null] : (otherlv_0= '=' ( (lv_expression_1_0= ruleEString ) ) (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )? ) ;
    public final EObject ruleExpressionAnswer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expression_1_0 = null;

        AntlrDatatypeRuleToken lv_epsilon_3_0 = null;


         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:864:28: ( (otherlv_0= '=' ( (lv_expression_1_0= ruleEString ) ) (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )? ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:865:1: (otherlv_0= '=' ( (lv_expression_1_0= ruleEString ) ) (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )? )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:865:1: (otherlv_0= '=' ( (lv_expression_1_0= ruleEString ) ) (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )? )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:865:3: otherlv_0= '=' ( (lv_expression_1_0= ruleEString ) ) (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )?
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleExpressionAnswer1886); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionAnswerAccess().getEqualsSignKeyword_0());
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:869:1: ( (lv_expression_1_0= ruleEString ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:870:1: (lv_expression_1_0= ruleEString )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:870:1: (lv_expression_1_0= ruleEString )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:871:3: lv_expression_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAnswerAccess().getExpressionEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleExpressionAnswer1907);
            lv_expression_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionAnswerRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:887:2: (otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:887:4: otherlv_2= '+-' ( (lv_epsilon_3_0= ruleEDouble ) )
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleExpressionAnswer1920); 

                        	newLeafNode(otherlv_2, grammarAccess.getExpressionAnswerAccess().getPlusSignHyphenMinusKeyword_2_0());
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:891:1: ( (lv_epsilon_3_0= ruleEDouble ) )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:892:1: (lv_epsilon_3_0= ruleEDouble )
                    {
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:892:1: (lv_epsilon_3_0= ruleEDouble )
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:893:3: lv_epsilon_3_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressionAnswerAccess().getEpsilonEDoubleParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleExpressionAnswer1941);
                    lv_epsilon_3_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressionAnswerRule());
                    	        }
                           		set(
                           			current, 
                           			"epsilon",
                            		lv_epsilon_3_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionAnswer"


    // $ANTLR start "entryRuleEString"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:917:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:918:2: (iv_ruleEString= ruleEString EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:919:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString1980);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString1991); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:926:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:929:28: (this_STRING_0= RULE_STRING )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:930:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString2030); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:945:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:946:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:947:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble2075);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble2086); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:954:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:957:28: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )? ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:958:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )? )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:958:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )? )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:958:2: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )?
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:958:2: (kw= '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:959:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEDouble2125); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2142); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:971:1: (kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:972:2: kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEDouble2161); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0()); 
                        
                    this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2176); 

                    		current.merge(this_INT_3);
                        
                     
                        newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1()); 
                        
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:984:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=36 && LA23_0<=37)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:984:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                            {
                            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:984:2: (kw= 'E' | kw= 'e' )
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==36) ) {
                                alt21=1;
                            }
                            else if ( (LA21_0==37) ) {
                                alt21=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 21, 0, input);

                                throw nvae;
                            }
                            switch (alt21) {
                                case 1 :
                                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:985:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEDouble2196); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_0()); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:992:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEDouble2215); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_1()); 
                                        

                                    }
                                    break;

                            }

                            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:997:2: (kw= '-' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==34) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:998:2: kw= '-'
                                    {
                                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEDouble2230); 

                                            current.merge(kw);
                                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_2_2_1()); 
                                        

                                    }
                                    break;

                            }

                            this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble2247); 

                            		current.merge(this_INT_7);
                                
                             
                                newLeafNode(this_INT_7, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_2_2()); 
                                

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEInt"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1018:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1019:2: (iv_ruleEInt= ruleEInt EOF )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1020:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt2297);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt2308); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1027:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1030:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1031:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1031:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1031:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1031:2: (kw= '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../qa.xtext/src-gen/qa/xtext/parser/antlr/internal/InternalQa.g:1032:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEInt2347); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt2364); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleQATest_in_entryRuleQATest75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQATest85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleQATest122 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEString_in_ruleQATest143 = new BitSet(new long[]{0x0000000004021042L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_ruleQATest164 = new BitSet(new long[]{0x0000000004020042L});
        public static final BitSet FOLLOW_ruleQAPart_in_ruleQATest186 = new BitSet(new long[]{0x0000000004020042L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_entryRuleQAContainerOptions223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQAContainerOptions233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleQAContainerOptions270 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleQAContainerOptions287 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleQAContainerOptions304 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleQAContainerOptions323 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleQAContainerOptions348 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleQAContainerOptions360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAPart_in_entryRuleQAPart398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQAPart408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuestion_in_ruleQAPart455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQASection_in_ruleQAPart482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnswer_in_entryRuleAnswer517 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnswer527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextAnswer_in_ruleAnswer574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberAnswer_in_ruleAnswer601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleYesNoAnswer_in_ruleAnswer628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionAnswer_in_ruleAnswer655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionAnswer_in_ruleAnswer682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuestion_in_entryRuleQuestion717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuestion727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleQuestion765 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQuestion782 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEString_in_ruleQuestion810 = new BitSet(new long[]{0x00000007C0040050L});
        public static final BitSet FOLLOW_18_in_ruleQuestion823 = new BitSet(new long[]{0x00000007C0040050L});
        public static final BitSet FOLLOW_ruleAnswer_in_ruleQuestion846 = new BitSet(new long[]{0x0000000000980002L});
        public static final BitSet FOLLOW_19_in_ruleQuestion859 = new BitSet(new long[]{0x0000000000900002L});
        public static final BitSet FOLLOW_20_in_ruleQuestion874 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleQuestion886 = new BitSet(new long[]{0x00000007C0040050L});
        public static final BitSet FOLLOW_ruleAnswer_in_ruleQuestion907 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_22_in_ruleQuestion920 = new BitSet(new long[]{0x00000007C0040050L});
        public static final BitSet FOLLOW_ruleAnswer_in_ruleQuestion941 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_ruleNextRule_in_ruleQuestion966 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleNextRule_in_entryRuleNextRule1003 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextRule1013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNextRule1059 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleNextRule1071 = new BitSet(new long[]{0x0000000001000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNextRule1091 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleNextRule1105 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNextRule1122 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleNextRule1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQASection_in_entryRuleQASection1177 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQASection1187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleQASection1224 = new BitSet(new long[]{0x0000000000020040L});
        public static final BitSet FOLLOW_17_in_ruleQASection1237 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQASection1254 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEString_in_ruleQASection1282 = new BitSet(new long[]{0x0000000008001000L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_ruleQASection1303 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleQASection1316 = new BitSet(new long[]{0x0000000010020040L});
        public static final BitSet FOLLOW_ruleQuestion_in_ruleQASection1337 = new BitSet(new long[]{0x0000000010020040L});
        public static final BitSet FOLLOW_28_in_ruleQASection1350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextAnswer_in_entryRuleTextAnswer1386 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextAnswer1396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleTextAnswer1441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberAnswer_in_entryRuleNumberAnswer1476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberAnswer1486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleNumberAnswer1532 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleNumberAnswer1545 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleNumberAnswer1566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleYesNoAnswer_in_entryRuleYesNoAnswer1604 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleYesNoAnswer1614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleYesNoAnswer1661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleYesNoAnswer1686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionAnswer_in_entryRuleOptionAnswer1735 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionAnswer1745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleOptionAnswer1782 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleOptionAnswer1803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionAnswer_in_entryRuleExpressionAnswer1839 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpressionAnswer1849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleExpressionAnswer1886 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEString_in_ruleExpressionAnswer1907 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleExpressionAnswer1920 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleExpressionAnswer1941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1980 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString1991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble2075 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble2086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEDouble2125 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2142 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_35_in_ruleEDouble2161 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2176 = new BitSet(new long[]{0x0000003000000002L});
        public static final BitSet FOLLOW_36_in_ruleEDouble2196 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_37_in_ruleEDouble2215 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_34_in_ruleEDouble2230 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble2247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2297 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt2308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEInt2347 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2364 = new BitSet(new long[]{0x0000000000000002L});
    }


}