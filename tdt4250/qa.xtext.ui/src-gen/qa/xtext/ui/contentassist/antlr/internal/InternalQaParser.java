package qa.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import qa.xtext.services.QaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQaParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'E'", "'e'", "'Title: '", "'try'", "'times'", "'correct'", "'answer'", "'?'", "'!'", "'ID'", "'Candidates'", "':'", "','", "'Next'", "'if'", "'tries'", "'Section'", "'{'", "'}'", "'+-'", "'no'", "'#'", "'='", "'-'", "'.'", "'reveal'", "'yes'"
    };
    public static final int RULE_ID=6;
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
    public static final int RULE_STRING=4;
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
    public static final int RULE_INT=5;
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
    public String getGrammarFileName() { return "../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g"; }


     
     	private QaGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(QaGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleQATest"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:60:1: entryRuleQATest : ruleQATest EOF ;
    public final void entryRuleQATest() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:61:1: ( ruleQATest EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:62:1: ruleQATest EOF
            {
             before(grammarAccess.getQATestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQATest_in_entryRuleQATest61);
            ruleQATest();

            state._fsp--;

             after(grammarAccess.getQATestRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQATest68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQATest"


    // $ANTLR start "ruleQATest"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:69:1: ruleQATest : ( ( rule__QATest__Group__0 ) ) ;
    public final void ruleQATest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:73:2: ( ( ( rule__QATest__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:74:1: ( ( rule__QATest__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:74:1: ( ( rule__QATest__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:75:1: ( rule__QATest__Group__0 )
            {
             before(grammarAccess.getQATestAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:76:1: ( rule__QATest__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:76:2: rule__QATest__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__0_in_ruleQATest94);
            rule__QATest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQATestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQATest"


    // $ANTLR start "entryRuleQAContainerOptions"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:88:1: entryRuleQAContainerOptions : ruleQAContainerOptions EOF ;
    public final void entryRuleQAContainerOptions() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:89:1: ( ruleQAContainerOptions EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:90:1: ruleQAContainerOptions EOF
            {
             before(grammarAccess.getQAContainerOptionsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_entryRuleQAContainerOptions121);
            ruleQAContainerOptions();

            state._fsp--;

             after(grammarAccess.getQAContainerOptionsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQAContainerOptions128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQAContainerOptions"


    // $ANTLR start "ruleQAContainerOptions"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:97:1: ruleQAContainerOptions : ( ( rule__QAContainerOptions__Group__0 ) ) ;
    public final void ruleQAContainerOptions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:101:2: ( ( ( rule__QAContainerOptions__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:102:1: ( ( rule__QAContainerOptions__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:102:1: ( ( rule__QAContainerOptions__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:103:1: ( rule__QAContainerOptions__Group__0 )
            {
             before(grammarAccess.getQAContainerOptionsAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:104:1: ( rule__QAContainerOptions__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:104:2: rule__QAContainerOptions__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__0_in_ruleQAContainerOptions154);
            rule__QAContainerOptions__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQAContainerOptionsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQAContainerOptions"


    // $ANTLR start "entryRuleQAPart"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:116:1: entryRuleQAPart : ruleQAPart EOF ;
    public final void entryRuleQAPart() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:117:1: ( ruleQAPart EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:118:1: ruleQAPart EOF
            {
             before(grammarAccess.getQAPartRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAPart_in_entryRuleQAPart181);
            ruleQAPart();

            state._fsp--;

             after(grammarAccess.getQAPartRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQAPart188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQAPart"


    // $ANTLR start "ruleQAPart"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:125:1: ruleQAPart : ( ( rule__QAPart__Alternatives ) ) ;
    public final void ruleQAPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:129:2: ( ( ( rule__QAPart__Alternatives ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:130:1: ( ( rule__QAPart__Alternatives ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:130:1: ( ( rule__QAPart__Alternatives ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:131:1: ( rule__QAPart__Alternatives )
            {
             before(grammarAccess.getQAPartAccess().getAlternatives()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:132:1: ( rule__QAPart__Alternatives )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:132:2: rule__QAPart__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAPart__Alternatives_in_ruleQAPart214);
            rule__QAPart__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQAPartAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQAPart"


    // $ANTLR start "entryRuleAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:144:1: entryRuleAnswer : ruleAnswer EOF ;
    public final void entryRuleAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:145:1: ( ruleAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:146:1: ruleAnswer EOF
            {
             before(grammarAccess.getAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_entryRuleAnswer241);
            ruleAnswer();

            state._fsp--;

             after(grammarAccess.getAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnswer248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnswer"


    // $ANTLR start "ruleAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:153:1: ruleAnswer : ( ( rule__Answer__Alternatives ) ) ;
    public final void ruleAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:157:2: ( ( ( rule__Answer__Alternatives ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:158:1: ( ( rule__Answer__Alternatives ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:158:1: ( ( rule__Answer__Alternatives ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:159:1: ( rule__Answer__Alternatives )
            {
             before(grammarAccess.getAnswerAccess().getAlternatives()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:160:1: ( rule__Answer__Alternatives )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:160:2: rule__Answer__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Answer__Alternatives_in_ruleAnswer274);
            rule__Answer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAnswerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnswer"


    // $ANTLR start "entryRuleQuestion"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:172:1: entryRuleQuestion : ruleQuestion EOF ;
    public final void entryRuleQuestion() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:173:1: ( ruleQuestion EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:174:1: ruleQuestion EOF
            {
             before(grammarAccess.getQuestionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_entryRuleQuestion301);
            ruleQuestion();

            state._fsp--;

             after(grammarAccess.getQuestionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuestion308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuestion"


    // $ANTLR start "ruleQuestion"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:181:1: ruleQuestion : ( ( rule__Question__Group__0 ) ) ;
    public final void ruleQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:185:2: ( ( ( rule__Question__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:186:1: ( ( rule__Question__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:186:1: ( ( rule__Question__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:187:1: ( rule__Question__Group__0 )
            {
             before(grammarAccess.getQuestionAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:188:1: ( rule__Question__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:188:2: rule__Question__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__0_in_ruleQuestion334);
            rule__Question__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuestion"


    // $ANTLR start "entryRuleNextRule"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:200:1: entryRuleNextRule : ruleNextRule EOF ;
    public final void entryRuleNextRule() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:201:1: ( ruleNextRule EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:202:1: ruleNextRule EOF
            {
             before(grammarAccess.getNextRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNextRule_in_entryRuleNextRule361);
            ruleNextRule();

            state._fsp--;

             after(grammarAccess.getNextRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextRule368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNextRule"


    // $ANTLR start "ruleNextRule"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:209:1: ruleNextRule : ( ( rule__NextRule__Group__0 ) ) ;
    public final void ruleNextRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:213:2: ( ( ( rule__NextRule__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:214:1: ( ( rule__NextRule__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:214:1: ( ( rule__NextRule__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:215:1: ( rule__NextRule__Group__0 )
            {
             before(grammarAccess.getNextRuleAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:216:1: ( rule__NextRule__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:216:2: rule__NextRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__0_in_ruleNextRule394);
            rule__NextRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNextRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNextRule"


    // $ANTLR start "entryRuleQASection"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:228:1: entryRuleQASection : ruleQASection EOF ;
    public final void entryRuleQASection() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:229:1: ( ruleQASection EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:230:1: ruleQASection EOF
            {
             before(grammarAccess.getQASectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQASection_in_entryRuleQASection421);
            ruleQASection();

            state._fsp--;

             after(grammarAccess.getQASectionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQASection428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQASection"


    // $ANTLR start "ruleQASection"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:237:1: ruleQASection : ( ( rule__QASection__Group__0 ) ) ;
    public final void ruleQASection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:241:2: ( ( ( rule__QASection__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:242:1: ( ( rule__QASection__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:242:1: ( ( rule__QASection__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:243:1: ( rule__QASection__Group__0 )
            {
             before(grammarAccess.getQASectionAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:244:1: ( rule__QASection__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:244:2: rule__QASection__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__0_in_ruleQASection454);
            rule__QASection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQASectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQASection"


    // $ANTLR start "entryRuleTextAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:256:1: entryRuleTextAnswer : ruleTextAnswer EOF ;
    public final void entryRuleTextAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:257:1: ( ruleTextAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:258:1: ruleTextAnswer EOF
            {
             before(grammarAccess.getTextAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTextAnswer_in_entryRuleTextAnswer481);
            ruleTextAnswer();

            state._fsp--;

             after(grammarAccess.getTextAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextAnswer488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextAnswer"


    // $ANTLR start "ruleTextAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:265:1: ruleTextAnswer : ( ( rule__TextAnswer__TextAssignment ) ) ;
    public final void ruleTextAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:269:2: ( ( ( rule__TextAnswer__TextAssignment ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:270:1: ( ( rule__TextAnswer__TextAssignment ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:270:1: ( ( rule__TextAnswer__TextAssignment ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:271:1: ( rule__TextAnswer__TextAssignment )
            {
             before(grammarAccess.getTextAnswerAccess().getTextAssignment()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:272:1: ( rule__TextAnswer__TextAssignment )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:272:2: rule__TextAnswer__TextAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TextAnswer__TextAssignment_in_ruleTextAnswer514);
            rule__TextAnswer__TextAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextAnswerAccess().getTextAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextAnswer"


    // $ANTLR start "entryRuleNumberAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:284:1: entryRuleNumberAnswer : ruleNumberAnswer EOF ;
    public final void entryRuleNumberAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:285:1: ( ruleNumberAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:286:1: ruleNumberAnswer EOF
            {
             before(grammarAccess.getNumberAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumberAnswer_in_entryRuleNumberAnswer541);
            ruleNumberAnswer();

            state._fsp--;

             after(grammarAccess.getNumberAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberAnswer548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberAnswer"


    // $ANTLR start "ruleNumberAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:293:1: ruleNumberAnswer : ( ( rule__NumberAnswer__Group__0 ) ) ;
    public final void ruleNumberAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:297:2: ( ( ( rule__NumberAnswer__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:298:1: ( ( rule__NumberAnswer__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:298:1: ( ( rule__NumberAnswer__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:299:1: ( rule__NumberAnswer__Group__0 )
            {
             before(grammarAccess.getNumberAnswerAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:300:1: ( rule__NumberAnswer__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:300:2: rule__NumberAnswer__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group__0_in_ruleNumberAnswer574);
            rule__NumberAnswer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumberAnswerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberAnswer"


    // $ANTLR start "entryRuleYesNoAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:312:1: entryRuleYesNoAnswer : ruleYesNoAnswer EOF ;
    public final void entryRuleYesNoAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:313:1: ( ruleYesNoAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:314:1: ruleYesNoAnswer EOF
            {
             before(grammarAccess.getYesNoAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleYesNoAnswer_in_entryRuleYesNoAnswer601);
            ruleYesNoAnswer();

            state._fsp--;

             after(grammarAccess.getYesNoAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleYesNoAnswer608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleYesNoAnswer"


    // $ANTLR start "ruleYesNoAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:321:1: ruleYesNoAnswer : ( ( rule__YesNoAnswer__Alternatives ) ) ;
    public final void ruleYesNoAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:325:2: ( ( ( rule__YesNoAnswer__Alternatives ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:326:1: ( ( rule__YesNoAnswer__Alternatives ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:326:1: ( ( rule__YesNoAnswer__Alternatives ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:327:1: ( rule__YesNoAnswer__Alternatives )
            {
             before(grammarAccess.getYesNoAnswerAccess().getAlternatives()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:328:1: ( rule__YesNoAnswer__Alternatives )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:328:2: rule__YesNoAnswer__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__Alternatives_in_ruleYesNoAnswer634);
            rule__YesNoAnswer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getYesNoAnswerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleYesNoAnswer"


    // $ANTLR start "entryRuleOptionAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:340:1: entryRuleOptionAnswer : ruleOptionAnswer EOF ;
    public final void entryRuleOptionAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:341:1: ( ruleOptionAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:342:1: ruleOptionAnswer EOF
            {
             before(grammarAccess.getOptionAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionAnswer_in_entryRuleOptionAnswer661);
            ruleOptionAnswer();

            state._fsp--;

             after(grammarAccess.getOptionAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionAnswer668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptionAnswer"


    // $ANTLR start "ruleOptionAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:349:1: ruleOptionAnswer : ( ( rule__OptionAnswer__Group__0 ) ) ;
    public final void ruleOptionAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:353:2: ( ( ( rule__OptionAnswer__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:354:1: ( ( rule__OptionAnswer__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:354:1: ( ( rule__OptionAnswer__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:355:1: ( rule__OptionAnswer__Group__0 )
            {
             before(grammarAccess.getOptionAnswerAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:356:1: ( rule__OptionAnswer__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:356:2: rule__OptionAnswer__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OptionAnswer__Group__0_in_ruleOptionAnswer694);
            rule__OptionAnswer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionAnswerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptionAnswer"


    // $ANTLR start "entryRuleExpressionAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:368:1: entryRuleExpressionAnswer : ruleExpressionAnswer EOF ;
    public final void entryRuleExpressionAnswer() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:369:1: ( ruleExpressionAnswer EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:370:1: ruleExpressionAnswer EOF
            {
             before(grammarAccess.getExpressionAnswerRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpressionAnswer_in_entryRuleExpressionAnswer721);
            ruleExpressionAnswer();

            state._fsp--;

             after(grammarAccess.getExpressionAnswerRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpressionAnswer728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionAnswer"


    // $ANTLR start "ruleExpressionAnswer"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:377:1: ruleExpressionAnswer : ( ( rule__ExpressionAnswer__Group__0 ) ) ;
    public final void ruleExpressionAnswer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:381:2: ( ( ( rule__ExpressionAnswer__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:382:1: ( ( rule__ExpressionAnswer__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:382:1: ( ( rule__ExpressionAnswer__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:383:1: ( rule__ExpressionAnswer__Group__0 )
            {
             before(grammarAccess.getExpressionAnswerAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:384:1: ( rule__ExpressionAnswer__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:384:2: rule__ExpressionAnswer__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__0_in_ruleExpressionAnswer754);
            rule__ExpressionAnswer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAnswerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionAnswer"


    // $ANTLR start "entryRuleEString"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:396:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:397:1: ( ruleEString EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:398:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString781);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString788); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:405:1: ruleEString : ( RULE_STRING ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:409:2: ( ( RULE_STRING ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:410:1: ( RULE_STRING )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:410:1: ( RULE_STRING )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:411:1: RULE_STRING
            {
             before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString814); 
             after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:424:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:425:1: ( ruleEDouble EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:426:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble840);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble847); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:433:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:437:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:438:1: ( ( rule__EDouble__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:438:1: ( ( rule__EDouble__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:439:1: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:440:1: ( rule__EDouble__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:440:2: rule__EDouble__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__0_in_ruleEDouble873);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEInt"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:452:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:453:1: ( ruleEInt EOF )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:454:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt900);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt907); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:461:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:465:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:466:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:466:1: ( ( rule__EInt__Group__0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:467:1: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:468:1: ( rule__EInt__Group__0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:468:2: rule__EInt__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EInt__Group__0_in_ruleEInt933);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "rule__QAPart__Alternatives"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:480:1: rule__QAPart__Alternatives : ( ( ruleQuestion ) | ( ruleQASection ) );
    public final void rule__QAPart__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:484:1: ( ( ruleQuestion ) | ( ruleQASection ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING||LA1_0==20) ) {
                alt1=1;
            }
            else if ( (LA1_0==27) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:485:1: ( ruleQuestion )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:485:1: ( ruleQuestion )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:486:1: ruleQuestion
                    {
                     before(grammarAccess.getQAPartAccess().getQuestionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_rule__QAPart__Alternatives969);
                    ruleQuestion();

                    state._fsp--;

                     after(grammarAccess.getQAPartAccess().getQuestionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:491:6: ( ruleQASection )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:491:6: ( ruleQASection )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:492:1: ruleQASection
                    {
                     before(grammarAccess.getQAPartAccess().getQASectionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleQASection_in_rule__QAPart__Alternatives986);
                    ruleQASection();

                    state._fsp--;

                     after(grammarAccess.getQAPartAccess().getQASectionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAPart__Alternatives"


    // $ANTLR start "rule__Answer__Alternatives"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:502:1: rule__Answer__Alternatives : ( ( ruleTextAnswer ) | ( ruleNumberAnswer ) | ( ruleYesNoAnswer ) | ( ruleOptionAnswer ) | ( ruleExpressionAnswer ) );
    public final void rule__Answer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:506:1: ( ( ruleTextAnswer ) | ( ruleNumberAnswer ) | ( ruleYesNoAnswer ) | ( ruleOptionAnswer ) | ( ruleExpressionAnswer ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
            case 34:
                {
                alt2=2;
                }
                break;
            case 31:
            case 37:
                {
                alt2=3;
                }
                break;
            case 32:
                {
                alt2=4;
                }
                break;
            case 33:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:507:1: ( ruleTextAnswer )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:507:1: ( ruleTextAnswer )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:508:1: ruleTextAnswer
                    {
                     before(grammarAccess.getAnswerAccess().getTextAnswerParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTextAnswer_in_rule__Answer__Alternatives1018);
                    ruleTextAnswer();

                    state._fsp--;

                     after(grammarAccess.getAnswerAccess().getTextAnswerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:513:6: ( ruleNumberAnswer )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:513:6: ( ruleNumberAnswer )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:514:1: ruleNumberAnswer
                    {
                     before(grammarAccess.getAnswerAccess().getNumberAnswerParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNumberAnswer_in_rule__Answer__Alternatives1035);
                    ruleNumberAnswer();

                    state._fsp--;

                     after(grammarAccess.getAnswerAccess().getNumberAnswerParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:519:6: ( ruleYesNoAnswer )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:519:6: ( ruleYesNoAnswer )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:520:1: ruleYesNoAnswer
                    {
                     before(grammarAccess.getAnswerAccess().getYesNoAnswerParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleYesNoAnswer_in_rule__Answer__Alternatives1052);
                    ruleYesNoAnswer();

                    state._fsp--;

                     after(grammarAccess.getAnswerAccess().getYesNoAnswerParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:525:6: ( ruleOptionAnswer )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:525:6: ( ruleOptionAnswer )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:526:1: ruleOptionAnswer
                    {
                     before(grammarAccess.getAnswerAccess().getOptionAnswerParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleOptionAnswer_in_rule__Answer__Alternatives1069);
                    ruleOptionAnswer();

                    state._fsp--;

                     after(grammarAccess.getAnswerAccess().getOptionAnswerParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:531:6: ( ruleExpressionAnswer )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:531:6: ( ruleExpressionAnswer )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:532:1: ruleExpressionAnswer
                    {
                     before(grammarAccess.getAnswerAccess().getExpressionAnswerParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleExpressionAnswer_in_rule__Answer__Alternatives1086);
                    ruleExpressionAnswer();

                    state._fsp--;

                     after(grammarAccess.getAnswerAccess().getExpressionAnswerParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Answer__Alternatives"


    // $ANTLR start "rule__YesNoAnswer__Alternatives"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:542:1: rule__YesNoAnswer__Alternatives : ( ( ( rule__YesNoAnswer__Group_0__0 ) ) | ( ( rule__YesNoAnswer__YesAssignment_1 ) ) );
    public final void rule__YesNoAnswer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:546:1: ( ( ( rule__YesNoAnswer__Group_0__0 ) ) | ( ( rule__YesNoAnswer__YesAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==31) ) {
                alt3=1;
            }
            else if ( (LA3_0==37) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:547:1: ( ( rule__YesNoAnswer__Group_0__0 ) )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:547:1: ( ( rule__YesNoAnswer__Group_0__0 ) )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:548:1: ( rule__YesNoAnswer__Group_0__0 )
                    {
                     before(grammarAccess.getYesNoAnswerAccess().getGroup_0()); 
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:549:1: ( rule__YesNoAnswer__Group_0__0 )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:549:2: rule__YesNoAnswer__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__Group_0__0_in_rule__YesNoAnswer__Alternatives1118);
                    rule__YesNoAnswer__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getYesNoAnswerAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:553:6: ( ( rule__YesNoAnswer__YesAssignment_1 ) )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:553:6: ( ( rule__YesNoAnswer__YesAssignment_1 ) )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:554:1: ( rule__YesNoAnswer__YesAssignment_1 )
                    {
                     before(grammarAccess.getYesNoAnswerAccess().getYesAssignment_1()); 
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:555:1: ( rule__YesNoAnswer__YesAssignment_1 )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:555:2: rule__YesNoAnswer__YesAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__YesAssignment_1_in_rule__YesNoAnswer__Alternatives1136);
                    rule__YesNoAnswer__YesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getYesNoAnswerAccess().getYesAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__Alternatives"


    // $ANTLR start "rule__EDouble__Alternatives_2_2_0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:564:1: rule__EDouble__Alternatives_2_2_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:568:1: ( ( 'E' ) | ( 'e' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:569:1: ( 'E' )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:569:1: ( 'E' )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:570:1: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__EDouble__Alternatives_2_2_01170); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:577:6: ( 'e' )
                    {
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:577:6: ( 'e' )
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:578:1: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__EDouble__Alternatives_2_2_01190); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_2_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Alternatives_2_2_0"


    // $ANTLR start "rule__QATest__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:592:1: rule__QATest__Group__0 : rule__QATest__Group__0__Impl rule__QATest__Group__1 ;
    public final void rule__QATest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:596:1: ( rule__QATest__Group__0__Impl rule__QATest__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:597:2: rule__QATest__Group__0__Impl rule__QATest__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__0__Impl_in_rule__QATest__Group__01222);
            rule__QATest__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__1_in_rule__QATest__Group__01225);
            rule__QATest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__0"


    // $ANTLR start "rule__QATest__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:604:1: rule__QATest__Group__0__Impl : ( 'Title: ' ) ;
    public final void rule__QATest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:608:1: ( ( 'Title: ' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:609:1: ( 'Title: ' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:609:1: ( 'Title: ' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:610:1: 'Title: '
            {
             before(grammarAccess.getQATestAccess().getTitleKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__QATest__Group__0__Impl1253); 
             after(grammarAccess.getQATestAccess().getTitleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__0__Impl"


    // $ANTLR start "rule__QATest__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:623:1: rule__QATest__Group__1 : rule__QATest__Group__1__Impl rule__QATest__Group__2 ;
    public final void rule__QATest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:627:1: ( rule__QATest__Group__1__Impl rule__QATest__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:628:2: rule__QATest__Group__1__Impl rule__QATest__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__1__Impl_in_rule__QATest__Group__11284);
            rule__QATest__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__2_in_rule__QATest__Group__11287);
            rule__QATest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__1"


    // $ANTLR start "rule__QATest__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:635:1: rule__QATest__Group__1__Impl : ( ( rule__QATest__TitleAssignment_1 ) ) ;
    public final void rule__QATest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:639:1: ( ( ( rule__QATest__TitleAssignment_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:640:1: ( ( rule__QATest__TitleAssignment_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:640:1: ( ( rule__QATest__TitleAssignment_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:641:1: ( rule__QATest__TitleAssignment_1 )
            {
             before(grammarAccess.getQATestAccess().getTitleAssignment_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:642:1: ( rule__QATest__TitleAssignment_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:642:2: rule__QATest__TitleAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__TitleAssignment_1_in_rule__QATest__Group__1__Impl1314);
            rule__QATest__TitleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQATestAccess().getTitleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__1__Impl"


    // $ANTLR start "rule__QATest__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:652:1: rule__QATest__Group__2 : rule__QATest__Group__2__Impl rule__QATest__Group__3 ;
    public final void rule__QATest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:656:1: ( rule__QATest__Group__2__Impl rule__QATest__Group__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:657:2: rule__QATest__Group__2__Impl rule__QATest__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__2__Impl_in_rule__QATest__Group__21344);
            rule__QATest__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__3_in_rule__QATest__Group__21347);
            rule__QATest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__2"


    // $ANTLR start "rule__QATest__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:664:1: rule__QATest__Group__2__Impl : ( ( rule__QATest__OptionsAssignment_2 )? ) ;
    public final void rule__QATest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:668:1: ( ( ( rule__QATest__OptionsAssignment_2 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:669:1: ( ( rule__QATest__OptionsAssignment_2 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:669:1: ( ( rule__QATest__OptionsAssignment_2 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:670:1: ( rule__QATest__OptionsAssignment_2 )?
            {
             before(grammarAccess.getQATestAccess().getOptionsAssignment_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:671:1: ( rule__QATest__OptionsAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:671:2: rule__QATest__OptionsAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__QATest__OptionsAssignment_2_in_rule__QATest__Group__2__Impl1374);
                    rule__QATest__OptionsAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQATestAccess().getOptionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__2__Impl"


    // $ANTLR start "rule__QATest__Group__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:681:1: rule__QATest__Group__3 : rule__QATest__Group__3__Impl ;
    public final void rule__QATest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:685:1: ( rule__QATest__Group__3__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:686:2: rule__QATest__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QATest__Group__3__Impl_in_rule__QATest__Group__31405);
            rule__QATest__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__3"


    // $ANTLR start "rule__QATest__Group__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:692:1: rule__QATest__Group__3__Impl : ( ( rule__QATest__PartsAssignment_3 )* ) ;
    public final void rule__QATest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:696:1: ( ( ( rule__QATest__PartsAssignment_3 )* ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:697:1: ( ( rule__QATest__PartsAssignment_3 )* )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:697:1: ( ( rule__QATest__PartsAssignment_3 )* )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:698:1: ( rule__QATest__PartsAssignment_3 )*
            {
             before(grammarAccess.getQATestAccess().getPartsAssignment_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:699:1: ( rule__QATest__PartsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_STRING||LA6_0==20||LA6_0==27) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:699:2: rule__QATest__PartsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QATest__PartsAssignment_3_in_rule__QATest__Group__3__Impl1432);
            	    rule__QATest__PartsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getQATestAccess().getPartsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__Group__3__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:717:1: rule__QAContainerOptions__Group__0 : rule__QAContainerOptions__Group__0__Impl rule__QAContainerOptions__Group__1 ;
    public final void rule__QAContainerOptions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:721:1: ( rule__QAContainerOptions__Group__0__Impl rule__QAContainerOptions__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:722:2: rule__QAContainerOptions__Group__0__Impl rule__QAContainerOptions__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__0__Impl_in_rule__QAContainerOptions__Group__01471);
            rule__QAContainerOptions__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__1_in_rule__QAContainerOptions__Group__01474);
            rule__QAContainerOptions__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__0"


    // $ANTLR start "rule__QAContainerOptions__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:729:1: rule__QAContainerOptions__Group__0__Impl : ( 'try' ) ;
    public final void rule__QAContainerOptions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:733:1: ( ( 'try' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:734:1: ( 'try' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:734:1: ( 'try' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:735:1: 'try'
            {
             before(grammarAccess.getQAContainerOptionsAccess().getTryKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__QAContainerOptions__Group__0__Impl1502); 
             after(grammarAccess.getQAContainerOptionsAccess().getTryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__0__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:748:1: rule__QAContainerOptions__Group__1 : rule__QAContainerOptions__Group__1__Impl rule__QAContainerOptions__Group__2 ;
    public final void rule__QAContainerOptions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:752:1: ( rule__QAContainerOptions__Group__1__Impl rule__QAContainerOptions__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:753:2: rule__QAContainerOptions__Group__1__Impl rule__QAContainerOptions__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__1__Impl_in_rule__QAContainerOptions__Group__11533);
            rule__QAContainerOptions__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__2_in_rule__QAContainerOptions__Group__11536);
            rule__QAContainerOptions__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__1"


    // $ANTLR start "rule__QAContainerOptions__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:760:1: rule__QAContainerOptions__Group__1__Impl : ( ( rule__QAContainerOptions__MaxTriesAssignment_1 ) ) ;
    public final void rule__QAContainerOptions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:764:1: ( ( ( rule__QAContainerOptions__MaxTriesAssignment_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:765:1: ( ( rule__QAContainerOptions__MaxTriesAssignment_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:765:1: ( ( rule__QAContainerOptions__MaxTriesAssignment_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:766:1: ( rule__QAContainerOptions__MaxTriesAssignment_1 )
            {
             before(grammarAccess.getQAContainerOptionsAccess().getMaxTriesAssignment_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:767:1: ( rule__QAContainerOptions__MaxTriesAssignment_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:767:2: rule__QAContainerOptions__MaxTriesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__MaxTriesAssignment_1_in_rule__QAContainerOptions__Group__1__Impl1563);
            rule__QAContainerOptions__MaxTriesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQAContainerOptionsAccess().getMaxTriesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__1__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:777:1: rule__QAContainerOptions__Group__2 : rule__QAContainerOptions__Group__2__Impl rule__QAContainerOptions__Group__3 ;
    public final void rule__QAContainerOptions__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:781:1: ( rule__QAContainerOptions__Group__2__Impl rule__QAContainerOptions__Group__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:782:2: rule__QAContainerOptions__Group__2__Impl rule__QAContainerOptions__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__2__Impl_in_rule__QAContainerOptions__Group__21593);
            rule__QAContainerOptions__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__3_in_rule__QAContainerOptions__Group__21596);
            rule__QAContainerOptions__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__2"


    // $ANTLR start "rule__QAContainerOptions__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:789:1: rule__QAContainerOptions__Group__2__Impl : ( 'times' ) ;
    public final void rule__QAContainerOptions__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:793:1: ( ( 'times' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:794:1: ( 'times' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:794:1: ( 'times' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:795:1: 'times'
            {
             before(grammarAccess.getQAContainerOptionsAccess().getTimesKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__QAContainerOptions__Group__2__Impl1624); 
             after(grammarAccess.getQAContainerOptionsAccess().getTimesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__2__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:808:1: rule__QAContainerOptions__Group__3 : rule__QAContainerOptions__Group__3__Impl ;
    public final void rule__QAContainerOptions__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:812:1: ( rule__QAContainerOptions__Group__3__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:813:2: rule__QAContainerOptions__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group__3__Impl_in_rule__QAContainerOptions__Group__31655);
            rule__QAContainerOptions__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__3"


    // $ANTLR start "rule__QAContainerOptions__Group__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:819:1: rule__QAContainerOptions__Group__3__Impl : ( ( rule__QAContainerOptions__Group_3__0 )? ) ;
    public final void rule__QAContainerOptions__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:823:1: ( ( ( rule__QAContainerOptions__Group_3__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:824:1: ( ( rule__QAContainerOptions__Group_3__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:824:1: ( ( rule__QAContainerOptions__Group_3__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:825:1: ( rule__QAContainerOptions__Group_3__0 )?
            {
             before(grammarAccess.getQAContainerOptionsAccess().getGroup_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:826:1: ( rule__QAContainerOptions__Group_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==36) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:826:2: rule__QAContainerOptions__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__0_in_rule__QAContainerOptions__Group__3__Impl1682);
                    rule__QAContainerOptions__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQAContainerOptionsAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group__3__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group_3__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:844:1: rule__QAContainerOptions__Group_3__0 : rule__QAContainerOptions__Group_3__0__Impl rule__QAContainerOptions__Group_3__1 ;
    public final void rule__QAContainerOptions__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:848:1: ( rule__QAContainerOptions__Group_3__0__Impl rule__QAContainerOptions__Group_3__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:849:2: rule__QAContainerOptions__Group_3__0__Impl rule__QAContainerOptions__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__0__Impl_in_rule__QAContainerOptions__Group_3__01721);
            rule__QAContainerOptions__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__1_in_rule__QAContainerOptions__Group_3__01724);
            rule__QAContainerOptions__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__0"


    // $ANTLR start "rule__QAContainerOptions__Group_3__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:856:1: rule__QAContainerOptions__Group_3__0__Impl : ( ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 ) ) ;
    public final void rule__QAContainerOptions__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:860:1: ( ( ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:861:1: ( ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:861:1: ( ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:862:1: ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 )
            {
             before(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerAssignment_3_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:863:1: ( rule__QAContainerOptions__RevealAnswerAssignment_3_0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:863:2: rule__QAContainerOptions__RevealAnswerAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__RevealAnswerAssignment_3_0_in_rule__QAContainerOptions__Group_3__0__Impl1751);
            rule__QAContainerOptions__RevealAnswerAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__0__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group_3__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:873:1: rule__QAContainerOptions__Group_3__1 : rule__QAContainerOptions__Group_3__1__Impl rule__QAContainerOptions__Group_3__2 ;
    public final void rule__QAContainerOptions__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:877:1: ( rule__QAContainerOptions__Group_3__1__Impl rule__QAContainerOptions__Group_3__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:878:2: rule__QAContainerOptions__Group_3__1__Impl rule__QAContainerOptions__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__1__Impl_in_rule__QAContainerOptions__Group_3__11781);
            rule__QAContainerOptions__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__2_in_rule__QAContainerOptions__Group_3__11784);
            rule__QAContainerOptions__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__1"


    // $ANTLR start "rule__QAContainerOptions__Group_3__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:885:1: rule__QAContainerOptions__Group_3__1__Impl : ( 'correct' ) ;
    public final void rule__QAContainerOptions__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:889:1: ( ( 'correct' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:890:1: ( 'correct' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:890:1: ( 'correct' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:891:1: 'correct'
            {
             before(grammarAccess.getQAContainerOptionsAccess().getCorrectKeyword_3_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__QAContainerOptions__Group_3__1__Impl1812); 
             after(grammarAccess.getQAContainerOptionsAccess().getCorrectKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__1__Impl"


    // $ANTLR start "rule__QAContainerOptions__Group_3__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:904:1: rule__QAContainerOptions__Group_3__2 : rule__QAContainerOptions__Group_3__2__Impl ;
    public final void rule__QAContainerOptions__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:908:1: ( rule__QAContainerOptions__Group_3__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:909:2: rule__QAContainerOptions__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QAContainerOptions__Group_3__2__Impl_in_rule__QAContainerOptions__Group_3__21843);
            rule__QAContainerOptions__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__2"


    // $ANTLR start "rule__QAContainerOptions__Group_3__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:915:1: rule__QAContainerOptions__Group_3__2__Impl : ( 'answer' ) ;
    public final void rule__QAContainerOptions__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:919:1: ( ( 'answer' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:920:1: ( 'answer' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:920:1: ( 'answer' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:921:1: 'answer'
            {
             before(grammarAccess.getQAContainerOptionsAccess().getAnswerKeyword_3_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__QAContainerOptions__Group_3__2__Impl1871); 
             after(grammarAccess.getQAContainerOptionsAccess().getAnswerKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__Group_3__2__Impl"


    // $ANTLR start "rule__Question__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:940:1: rule__Question__Group__0 : rule__Question__Group__0__Impl rule__Question__Group__1 ;
    public final void rule__Question__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:944:1: ( rule__Question__Group__0__Impl rule__Question__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:945:2: rule__Question__Group__0__Impl rule__Question__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__0__Impl_in_rule__Question__Group__01908);
            rule__Question__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__1_in_rule__Question__Group__01911);
            rule__Question__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__0"


    // $ANTLR start "rule__Question__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:952:1: rule__Question__Group__0__Impl : ( ( rule__Question__Group_0__0 )? ) ;
    public final void rule__Question__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:956:1: ( ( ( rule__Question__Group_0__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:957:1: ( ( rule__Question__Group_0__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:957:1: ( ( rule__Question__Group_0__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:958:1: ( rule__Question__Group_0__0 )?
            {
             before(grammarAccess.getQuestionAccess().getGroup_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:959:1: ( rule__Question__Group_0__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:959:2: rule__Question__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Question__Group_0__0_in_rule__Question__Group__0__Impl1938);
                    rule__Question__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuestionAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__0__Impl"


    // $ANTLR start "rule__Question__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:969:1: rule__Question__Group__1 : rule__Question__Group__1__Impl rule__Question__Group__2 ;
    public final void rule__Question__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:973:1: ( rule__Question__Group__1__Impl rule__Question__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:974:2: rule__Question__Group__1__Impl rule__Question__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__1__Impl_in_rule__Question__Group__11969);
            rule__Question__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__2_in_rule__Question__Group__11972);
            rule__Question__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__1"


    // $ANTLR start "rule__Question__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:981:1: rule__Question__Group__1__Impl : ( ( rule__Question__TextAssignment_1 ) ) ;
    public final void rule__Question__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:985:1: ( ( ( rule__Question__TextAssignment_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:986:1: ( ( rule__Question__TextAssignment_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:986:1: ( ( rule__Question__TextAssignment_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:987:1: ( rule__Question__TextAssignment_1 )
            {
             before(grammarAccess.getQuestionAccess().getTextAssignment_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:988:1: ( rule__Question__TextAssignment_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:988:2: rule__Question__TextAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__TextAssignment_1_in_rule__Question__Group__1__Impl1999);
            rule__Question__TextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getTextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__1__Impl"


    // $ANTLR start "rule__Question__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:998:1: rule__Question__Group__2 : rule__Question__Group__2__Impl rule__Question__Group__3 ;
    public final void rule__Question__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1002:1: ( rule__Question__Group__2__Impl rule__Question__Group__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1003:2: rule__Question__Group__2__Impl rule__Question__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__2__Impl_in_rule__Question__Group__22029);
            rule__Question__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__3_in_rule__Question__Group__22032);
            rule__Question__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__2"


    // $ANTLR start "rule__Question__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1010:1: rule__Question__Group__2__Impl : ( ( '?' )? ) ;
    public final void rule__Question__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1014:1: ( ( ( '?' )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1015:1: ( ( '?' )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1015:1: ( ( '?' )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1016:1: ( '?' )?
            {
             before(grammarAccess.getQuestionAccess().getQuestionMarkKeyword_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1017:1: ( '?' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1018:2: '?'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__Question__Group__2__Impl2061); 

                    }
                    break;

            }

             after(grammarAccess.getQuestionAccess().getQuestionMarkKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__2__Impl"


    // $ANTLR start "rule__Question__Group__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1029:1: rule__Question__Group__3 : rule__Question__Group__3__Impl rule__Question__Group__4 ;
    public final void rule__Question__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1033:1: ( rule__Question__Group__3__Impl rule__Question__Group__4 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1034:2: rule__Question__Group__3__Impl rule__Question__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__3__Impl_in_rule__Question__Group__32094);
            rule__Question__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__4_in_rule__Question__Group__32097);
            rule__Question__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__3"


    // $ANTLR start "rule__Question__Group__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1041:1: rule__Question__Group__3__Impl : ( ( rule__Question__CorrectAssignment_3 ) ) ;
    public final void rule__Question__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1045:1: ( ( ( rule__Question__CorrectAssignment_3 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1046:1: ( ( rule__Question__CorrectAssignment_3 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1046:1: ( ( rule__Question__CorrectAssignment_3 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1047:1: ( rule__Question__CorrectAssignment_3 )
            {
             before(grammarAccess.getQuestionAccess().getCorrectAssignment_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1048:1: ( rule__Question__CorrectAssignment_3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1048:2: rule__Question__CorrectAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__CorrectAssignment_3_in_rule__Question__Group__3__Impl2124);
            rule__Question__CorrectAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getCorrectAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__3__Impl"


    // $ANTLR start "rule__Question__Group__4"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1058:1: rule__Question__Group__4 : rule__Question__Group__4__Impl rule__Question__Group__5 ;
    public final void rule__Question__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1062:1: ( rule__Question__Group__4__Impl rule__Question__Group__5 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1063:2: rule__Question__Group__4__Impl rule__Question__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__4__Impl_in_rule__Question__Group__42154);
            rule__Question__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__5_in_rule__Question__Group__42157);
            rule__Question__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__4"


    // $ANTLR start "rule__Question__Group__4__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1070:1: rule__Question__Group__4__Impl : ( ( '!' )? ) ;
    public final void rule__Question__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1074:1: ( ( ( '!' )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1075:1: ( ( '!' )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1075:1: ( ( '!' )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1076:1: ( '!' )?
            {
             before(grammarAccess.getQuestionAccess().getExclamationMarkKeyword_4()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1077:1: ( '!' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1078:2: '!'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__Question__Group__4__Impl2186); 

                    }
                    break;

            }

             after(grammarAccess.getQuestionAccess().getExclamationMarkKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__4__Impl"


    // $ANTLR start "rule__Question__Group__5"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1089:1: rule__Question__Group__5 : rule__Question__Group__5__Impl rule__Question__Group__6 ;
    public final void rule__Question__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1093:1: ( rule__Question__Group__5__Impl rule__Question__Group__6 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1094:2: rule__Question__Group__5__Impl rule__Question__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__5__Impl_in_rule__Question__Group__52219);
            rule__Question__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__6_in_rule__Question__Group__52222);
            rule__Question__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__5"


    // $ANTLR start "rule__Question__Group__5__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1101:1: rule__Question__Group__5__Impl : ( ( rule__Question__Group_5__0 )? ) ;
    public final void rule__Question__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1105:1: ( ( ( rule__Question__Group_5__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1106:1: ( ( rule__Question__Group_5__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1106:1: ( ( rule__Question__Group_5__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1107:1: ( rule__Question__Group_5__0 )?
            {
             before(grammarAccess.getQuestionAccess().getGroup_5()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1108:1: ( rule__Question__Group_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1108:2: rule__Question__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__0_in_rule__Question__Group__5__Impl2249);
                    rule__Question__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuestionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__5__Impl"


    // $ANTLR start "rule__Question__Group__6"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1118:1: rule__Question__Group__6 : rule__Question__Group__6__Impl ;
    public final void rule__Question__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1122:1: ( rule__Question__Group__6__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1123:2: rule__Question__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group__6__Impl_in_rule__Question__Group__62280);
            rule__Question__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__6"


    // $ANTLR start "rule__Question__Group__6__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1129:1: rule__Question__Group__6__Impl : ( ( rule__Question__NextRulesAssignment_6 )* ) ;
    public final void rule__Question__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1133:1: ( ( ( rule__Question__NextRulesAssignment_6 )* ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1134:1: ( ( rule__Question__NextRulesAssignment_6 )* )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1134:1: ( ( rule__Question__NextRulesAssignment_6 )* )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1135:1: ( rule__Question__NextRulesAssignment_6 )*
            {
             before(grammarAccess.getQuestionAccess().getNextRulesAssignment_6()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1136:1: ( rule__Question__NextRulesAssignment_6 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1136:2: rule__Question__NextRulesAssignment_6
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Question__NextRulesAssignment_6_in_rule__Question__Group__6__Impl2307);
            	    rule__Question__NextRulesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getQuestionAccess().getNextRulesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group__6__Impl"


    // $ANTLR start "rule__Question__Group_0__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1160:1: rule__Question__Group_0__0 : rule__Question__Group_0__0__Impl rule__Question__Group_0__1 ;
    public final void rule__Question__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1164:1: ( rule__Question__Group_0__0__Impl rule__Question__Group_0__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1165:2: rule__Question__Group_0__0__Impl rule__Question__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_0__0__Impl_in_rule__Question__Group_0__02352);
            rule__Question__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_0__1_in_rule__Question__Group_0__02355);
            rule__Question__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_0__0"


    // $ANTLR start "rule__Question__Group_0__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1172:1: rule__Question__Group_0__0__Impl : ( 'ID' ) ;
    public final void rule__Question__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1176:1: ( ( 'ID' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1177:1: ( 'ID' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1177:1: ( 'ID' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1178:1: 'ID'
            {
             before(grammarAccess.getQuestionAccess().getIDKeyword_0_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Question__Group_0__0__Impl2383); 
             after(grammarAccess.getQuestionAccess().getIDKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_0__0__Impl"


    // $ANTLR start "rule__Question__Group_0__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1191:1: rule__Question__Group_0__1 : rule__Question__Group_0__1__Impl ;
    public final void rule__Question__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1195:1: ( rule__Question__Group_0__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1196:2: rule__Question__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_0__1__Impl_in_rule__Question__Group_0__12414);
            rule__Question__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_0__1"


    // $ANTLR start "rule__Question__Group_0__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1202:1: rule__Question__Group_0__1__Impl : ( ( rule__Question__NameAssignment_0_1 ) ) ;
    public final void rule__Question__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1206:1: ( ( ( rule__Question__NameAssignment_0_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1207:1: ( ( rule__Question__NameAssignment_0_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1207:1: ( ( rule__Question__NameAssignment_0_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1208:1: ( rule__Question__NameAssignment_0_1 )
            {
             before(grammarAccess.getQuestionAccess().getNameAssignment_0_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1209:1: ( rule__Question__NameAssignment_0_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1209:2: rule__Question__NameAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__NameAssignment_0_1_in_rule__Question__Group_0__1__Impl2441);
            rule__Question__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_0__1__Impl"


    // $ANTLR start "rule__Question__Group_5__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1223:1: rule__Question__Group_5__0 : rule__Question__Group_5__0__Impl rule__Question__Group_5__1 ;
    public final void rule__Question__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1227:1: ( rule__Question__Group_5__0__Impl rule__Question__Group_5__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1228:2: rule__Question__Group_5__0__Impl rule__Question__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__0__Impl_in_rule__Question__Group_5__02475);
            rule__Question__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__1_in_rule__Question__Group_5__02478);
            rule__Question__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__0"


    // $ANTLR start "rule__Question__Group_5__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1235:1: rule__Question__Group_5__0__Impl : ( 'Candidates' ) ;
    public final void rule__Question__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1239:1: ( ( 'Candidates' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1240:1: ( 'Candidates' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1240:1: ( 'Candidates' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1241:1: 'Candidates'
            {
             before(grammarAccess.getQuestionAccess().getCandidatesKeyword_5_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Question__Group_5__0__Impl2506); 
             after(grammarAccess.getQuestionAccess().getCandidatesKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__0__Impl"


    // $ANTLR start "rule__Question__Group_5__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1254:1: rule__Question__Group_5__1 : rule__Question__Group_5__1__Impl rule__Question__Group_5__2 ;
    public final void rule__Question__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1258:1: ( rule__Question__Group_5__1__Impl rule__Question__Group_5__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1259:2: rule__Question__Group_5__1__Impl rule__Question__Group_5__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__1__Impl_in_rule__Question__Group_5__12537);
            rule__Question__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__2_in_rule__Question__Group_5__12540);
            rule__Question__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__1"


    // $ANTLR start "rule__Question__Group_5__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1266:1: rule__Question__Group_5__1__Impl : ( ':' ) ;
    public final void rule__Question__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1270:1: ( ( ':' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1271:1: ( ':' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1271:1: ( ':' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1272:1: ':'
            {
             before(grammarAccess.getQuestionAccess().getColonKeyword_5_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Question__Group_5__1__Impl2568); 
             after(grammarAccess.getQuestionAccess().getColonKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__1__Impl"


    // $ANTLR start "rule__Question__Group_5__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1285:1: rule__Question__Group_5__2 : rule__Question__Group_5__2__Impl rule__Question__Group_5__3 ;
    public final void rule__Question__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1289:1: ( rule__Question__Group_5__2__Impl rule__Question__Group_5__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1290:2: rule__Question__Group_5__2__Impl rule__Question__Group_5__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__2__Impl_in_rule__Question__Group_5__22599);
            rule__Question__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__3_in_rule__Question__Group_5__22602);
            rule__Question__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__2"


    // $ANTLR start "rule__Question__Group_5__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1297:1: rule__Question__Group_5__2__Impl : ( ( rule__Question__CandidatesAssignment_5_2 ) ) ;
    public final void rule__Question__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1301:1: ( ( ( rule__Question__CandidatesAssignment_5_2 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1302:1: ( ( rule__Question__CandidatesAssignment_5_2 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1302:1: ( ( rule__Question__CandidatesAssignment_5_2 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1303:1: ( rule__Question__CandidatesAssignment_5_2 )
            {
             before(grammarAccess.getQuestionAccess().getCandidatesAssignment_5_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1304:1: ( rule__Question__CandidatesAssignment_5_2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1304:2: rule__Question__CandidatesAssignment_5_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__CandidatesAssignment_5_2_in_rule__Question__Group_5__2__Impl2629);
            rule__Question__CandidatesAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getCandidatesAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__2__Impl"


    // $ANTLR start "rule__Question__Group_5__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1314:1: rule__Question__Group_5__3 : rule__Question__Group_5__3__Impl ;
    public final void rule__Question__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1318:1: ( rule__Question__Group_5__3__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1319:2: rule__Question__Group_5__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5__3__Impl_in_rule__Question__Group_5__32659);
            rule__Question__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__3"


    // $ANTLR start "rule__Question__Group_5__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1325:1: rule__Question__Group_5__3__Impl : ( ( rule__Question__Group_5_3__0 )* ) ;
    public final void rule__Question__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1329:1: ( ( ( rule__Question__Group_5_3__0 )* ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1330:1: ( ( rule__Question__Group_5_3__0 )* )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1330:1: ( ( rule__Question__Group_5_3__0 )* )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1331:1: ( rule__Question__Group_5_3__0 )*
            {
             before(grammarAccess.getQuestionAccess().getGroup_5_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1332:1: ( rule__Question__Group_5_3__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1332:2: rule__Question__Group_5_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5_3__0_in_rule__Question__Group_5__3__Impl2686);
            	    rule__Question__Group_5_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getQuestionAccess().getGroup_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5__3__Impl"


    // $ANTLR start "rule__Question__Group_5_3__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1350:1: rule__Question__Group_5_3__0 : rule__Question__Group_5_3__0__Impl rule__Question__Group_5_3__1 ;
    public final void rule__Question__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1354:1: ( rule__Question__Group_5_3__0__Impl rule__Question__Group_5_3__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1355:2: rule__Question__Group_5_3__0__Impl rule__Question__Group_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5_3__0__Impl_in_rule__Question__Group_5_3__02725);
            rule__Question__Group_5_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5_3__1_in_rule__Question__Group_5_3__02728);
            rule__Question__Group_5_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5_3__0"


    // $ANTLR start "rule__Question__Group_5_3__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1362:1: rule__Question__Group_5_3__0__Impl : ( ',' ) ;
    public final void rule__Question__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1366:1: ( ( ',' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1367:1: ( ',' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1367:1: ( ',' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1368:1: ','
            {
             before(grammarAccess.getQuestionAccess().getCommaKeyword_5_3_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Question__Group_5_3__0__Impl2756); 
             after(grammarAccess.getQuestionAccess().getCommaKeyword_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5_3__0__Impl"


    // $ANTLR start "rule__Question__Group_5_3__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1381:1: rule__Question__Group_5_3__1 : rule__Question__Group_5_3__1__Impl ;
    public final void rule__Question__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1385:1: ( rule__Question__Group_5_3__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1386:2: rule__Question__Group_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__Group_5_3__1__Impl_in_rule__Question__Group_5_3__12787);
            rule__Question__Group_5_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5_3__1"


    // $ANTLR start "rule__Question__Group_5_3__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1392:1: rule__Question__Group_5_3__1__Impl : ( ( rule__Question__CandidatesAssignment_5_3_1 ) ) ;
    public final void rule__Question__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1396:1: ( ( ( rule__Question__CandidatesAssignment_5_3_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1397:1: ( ( rule__Question__CandidatesAssignment_5_3_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1397:1: ( ( rule__Question__CandidatesAssignment_5_3_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1398:1: ( rule__Question__CandidatesAssignment_5_3_1 )
            {
             before(grammarAccess.getQuestionAccess().getCandidatesAssignment_5_3_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1399:1: ( rule__Question__CandidatesAssignment_5_3_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1399:2: rule__Question__CandidatesAssignment_5_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Question__CandidatesAssignment_5_3_1_in_rule__Question__Group_5_3__1__Impl2814);
            rule__Question__CandidatesAssignment_5_3_1();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getCandidatesAssignment_5_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Group_5_3__1__Impl"


    // $ANTLR start "rule__NextRule__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1413:1: rule__NextRule__Group__0 : rule__NextRule__Group__0__Impl rule__NextRule__Group__1 ;
    public final void rule__NextRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1417:1: ( rule__NextRule__Group__0__Impl rule__NextRule__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1418:2: rule__NextRule__Group__0__Impl rule__NextRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__0__Impl_in_rule__NextRule__Group__02848);
            rule__NextRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__1_in_rule__NextRule__Group__02851);
            rule__NextRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__0"


    // $ANTLR start "rule__NextRule__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1425:1: rule__NextRule__Group__0__Impl : ( () ) ;
    public final void rule__NextRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1429:1: ( ( () ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1430:1: ( () )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1430:1: ( () )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1431:1: ()
            {
             before(grammarAccess.getNextRuleAccess().getNextRuleAction_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1432:1: ()
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1434:1: 
            {
            }

             after(grammarAccess.getNextRuleAccess().getNextRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__0__Impl"


    // $ANTLR start "rule__NextRule__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1444:1: rule__NextRule__Group__1 : rule__NextRule__Group__1__Impl rule__NextRule__Group__2 ;
    public final void rule__NextRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1448:1: ( rule__NextRule__Group__1__Impl rule__NextRule__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1449:2: rule__NextRule__Group__1__Impl rule__NextRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__1__Impl_in_rule__NextRule__Group__12909);
            rule__NextRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__2_in_rule__NextRule__Group__12912);
            rule__NextRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__1"


    // $ANTLR start "rule__NextRule__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1456:1: rule__NextRule__Group__1__Impl : ( 'Next' ) ;
    public final void rule__NextRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1460:1: ( ( 'Next' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1461:1: ( 'Next' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1461:1: ( 'Next' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1462:1: 'Next'
            {
             before(grammarAccess.getNextRuleAccess().getNextKeyword_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__NextRule__Group__1__Impl2940); 
             after(grammarAccess.getNextRuleAccess().getNextKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__1__Impl"


    // $ANTLR start "rule__NextRule__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1475:1: rule__NextRule__Group__2 : rule__NextRule__Group__2__Impl rule__NextRule__Group__3 ;
    public final void rule__NextRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1479:1: ( rule__NextRule__Group__2__Impl rule__NextRule__Group__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1480:2: rule__NextRule__Group__2__Impl rule__NextRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__2__Impl_in_rule__NextRule__Group__22971);
            rule__NextRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__3_in_rule__NextRule__Group__22974);
            rule__NextRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__2"


    // $ANTLR start "rule__NextRule__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1487:1: rule__NextRule__Group__2__Impl : ( ':' ) ;
    public final void rule__NextRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1491:1: ( ( ':' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1492:1: ( ':' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1492:1: ( ':' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1493:1: ':'
            {
             before(grammarAccess.getNextRuleAccess().getColonKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__NextRule__Group__2__Impl3002); 
             after(grammarAccess.getNextRuleAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__2__Impl"


    // $ANTLR start "rule__NextRule__Group__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1506:1: rule__NextRule__Group__3 : rule__NextRule__Group__3__Impl rule__NextRule__Group__4 ;
    public final void rule__NextRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1510:1: ( rule__NextRule__Group__3__Impl rule__NextRule__Group__4 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1511:2: rule__NextRule__Group__3__Impl rule__NextRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__3__Impl_in_rule__NextRule__Group__33033);
            rule__NextRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__4_in_rule__NextRule__Group__33036);
            rule__NextRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__3"


    // $ANTLR start "rule__NextRule__Group__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1518:1: rule__NextRule__Group__3__Impl : ( ( rule__NextRule__NextAssignment_3 )? ) ;
    public final void rule__NextRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1522:1: ( ( ( rule__NextRule__NextAssignment_3 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1523:1: ( ( rule__NextRule__NextAssignment_3 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1523:1: ( ( rule__NextRule__NextAssignment_3 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1524:1: ( rule__NextRule__NextAssignment_3 )?
            {
             before(grammarAccess.getNextRuleAccess().getNextAssignment_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1525:1: ( rule__NextRule__NextAssignment_3 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1525:2: rule__NextRule__NextAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__NextRule__NextAssignment_3_in_rule__NextRule__Group__3__Impl3063);
                    rule__NextRule__NextAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNextRuleAccess().getNextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__3__Impl"


    // $ANTLR start "rule__NextRule__Group__4"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1535:1: rule__NextRule__Group__4 : rule__NextRule__Group__4__Impl ;
    public final void rule__NextRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1539:1: ( rule__NextRule__Group__4__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1540:2: rule__NextRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group__4__Impl_in_rule__NextRule__Group__43094);
            rule__NextRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__4"


    // $ANTLR start "rule__NextRule__Group__4__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1546:1: rule__NextRule__Group__4__Impl : ( ( rule__NextRule__Group_4__0 )? ) ;
    public final void rule__NextRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1550:1: ( ( ( rule__NextRule__Group_4__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1551:1: ( ( rule__NextRule__Group_4__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1551:1: ( ( rule__NextRule__Group_4__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1552:1: ( rule__NextRule__Group_4__0 )?
            {
             before(grammarAccess.getNextRuleAccess().getGroup_4()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1553:1: ( rule__NextRule__Group_4__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1553:2: rule__NextRule__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__0_in_rule__NextRule__Group__4__Impl3121);
                    rule__NextRule__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNextRuleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group__4__Impl"


    // $ANTLR start "rule__NextRule__Group_4__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1573:1: rule__NextRule__Group_4__0 : rule__NextRule__Group_4__0__Impl rule__NextRule__Group_4__1 ;
    public final void rule__NextRule__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1577:1: ( rule__NextRule__Group_4__0__Impl rule__NextRule__Group_4__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1578:2: rule__NextRule__Group_4__0__Impl rule__NextRule__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__0__Impl_in_rule__NextRule__Group_4__03162);
            rule__NextRule__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__1_in_rule__NextRule__Group_4__03165);
            rule__NextRule__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__0"


    // $ANTLR start "rule__NextRule__Group_4__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1585:1: rule__NextRule__Group_4__0__Impl : ( 'if' ) ;
    public final void rule__NextRule__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1589:1: ( ( 'if' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1590:1: ( 'if' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1590:1: ( 'if' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1591:1: 'if'
            {
             before(grammarAccess.getNextRuleAccess().getIfKeyword_4_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__NextRule__Group_4__0__Impl3193); 
             after(grammarAccess.getNextRuleAccess().getIfKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__0__Impl"


    // $ANTLR start "rule__NextRule__Group_4__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1604:1: rule__NextRule__Group_4__1 : rule__NextRule__Group_4__1__Impl rule__NextRule__Group_4__2 ;
    public final void rule__NextRule__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1608:1: ( rule__NextRule__Group_4__1__Impl rule__NextRule__Group_4__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1609:2: rule__NextRule__Group_4__1__Impl rule__NextRule__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__1__Impl_in_rule__NextRule__Group_4__13224);
            rule__NextRule__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__2_in_rule__NextRule__Group_4__13227);
            rule__NextRule__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__1"


    // $ANTLR start "rule__NextRule__Group_4__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1616:1: rule__NextRule__Group_4__1__Impl : ( ( rule__NextRule__TriesAssignment_4_1 ) ) ;
    public final void rule__NextRule__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1620:1: ( ( ( rule__NextRule__TriesAssignment_4_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1621:1: ( ( rule__NextRule__TriesAssignment_4_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1621:1: ( ( rule__NextRule__TriesAssignment_4_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1622:1: ( rule__NextRule__TriesAssignment_4_1 )
            {
             before(grammarAccess.getNextRuleAccess().getTriesAssignment_4_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1623:1: ( rule__NextRule__TriesAssignment_4_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1623:2: rule__NextRule__TriesAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__TriesAssignment_4_1_in_rule__NextRule__Group_4__1__Impl3254);
            rule__NextRule__TriesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getNextRuleAccess().getTriesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__1__Impl"


    // $ANTLR start "rule__NextRule__Group_4__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1633:1: rule__NextRule__Group_4__2 : rule__NextRule__Group_4__2__Impl ;
    public final void rule__NextRule__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1637:1: ( rule__NextRule__Group_4__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1638:2: rule__NextRule__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextRule__Group_4__2__Impl_in_rule__NextRule__Group_4__23284);
            rule__NextRule__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__2"


    // $ANTLR start "rule__NextRule__Group_4__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1644:1: rule__NextRule__Group_4__2__Impl : ( 'tries' ) ;
    public final void rule__NextRule__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1648:1: ( ( 'tries' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1649:1: ( 'tries' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1649:1: ( 'tries' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1650:1: 'tries'
            {
             before(grammarAccess.getNextRuleAccess().getTriesKeyword_4_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__NextRule__Group_4__2__Impl3312); 
             after(grammarAccess.getNextRuleAccess().getTriesKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__Group_4__2__Impl"


    // $ANTLR start "rule__QASection__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1669:1: rule__QASection__Group__0 : rule__QASection__Group__0__Impl rule__QASection__Group__1 ;
    public final void rule__QASection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1673:1: ( rule__QASection__Group__0__Impl rule__QASection__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1674:2: rule__QASection__Group__0__Impl rule__QASection__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__0__Impl_in_rule__QASection__Group__03349);
            rule__QASection__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__1_in_rule__QASection__Group__03352);
            rule__QASection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__0"


    // $ANTLR start "rule__QASection__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1681:1: rule__QASection__Group__0__Impl : ( 'Section' ) ;
    public final void rule__QASection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1685:1: ( ( 'Section' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1686:1: ( 'Section' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1686:1: ( 'Section' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1687:1: 'Section'
            {
             before(grammarAccess.getQASectionAccess().getSectionKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__QASection__Group__0__Impl3380); 
             after(grammarAccess.getQASectionAccess().getSectionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__0__Impl"


    // $ANTLR start "rule__QASection__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1700:1: rule__QASection__Group__1 : rule__QASection__Group__1__Impl rule__QASection__Group__2 ;
    public final void rule__QASection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1704:1: ( rule__QASection__Group__1__Impl rule__QASection__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1705:2: rule__QASection__Group__1__Impl rule__QASection__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__1__Impl_in_rule__QASection__Group__13411);
            rule__QASection__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__2_in_rule__QASection__Group__13414);
            rule__QASection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__1"


    // $ANTLR start "rule__QASection__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1712:1: rule__QASection__Group__1__Impl : ( ( rule__QASection__Group_1__0 )? ) ;
    public final void rule__QASection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1716:1: ( ( ( rule__QASection__Group_1__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1717:1: ( ( rule__QASection__Group_1__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1717:1: ( ( rule__QASection__Group_1__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1718:1: ( rule__QASection__Group_1__0 )?
            {
             before(grammarAccess.getQASectionAccess().getGroup_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1719:1: ( rule__QASection__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1719:2: rule__QASection__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__QASection__Group_1__0_in_rule__QASection__Group__1__Impl3441);
                    rule__QASection__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQASectionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__1__Impl"


    // $ANTLR start "rule__QASection__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1729:1: rule__QASection__Group__2 : rule__QASection__Group__2__Impl rule__QASection__Group__3 ;
    public final void rule__QASection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1733:1: ( rule__QASection__Group__2__Impl rule__QASection__Group__3 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1734:2: rule__QASection__Group__2__Impl rule__QASection__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__2__Impl_in_rule__QASection__Group__23472);
            rule__QASection__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__3_in_rule__QASection__Group__23475);
            rule__QASection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__2"


    // $ANTLR start "rule__QASection__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1741:1: rule__QASection__Group__2__Impl : ( ( rule__QASection__TitleAssignment_2 ) ) ;
    public final void rule__QASection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1745:1: ( ( ( rule__QASection__TitleAssignment_2 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1746:1: ( ( rule__QASection__TitleAssignment_2 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1746:1: ( ( rule__QASection__TitleAssignment_2 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1747:1: ( rule__QASection__TitleAssignment_2 )
            {
             before(grammarAccess.getQASectionAccess().getTitleAssignment_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1748:1: ( rule__QASection__TitleAssignment_2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1748:2: rule__QASection__TitleAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__TitleAssignment_2_in_rule__QASection__Group__2__Impl3502);
            rule__QASection__TitleAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getQASectionAccess().getTitleAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__2__Impl"


    // $ANTLR start "rule__QASection__Group__3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1758:1: rule__QASection__Group__3 : rule__QASection__Group__3__Impl rule__QASection__Group__4 ;
    public final void rule__QASection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1762:1: ( rule__QASection__Group__3__Impl rule__QASection__Group__4 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1763:2: rule__QASection__Group__3__Impl rule__QASection__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__3__Impl_in_rule__QASection__Group__33532);
            rule__QASection__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__4_in_rule__QASection__Group__33535);
            rule__QASection__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__3"


    // $ANTLR start "rule__QASection__Group__3__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1770:1: rule__QASection__Group__3__Impl : ( ( rule__QASection__OptionsAssignment_3 )? ) ;
    public final void rule__QASection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1774:1: ( ( ( rule__QASection__OptionsAssignment_3 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1775:1: ( ( rule__QASection__OptionsAssignment_3 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1775:1: ( ( rule__QASection__OptionsAssignment_3 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1776:1: ( rule__QASection__OptionsAssignment_3 )?
            {
             before(grammarAccess.getQASectionAccess().getOptionsAssignment_3()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1777:1: ( rule__QASection__OptionsAssignment_3 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1777:2: rule__QASection__OptionsAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__QASection__OptionsAssignment_3_in_rule__QASection__Group__3__Impl3562);
                    rule__QASection__OptionsAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQASectionAccess().getOptionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__3__Impl"


    // $ANTLR start "rule__QASection__Group__4"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1787:1: rule__QASection__Group__4 : rule__QASection__Group__4__Impl rule__QASection__Group__5 ;
    public final void rule__QASection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1791:1: ( rule__QASection__Group__4__Impl rule__QASection__Group__5 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1792:2: rule__QASection__Group__4__Impl rule__QASection__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__4__Impl_in_rule__QASection__Group__43593);
            rule__QASection__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__5_in_rule__QASection__Group__43596);
            rule__QASection__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__4"


    // $ANTLR start "rule__QASection__Group__4__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1799:1: rule__QASection__Group__4__Impl : ( '{' ) ;
    public final void rule__QASection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1803:1: ( ( '{' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1804:1: ( '{' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1804:1: ( '{' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1805:1: '{'
            {
             before(grammarAccess.getQASectionAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__QASection__Group__4__Impl3624); 
             after(grammarAccess.getQASectionAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__4__Impl"


    // $ANTLR start "rule__QASection__Group__5"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1818:1: rule__QASection__Group__5 : rule__QASection__Group__5__Impl rule__QASection__Group__6 ;
    public final void rule__QASection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1822:1: ( rule__QASection__Group__5__Impl rule__QASection__Group__6 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1823:2: rule__QASection__Group__5__Impl rule__QASection__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__5__Impl_in_rule__QASection__Group__53655);
            rule__QASection__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__6_in_rule__QASection__Group__53658);
            rule__QASection__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__5"


    // $ANTLR start "rule__QASection__Group__5__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1830:1: rule__QASection__Group__5__Impl : ( ( rule__QASection__QuestionsAssignment_5 )* ) ;
    public final void rule__QASection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1834:1: ( ( ( rule__QASection__QuestionsAssignment_5 )* ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1835:1: ( ( rule__QASection__QuestionsAssignment_5 )* )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1835:1: ( ( rule__QASection__QuestionsAssignment_5 )* )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1836:1: ( rule__QASection__QuestionsAssignment_5 )*
            {
             before(grammarAccess.getQASectionAccess().getQuestionsAssignment_5()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1837:1: ( rule__QASection__QuestionsAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||LA18_0==20) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1837:2: rule__QASection__QuestionsAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QASection__QuestionsAssignment_5_in_rule__QASection__Group__5__Impl3685);
            	    rule__QASection__QuestionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getQASectionAccess().getQuestionsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__5__Impl"


    // $ANTLR start "rule__QASection__Group__6"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1847:1: rule__QASection__Group__6 : rule__QASection__Group__6__Impl ;
    public final void rule__QASection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1851:1: ( rule__QASection__Group__6__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1852:2: rule__QASection__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group__6__Impl_in_rule__QASection__Group__63716);
            rule__QASection__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__6"


    // $ANTLR start "rule__QASection__Group__6__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1858:1: rule__QASection__Group__6__Impl : ( '}' ) ;
    public final void rule__QASection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1862:1: ( ( '}' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1863:1: ( '}' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1863:1: ( '}' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1864:1: '}'
            {
             before(grammarAccess.getQASectionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__QASection__Group__6__Impl3744); 
             after(grammarAccess.getQASectionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group__6__Impl"


    // $ANTLR start "rule__QASection__Group_1__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1891:1: rule__QASection__Group_1__0 : rule__QASection__Group_1__0__Impl rule__QASection__Group_1__1 ;
    public final void rule__QASection__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1895:1: ( rule__QASection__Group_1__0__Impl rule__QASection__Group_1__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1896:2: rule__QASection__Group_1__0__Impl rule__QASection__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group_1__0__Impl_in_rule__QASection__Group_1__03789);
            rule__QASection__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group_1__1_in_rule__QASection__Group_1__03792);
            rule__QASection__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group_1__0"


    // $ANTLR start "rule__QASection__Group_1__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1903:1: rule__QASection__Group_1__0__Impl : ( 'ID' ) ;
    public final void rule__QASection__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1907:1: ( ( 'ID' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1908:1: ( 'ID' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1908:1: ( 'ID' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1909:1: 'ID'
            {
             before(grammarAccess.getQASectionAccess().getIDKeyword_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__QASection__Group_1__0__Impl3820); 
             after(grammarAccess.getQASectionAccess().getIDKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group_1__0__Impl"


    // $ANTLR start "rule__QASection__Group_1__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1922:1: rule__QASection__Group_1__1 : rule__QASection__Group_1__1__Impl ;
    public final void rule__QASection__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1926:1: ( rule__QASection__Group_1__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1927:2: rule__QASection__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__Group_1__1__Impl_in_rule__QASection__Group_1__13851);
            rule__QASection__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group_1__1"


    // $ANTLR start "rule__QASection__Group_1__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1933:1: rule__QASection__Group_1__1__Impl : ( ( rule__QASection__NameAssignment_1_1 ) ) ;
    public final void rule__QASection__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1937:1: ( ( ( rule__QASection__NameAssignment_1_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1938:1: ( ( rule__QASection__NameAssignment_1_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1938:1: ( ( rule__QASection__NameAssignment_1_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1939:1: ( rule__QASection__NameAssignment_1_1 )
            {
             before(grammarAccess.getQASectionAccess().getNameAssignment_1_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1940:1: ( rule__QASection__NameAssignment_1_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1940:2: rule__QASection__NameAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QASection__NameAssignment_1_1_in_rule__QASection__Group_1__1__Impl3878);
            rule__QASection__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getQASectionAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__Group_1__1__Impl"


    // $ANTLR start "rule__NumberAnswer__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1954:1: rule__NumberAnswer__Group__0 : rule__NumberAnswer__Group__0__Impl rule__NumberAnswer__Group__1 ;
    public final void rule__NumberAnswer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1958:1: ( rule__NumberAnswer__Group__0__Impl rule__NumberAnswer__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1959:2: rule__NumberAnswer__Group__0__Impl rule__NumberAnswer__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group__0__Impl_in_rule__NumberAnswer__Group__03912);
            rule__NumberAnswer__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group__1_in_rule__NumberAnswer__Group__03915);
            rule__NumberAnswer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group__0"


    // $ANTLR start "rule__NumberAnswer__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1966:1: rule__NumberAnswer__Group__0__Impl : ( ( rule__NumberAnswer__NumberAssignment_0 ) ) ;
    public final void rule__NumberAnswer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1970:1: ( ( ( rule__NumberAnswer__NumberAssignment_0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1971:1: ( ( rule__NumberAnswer__NumberAssignment_0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1971:1: ( ( rule__NumberAnswer__NumberAssignment_0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1972:1: ( rule__NumberAnswer__NumberAssignment_0 )
            {
             before(grammarAccess.getNumberAnswerAccess().getNumberAssignment_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1973:1: ( rule__NumberAnswer__NumberAssignment_0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1973:2: rule__NumberAnswer__NumberAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__NumberAssignment_0_in_rule__NumberAnswer__Group__0__Impl3942);
            rule__NumberAnswer__NumberAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNumberAnswerAccess().getNumberAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group__0__Impl"


    // $ANTLR start "rule__NumberAnswer__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1983:1: rule__NumberAnswer__Group__1 : rule__NumberAnswer__Group__1__Impl ;
    public final void rule__NumberAnswer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1987:1: ( rule__NumberAnswer__Group__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1988:2: rule__NumberAnswer__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group__1__Impl_in_rule__NumberAnswer__Group__13972);
            rule__NumberAnswer__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group__1"


    // $ANTLR start "rule__NumberAnswer__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1994:1: rule__NumberAnswer__Group__1__Impl : ( ( rule__NumberAnswer__Group_1__0 )? ) ;
    public final void rule__NumberAnswer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1998:1: ( ( ( rule__NumberAnswer__Group_1__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1999:1: ( ( rule__NumberAnswer__Group_1__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:1999:1: ( ( rule__NumberAnswer__Group_1__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2000:1: ( rule__NumberAnswer__Group_1__0 )?
            {
             before(grammarAccess.getNumberAnswerAccess().getGroup_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2001:1: ( rule__NumberAnswer__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2001:2: rule__NumberAnswer__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group_1__0_in_rule__NumberAnswer__Group__1__Impl3999);
                    rule__NumberAnswer__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNumberAnswerAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group__1__Impl"


    // $ANTLR start "rule__NumberAnswer__Group_1__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2015:1: rule__NumberAnswer__Group_1__0 : rule__NumberAnswer__Group_1__0__Impl rule__NumberAnswer__Group_1__1 ;
    public final void rule__NumberAnswer__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2019:1: ( rule__NumberAnswer__Group_1__0__Impl rule__NumberAnswer__Group_1__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2020:2: rule__NumberAnswer__Group_1__0__Impl rule__NumberAnswer__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group_1__0__Impl_in_rule__NumberAnswer__Group_1__04034);
            rule__NumberAnswer__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group_1__1_in_rule__NumberAnswer__Group_1__04037);
            rule__NumberAnswer__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group_1__0"


    // $ANTLR start "rule__NumberAnswer__Group_1__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2027:1: rule__NumberAnswer__Group_1__0__Impl : ( '+-' ) ;
    public final void rule__NumberAnswer__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2031:1: ( ( '+-' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2032:1: ( '+-' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2032:1: ( '+-' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2033:1: '+-'
            {
             before(grammarAccess.getNumberAnswerAccess().getPlusSignHyphenMinusKeyword_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__NumberAnswer__Group_1__0__Impl4065); 
             after(grammarAccess.getNumberAnswerAccess().getPlusSignHyphenMinusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group_1__0__Impl"


    // $ANTLR start "rule__NumberAnswer__Group_1__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2046:1: rule__NumberAnswer__Group_1__1 : rule__NumberAnswer__Group_1__1__Impl ;
    public final void rule__NumberAnswer__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2050:1: ( rule__NumberAnswer__Group_1__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2051:2: rule__NumberAnswer__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__Group_1__1__Impl_in_rule__NumberAnswer__Group_1__14096);
            rule__NumberAnswer__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group_1__1"


    // $ANTLR start "rule__NumberAnswer__Group_1__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2057:1: rule__NumberAnswer__Group_1__1__Impl : ( ( rule__NumberAnswer__EpsilonAssignment_1_1 ) ) ;
    public final void rule__NumberAnswer__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2061:1: ( ( ( rule__NumberAnswer__EpsilonAssignment_1_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2062:1: ( ( rule__NumberAnswer__EpsilonAssignment_1_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2062:1: ( ( rule__NumberAnswer__EpsilonAssignment_1_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2063:1: ( rule__NumberAnswer__EpsilonAssignment_1_1 )
            {
             before(grammarAccess.getNumberAnswerAccess().getEpsilonAssignment_1_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2064:1: ( rule__NumberAnswer__EpsilonAssignment_1_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2064:2: rule__NumberAnswer__EpsilonAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NumberAnswer__EpsilonAssignment_1_1_in_rule__NumberAnswer__Group_1__1__Impl4123);
            rule__NumberAnswer__EpsilonAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNumberAnswerAccess().getEpsilonAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__Group_1__1__Impl"


    // $ANTLR start "rule__YesNoAnswer__Group_0__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2078:1: rule__YesNoAnswer__Group_0__0 : rule__YesNoAnswer__Group_0__0__Impl rule__YesNoAnswer__Group_0__1 ;
    public final void rule__YesNoAnswer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2082:1: ( rule__YesNoAnswer__Group_0__0__Impl rule__YesNoAnswer__Group_0__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2083:2: rule__YesNoAnswer__Group_0__0__Impl rule__YesNoAnswer__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__Group_0__0__Impl_in_rule__YesNoAnswer__Group_0__04157);
            rule__YesNoAnswer__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__Group_0__1_in_rule__YesNoAnswer__Group_0__04160);
            rule__YesNoAnswer__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__Group_0__0"


    // $ANTLR start "rule__YesNoAnswer__Group_0__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2090:1: rule__YesNoAnswer__Group_0__0__Impl : ( () ) ;
    public final void rule__YesNoAnswer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2094:1: ( ( () ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2095:1: ( () )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2095:1: ( () )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2096:1: ()
            {
             before(grammarAccess.getYesNoAnswerAccess().getYesNoAnswerAction_0_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2097:1: ()
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2099:1: 
            {
            }

             after(grammarAccess.getYesNoAnswerAccess().getYesNoAnswerAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__Group_0__0__Impl"


    // $ANTLR start "rule__YesNoAnswer__Group_0__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2109:1: rule__YesNoAnswer__Group_0__1 : rule__YesNoAnswer__Group_0__1__Impl ;
    public final void rule__YesNoAnswer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2113:1: ( rule__YesNoAnswer__Group_0__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2114:2: rule__YesNoAnswer__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__YesNoAnswer__Group_0__1__Impl_in_rule__YesNoAnswer__Group_0__14218);
            rule__YesNoAnswer__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__Group_0__1"


    // $ANTLR start "rule__YesNoAnswer__Group_0__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2120:1: rule__YesNoAnswer__Group_0__1__Impl : ( 'no' ) ;
    public final void rule__YesNoAnswer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2124:1: ( ( 'no' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2125:1: ( 'no' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2125:1: ( 'no' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2126:1: 'no'
            {
             before(grammarAccess.getYesNoAnswerAccess().getNoKeyword_0_1()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__YesNoAnswer__Group_0__1__Impl4246); 
             after(grammarAccess.getYesNoAnswerAccess().getNoKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__Group_0__1__Impl"


    // $ANTLR start "rule__OptionAnswer__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2143:1: rule__OptionAnswer__Group__0 : rule__OptionAnswer__Group__0__Impl rule__OptionAnswer__Group__1 ;
    public final void rule__OptionAnswer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2147:1: ( rule__OptionAnswer__Group__0__Impl rule__OptionAnswer__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2148:2: rule__OptionAnswer__Group__0__Impl rule__OptionAnswer__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OptionAnswer__Group__0__Impl_in_rule__OptionAnswer__Group__04281);
            rule__OptionAnswer__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OptionAnswer__Group__1_in_rule__OptionAnswer__Group__04284);
            rule__OptionAnswer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionAnswer__Group__0"


    // $ANTLR start "rule__OptionAnswer__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2155:1: rule__OptionAnswer__Group__0__Impl : ( '#' ) ;
    public final void rule__OptionAnswer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2159:1: ( ( '#' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2160:1: ( '#' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2160:1: ( '#' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2161:1: '#'
            {
             before(grammarAccess.getOptionAnswerAccess().getNumberSignKeyword_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__OptionAnswer__Group__0__Impl4312); 
             after(grammarAccess.getOptionAnswerAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionAnswer__Group__0__Impl"


    // $ANTLR start "rule__OptionAnswer__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2174:1: rule__OptionAnswer__Group__1 : rule__OptionAnswer__Group__1__Impl ;
    public final void rule__OptionAnswer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2178:1: ( rule__OptionAnswer__Group__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2179:2: rule__OptionAnswer__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OptionAnswer__Group__1__Impl_in_rule__OptionAnswer__Group__14343);
            rule__OptionAnswer__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionAnswer__Group__1"


    // $ANTLR start "rule__OptionAnswer__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2185:1: rule__OptionAnswer__Group__1__Impl : ( ( rule__OptionAnswer__OptionNumberAssignment_1 ) ) ;
    public final void rule__OptionAnswer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2189:1: ( ( ( rule__OptionAnswer__OptionNumberAssignment_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2190:1: ( ( rule__OptionAnswer__OptionNumberAssignment_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2190:1: ( ( rule__OptionAnswer__OptionNumberAssignment_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2191:1: ( rule__OptionAnswer__OptionNumberAssignment_1 )
            {
             before(grammarAccess.getOptionAnswerAccess().getOptionNumberAssignment_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2192:1: ( rule__OptionAnswer__OptionNumberAssignment_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2192:2: rule__OptionAnswer__OptionNumberAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OptionAnswer__OptionNumberAssignment_1_in_rule__OptionAnswer__Group__1__Impl4370);
            rule__OptionAnswer__OptionNumberAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionAnswerAccess().getOptionNumberAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionAnswer__Group__1__Impl"


    // $ANTLR start "rule__ExpressionAnswer__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2206:1: rule__ExpressionAnswer__Group__0 : rule__ExpressionAnswer__Group__0__Impl rule__ExpressionAnswer__Group__1 ;
    public final void rule__ExpressionAnswer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2210:1: ( rule__ExpressionAnswer__Group__0__Impl rule__ExpressionAnswer__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2211:2: rule__ExpressionAnswer__Group__0__Impl rule__ExpressionAnswer__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__0__Impl_in_rule__ExpressionAnswer__Group__04404);
            rule__ExpressionAnswer__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__1_in_rule__ExpressionAnswer__Group__04407);
            rule__ExpressionAnswer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__0"


    // $ANTLR start "rule__ExpressionAnswer__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2218:1: rule__ExpressionAnswer__Group__0__Impl : ( '=' ) ;
    public final void rule__ExpressionAnswer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2222:1: ( ( '=' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2223:1: ( '=' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2223:1: ( '=' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2224:1: '='
            {
             before(grammarAccess.getExpressionAnswerAccess().getEqualsSignKeyword_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__ExpressionAnswer__Group__0__Impl4435); 
             after(grammarAccess.getExpressionAnswerAccess().getEqualsSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__0__Impl"


    // $ANTLR start "rule__ExpressionAnswer__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2237:1: rule__ExpressionAnswer__Group__1 : rule__ExpressionAnswer__Group__1__Impl rule__ExpressionAnswer__Group__2 ;
    public final void rule__ExpressionAnswer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2241:1: ( rule__ExpressionAnswer__Group__1__Impl rule__ExpressionAnswer__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2242:2: rule__ExpressionAnswer__Group__1__Impl rule__ExpressionAnswer__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__1__Impl_in_rule__ExpressionAnswer__Group__14466);
            rule__ExpressionAnswer__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__2_in_rule__ExpressionAnswer__Group__14469);
            rule__ExpressionAnswer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__1"


    // $ANTLR start "rule__ExpressionAnswer__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2249:1: rule__ExpressionAnswer__Group__1__Impl : ( ( rule__ExpressionAnswer__ExpressionAssignment_1 ) ) ;
    public final void rule__ExpressionAnswer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2253:1: ( ( ( rule__ExpressionAnswer__ExpressionAssignment_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2254:1: ( ( rule__ExpressionAnswer__ExpressionAssignment_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2254:1: ( ( rule__ExpressionAnswer__ExpressionAssignment_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2255:1: ( rule__ExpressionAnswer__ExpressionAssignment_1 )
            {
             before(grammarAccess.getExpressionAnswerAccess().getExpressionAssignment_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2256:1: ( rule__ExpressionAnswer__ExpressionAssignment_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2256:2: rule__ExpressionAnswer__ExpressionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__ExpressionAssignment_1_in_rule__ExpressionAnswer__Group__1__Impl4496);
            rule__ExpressionAnswer__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAnswerAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__1__Impl"


    // $ANTLR start "rule__ExpressionAnswer__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2266:1: rule__ExpressionAnswer__Group__2 : rule__ExpressionAnswer__Group__2__Impl ;
    public final void rule__ExpressionAnswer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2270:1: ( rule__ExpressionAnswer__Group__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2271:2: rule__ExpressionAnswer__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group__2__Impl_in_rule__ExpressionAnswer__Group__24526);
            rule__ExpressionAnswer__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__2"


    // $ANTLR start "rule__ExpressionAnswer__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2277:1: rule__ExpressionAnswer__Group__2__Impl : ( ( rule__ExpressionAnswer__Group_2__0 )? ) ;
    public final void rule__ExpressionAnswer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2281:1: ( ( ( rule__ExpressionAnswer__Group_2__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2282:1: ( ( rule__ExpressionAnswer__Group_2__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2282:1: ( ( rule__ExpressionAnswer__Group_2__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2283:1: ( rule__ExpressionAnswer__Group_2__0 )?
            {
             before(grammarAccess.getExpressionAnswerAccess().getGroup_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2284:1: ( rule__ExpressionAnswer__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2284:2: rule__ExpressionAnswer__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group_2__0_in_rule__ExpressionAnswer__Group__2__Impl4553);
                    rule__ExpressionAnswer__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExpressionAnswerAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group__2__Impl"


    // $ANTLR start "rule__ExpressionAnswer__Group_2__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2300:1: rule__ExpressionAnswer__Group_2__0 : rule__ExpressionAnswer__Group_2__0__Impl rule__ExpressionAnswer__Group_2__1 ;
    public final void rule__ExpressionAnswer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2304:1: ( rule__ExpressionAnswer__Group_2__0__Impl rule__ExpressionAnswer__Group_2__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2305:2: rule__ExpressionAnswer__Group_2__0__Impl rule__ExpressionAnswer__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group_2__0__Impl_in_rule__ExpressionAnswer__Group_2__04590);
            rule__ExpressionAnswer__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group_2__1_in_rule__ExpressionAnswer__Group_2__04593);
            rule__ExpressionAnswer__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group_2__0"


    // $ANTLR start "rule__ExpressionAnswer__Group_2__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2312:1: rule__ExpressionAnswer__Group_2__0__Impl : ( '+-' ) ;
    public final void rule__ExpressionAnswer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2316:1: ( ( '+-' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2317:1: ( '+-' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2317:1: ( '+-' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2318:1: '+-'
            {
             before(grammarAccess.getExpressionAnswerAccess().getPlusSignHyphenMinusKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ExpressionAnswer__Group_2__0__Impl4621); 
             after(grammarAccess.getExpressionAnswerAccess().getPlusSignHyphenMinusKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group_2__0__Impl"


    // $ANTLR start "rule__ExpressionAnswer__Group_2__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2331:1: rule__ExpressionAnswer__Group_2__1 : rule__ExpressionAnswer__Group_2__1__Impl ;
    public final void rule__ExpressionAnswer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2335:1: ( rule__ExpressionAnswer__Group_2__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2336:2: rule__ExpressionAnswer__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__Group_2__1__Impl_in_rule__ExpressionAnswer__Group_2__14652);
            rule__ExpressionAnswer__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group_2__1"


    // $ANTLR start "rule__ExpressionAnswer__Group_2__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2342:1: rule__ExpressionAnswer__Group_2__1__Impl : ( ( rule__ExpressionAnswer__EpsilonAssignment_2_1 ) ) ;
    public final void rule__ExpressionAnswer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2346:1: ( ( ( rule__ExpressionAnswer__EpsilonAssignment_2_1 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2347:1: ( ( rule__ExpressionAnswer__EpsilonAssignment_2_1 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2347:1: ( ( rule__ExpressionAnswer__EpsilonAssignment_2_1 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2348:1: ( rule__ExpressionAnswer__EpsilonAssignment_2_1 )
            {
             before(grammarAccess.getExpressionAnswerAccess().getEpsilonAssignment_2_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2349:1: ( rule__ExpressionAnswer__EpsilonAssignment_2_1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2349:2: rule__ExpressionAnswer__EpsilonAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExpressionAnswer__EpsilonAssignment_2_1_in_rule__ExpressionAnswer__Group_2__1__Impl4679);
            rule__ExpressionAnswer__EpsilonAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAnswerAccess().getEpsilonAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__Group_2__1__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2363:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2367:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2368:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__0__Impl_in_rule__EDouble__Group__04713);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__1_in_rule__EDouble__Group__04716);
            rule__EDouble__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2375:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2379:1: ( ( ( '-' )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2380:1: ( ( '-' )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2380:1: ( ( '-' )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2381:1: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2382:1: ( '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2383:2: '-'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__EDouble__Group__0__Impl4745); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2394:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2398:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2399:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__1__Impl_in_rule__EDouble__Group__14778);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__2_in_rule__EDouble__Group__14781);
            rule__EDouble__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2406:1: rule__EDouble__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2410:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2411:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2411:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2412:1: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group__1__Impl4808); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2423:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2427:1: ( rule__EDouble__Group__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2428:2: rule__EDouble__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__2__Impl_in_rule__EDouble__Group__24837);
            rule__EDouble__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2434:1: rule__EDouble__Group__2__Impl : ( ( rule__EDouble__Group_2__0 )? ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2438:1: ( ( ( rule__EDouble__Group_2__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2439:1: ( ( rule__EDouble__Group_2__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2439:1: ( ( rule__EDouble__Group_2__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2440:1: ( rule__EDouble__Group_2__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2441:1: ( rule__EDouble__Group_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2441:2: rule__EDouble__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__0_in_rule__EDouble__Group__2__Impl4864);
                    rule__EDouble__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group_2__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2457:1: rule__EDouble__Group_2__0 : rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1 ;
    public final void rule__EDouble__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2461:1: ( rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2462:2: rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__0__Impl_in_rule__EDouble__Group_2__04901);
            rule__EDouble__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__1_in_rule__EDouble__Group_2__04904);
            rule__EDouble__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__0"


    // $ANTLR start "rule__EDouble__Group_2__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2469:1: rule__EDouble__Group_2__0__Impl : ( '.' ) ;
    public final void rule__EDouble__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2473:1: ( ( '.' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2474:1: ( '.' )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2474:1: ( '.' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2475:1: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__EDouble__Group_2__0__Impl4932); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__0__Impl"


    // $ANTLR start "rule__EDouble__Group_2__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2488:1: rule__EDouble__Group_2__1 : rule__EDouble__Group_2__1__Impl rule__EDouble__Group_2__2 ;
    public final void rule__EDouble__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2492:1: ( rule__EDouble__Group_2__1__Impl rule__EDouble__Group_2__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2493:2: rule__EDouble__Group_2__1__Impl rule__EDouble__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__1__Impl_in_rule__EDouble__Group_2__14963);
            rule__EDouble__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__2_in_rule__EDouble__Group_2__14966);
            rule__EDouble__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__1"


    // $ANTLR start "rule__EDouble__Group_2__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2500:1: rule__EDouble__Group_2__1__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2504:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2505:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2505:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2506:1: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group_2__1__Impl4993); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__1__Impl"


    // $ANTLR start "rule__EDouble__Group_2__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2517:1: rule__EDouble__Group_2__2 : rule__EDouble__Group_2__2__Impl ;
    public final void rule__EDouble__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2521:1: ( rule__EDouble__Group_2__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2522:2: rule__EDouble__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2__2__Impl_in_rule__EDouble__Group_2__25022);
            rule__EDouble__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__2"


    // $ANTLR start "rule__EDouble__Group_2__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2528:1: rule__EDouble__Group_2__2__Impl : ( ( rule__EDouble__Group_2_2__0 )? ) ;
    public final void rule__EDouble__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2532:1: ( ( ( rule__EDouble__Group_2_2__0 )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2533:1: ( ( rule__EDouble__Group_2_2__0 )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2533:1: ( ( rule__EDouble__Group_2_2__0 )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2534:1: ( rule__EDouble__Group_2_2__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_2_2()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2535:1: ( rule__EDouble__Group_2_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=11 && LA23_0<=12)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2535:2: rule__EDouble__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__0_in_rule__EDouble__Group_2__2__Impl5049);
                    rule__EDouble__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__2__Impl"


    // $ANTLR start "rule__EDouble__Group_2_2__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2551:1: rule__EDouble__Group_2_2__0 : rule__EDouble__Group_2_2__0__Impl rule__EDouble__Group_2_2__1 ;
    public final void rule__EDouble__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2555:1: ( rule__EDouble__Group_2_2__0__Impl rule__EDouble__Group_2_2__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2556:2: rule__EDouble__Group_2_2__0__Impl rule__EDouble__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__0__Impl_in_rule__EDouble__Group_2_2__05086);
            rule__EDouble__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__1_in_rule__EDouble__Group_2_2__05089);
            rule__EDouble__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__0"


    // $ANTLR start "rule__EDouble__Group_2_2__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2563:1: rule__EDouble__Group_2_2__0__Impl : ( ( rule__EDouble__Alternatives_2_2_0 ) ) ;
    public final void rule__EDouble__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2567:1: ( ( ( rule__EDouble__Alternatives_2_2_0 ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2568:1: ( ( rule__EDouble__Alternatives_2_2_0 ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2568:1: ( ( rule__EDouble__Alternatives_2_2_0 ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2569:1: ( rule__EDouble__Alternatives_2_2_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_2_2_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2570:1: ( rule__EDouble__Alternatives_2_2_0 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2570:2: rule__EDouble__Alternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Alternatives_2_2_0_in_rule__EDouble__Group_2_2__0__Impl5116);
            rule__EDouble__Alternatives_2_2_0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__0__Impl"


    // $ANTLR start "rule__EDouble__Group_2_2__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2580:1: rule__EDouble__Group_2_2__1 : rule__EDouble__Group_2_2__1__Impl rule__EDouble__Group_2_2__2 ;
    public final void rule__EDouble__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2584:1: ( rule__EDouble__Group_2_2__1__Impl rule__EDouble__Group_2_2__2 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2585:2: rule__EDouble__Group_2_2__1__Impl rule__EDouble__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__1__Impl_in_rule__EDouble__Group_2_2__15146);
            rule__EDouble__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__2_in_rule__EDouble__Group_2_2__15149);
            rule__EDouble__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__1"


    // $ANTLR start "rule__EDouble__Group_2_2__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2592:1: rule__EDouble__Group_2_2__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2596:1: ( ( ( '-' )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2597:1: ( ( '-' )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2597:1: ( ( '-' )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2598:1: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_2_2_1()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2599:1: ( '-' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2600:2: '-'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__EDouble__Group_2_2__1__Impl5178); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__1__Impl"


    // $ANTLR start "rule__EDouble__Group_2_2__2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2611:1: rule__EDouble__Group_2_2__2 : rule__EDouble__Group_2_2__2__Impl ;
    public final void rule__EDouble__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2615:1: ( rule__EDouble__Group_2_2__2__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2616:2: rule__EDouble__Group_2_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_2_2__2__Impl_in_rule__EDouble__Group_2_2__25211);
            rule__EDouble__Group_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__2"


    // $ANTLR start "rule__EDouble__Group_2_2__2__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2622:1: rule__EDouble__Group_2_2__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2626:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2627:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2627:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2628:1: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_2_2()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group_2_2__2__Impl5238); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2_2__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2645:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2649:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2650:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__05273);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__05276);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2657:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2661:1: ( ( ( '-' )? ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2662:1: ( ( '-' )? )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2662:1: ( ( '-' )? )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2663:1: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2664:1: ( '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2665:2: '-'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__EInt__Group__0__Impl5305); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2676:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2680:1: ( rule__EInt__Group__1__Impl )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2681:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__15338);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2687:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2691:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2692:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2692:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2693:1: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl5365); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__QATest__TitleAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2709:1: rule__QATest__TitleAssignment_1 : ( ruleEString ) ;
    public final void rule__QATest__TitleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2713:1: ( ( ruleEString ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2714:1: ( ruleEString )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2714:1: ( ruleEString )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2715:1: ruleEString
            {
             before(grammarAccess.getQATestAccess().getTitleEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__QATest__TitleAssignment_15403);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getQATestAccess().getTitleEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__TitleAssignment_1"


    // $ANTLR start "rule__QATest__OptionsAssignment_2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2724:1: rule__QATest__OptionsAssignment_2 : ( ruleQAContainerOptions ) ;
    public final void rule__QATest__OptionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2728:1: ( ( ruleQAContainerOptions ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2729:1: ( ruleQAContainerOptions )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2729:1: ( ruleQAContainerOptions )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2730:1: ruleQAContainerOptions
            {
             before(grammarAccess.getQATestAccess().getOptionsQAContainerOptionsParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_rule__QATest__OptionsAssignment_25434);
            ruleQAContainerOptions();

            state._fsp--;

             after(grammarAccess.getQATestAccess().getOptionsQAContainerOptionsParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__OptionsAssignment_2"


    // $ANTLR start "rule__QATest__PartsAssignment_3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2739:1: rule__QATest__PartsAssignment_3 : ( ruleQAPart ) ;
    public final void rule__QATest__PartsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2743:1: ( ( ruleQAPart ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2744:1: ( ruleQAPart )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2744:1: ( ruleQAPart )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2745:1: ruleQAPart
            {
             before(grammarAccess.getQATestAccess().getPartsQAPartParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAPart_in_rule__QATest__PartsAssignment_35465);
            ruleQAPart();

            state._fsp--;

             after(grammarAccess.getQATestAccess().getPartsQAPartParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QATest__PartsAssignment_3"


    // $ANTLR start "rule__QAContainerOptions__MaxTriesAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2754:1: rule__QAContainerOptions__MaxTriesAssignment_1 : ( RULE_INT ) ;
    public final void rule__QAContainerOptions__MaxTriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2758:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2759:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2759:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2760:1: RULE_INT
            {
             before(grammarAccess.getQAContainerOptionsAccess().getMaxTriesINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__QAContainerOptions__MaxTriesAssignment_15496); 
             after(grammarAccess.getQAContainerOptionsAccess().getMaxTriesINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__MaxTriesAssignment_1"


    // $ANTLR start "rule__QAContainerOptions__RevealAnswerAssignment_3_0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2769:1: rule__QAContainerOptions__RevealAnswerAssignment_3_0 : ( ( 'reveal' ) ) ;
    public final void rule__QAContainerOptions__RevealAnswerAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2773:1: ( ( ( 'reveal' ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2774:1: ( ( 'reveal' ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2774:1: ( ( 'reveal' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2775:1: ( 'reveal' )
            {
             before(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerRevealKeyword_3_0_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2776:1: ( 'reveal' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2777:1: 'reveal'
            {
             before(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerRevealKeyword_3_0_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__QAContainerOptions__RevealAnswerAssignment_3_05532); 
             after(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerRevealKeyword_3_0_0()); 

            }

             after(grammarAccess.getQAContainerOptionsAccess().getRevealAnswerRevealKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QAContainerOptions__RevealAnswerAssignment_3_0"


    // $ANTLR start "rule__Question__NameAssignment_0_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2792:1: rule__Question__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Question__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2796:1: ( ( RULE_ID ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2797:1: ( RULE_ID )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2797:1: ( RULE_ID )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2798:1: RULE_ID
            {
             before(grammarAccess.getQuestionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Question__NameAssignment_0_15571); 
             after(grammarAccess.getQuestionAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__NameAssignment_0_1"


    // $ANTLR start "rule__Question__TextAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2807:1: rule__Question__TextAssignment_1 : ( ruleEString ) ;
    public final void rule__Question__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2811:1: ( ( ruleEString ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2812:1: ( ruleEString )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2812:1: ( ruleEString )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2813:1: ruleEString
            {
             before(grammarAccess.getQuestionAccess().getTextEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Question__TextAssignment_15602);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getQuestionAccess().getTextEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__TextAssignment_1"


    // $ANTLR start "rule__Question__CorrectAssignment_3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2822:1: rule__Question__CorrectAssignment_3 : ( ruleAnswer ) ;
    public final void rule__Question__CorrectAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2826:1: ( ( ruleAnswer ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2827:1: ( ruleAnswer )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2827:1: ( ruleAnswer )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2828:1: ruleAnswer
            {
             before(grammarAccess.getQuestionAccess().getCorrectAnswerParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_rule__Question__CorrectAssignment_35633);
            ruleAnswer();

            state._fsp--;

             after(grammarAccess.getQuestionAccess().getCorrectAnswerParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__CorrectAssignment_3"


    // $ANTLR start "rule__Question__CandidatesAssignment_5_2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2837:1: rule__Question__CandidatesAssignment_5_2 : ( ruleAnswer ) ;
    public final void rule__Question__CandidatesAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2841:1: ( ( ruleAnswer ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2842:1: ( ruleAnswer )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2842:1: ( ruleAnswer )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2843:1: ruleAnswer
            {
             before(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_rule__Question__CandidatesAssignment_5_25664);
            ruleAnswer();

            state._fsp--;

             after(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__CandidatesAssignment_5_2"


    // $ANTLR start "rule__Question__CandidatesAssignment_5_3_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2852:1: rule__Question__CandidatesAssignment_5_3_1 : ( ruleAnswer ) ;
    public final void rule__Question__CandidatesAssignment_5_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2856:1: ( ( ruleAnswer ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2857:1: ( ruleAnswer )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2857:1: ( ruleAnswer )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2858:1: ruleAnswer
            {
             before(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnswer_in_rule__Question__CandidatesAssignment_5_3_15695);
            ruleAnswer();

            state._fsp--;

             after(grammarAccess.getQuestionAccess().getCandidatesAnswerParserRuleCall_5_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__CandidatesAssignment_5_3_1"


    // $ANTLR start "rule__Question__NextRulesAssignment_6"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2867:1: rule__Question__NextRulesAssignment_6 : ( ruleNextRule ) ;
    public final void rule__Question__NextRulesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2871:1: ( ( ruleNextRule ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2872:1: ( ruleNextRule )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2872:1: ( ruleNextRule )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2873:1: ruleNextRule
            {
             before(grammarAccess.getQuestionAccess().getNextRulesNextRuleParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNextRule_in_rule__Question__NextRulesAssignment_65726);
            ruleNextRule();

            state._fsp--;

             after(grammarAccess.getQuestionAccess().getNextRulesNextRuleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__NextRulesAssignment_6"


    // $ANTLR start "rule__NextRule__NextAssignment_3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2882:1: rule__NextRule__NextAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__NextRule__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2886:1: ( ( ( RULE_ID ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2887:1: ( ( RULE_ID ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2887:1: ( ( RULE_ID ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2888:1: ( RULE_ID )
            {
             before(grammarAccess.getNextRuleAccess().getNextQAPartCrossReference_3_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2889:1: ( RULE_ID )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2890:1: RULE_ID
            {
             before(grammarAccess.getNextRuleAccess().getNextQAPartIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NextRule__NextAssignment_35761); 
             after(grammarAccess.getNextRuleAccess().getNextQAPartIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getNextRuleAccess().getNextQAPartCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__NextAssignment_3"


    // $ANTLR start "rule__NextRule__TriesAssignment_4_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2901:1: rule__NextRule__TriesAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__NextRule__TriesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2905:1: ( ( RULE_INT ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2906:1: ( RULE_INT )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2906:1: ( RULE_INT )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2907:1: RULE_INT
            {
             before(grammarAccess.getNextRuleAccess().getTriesINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__NextRule__TriesAssignment_4_15796); 
             after(grammarAccess.getNextRuleAccess().getTriesINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextRule__TriesAssignment_4_1"


    // $ANTLR start "rule__QASection__NameAssignment_1_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2916:1: rule__QASection__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__QASection__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2920:1: ( ( RULE_ID ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2921:1: ( RULE_ID )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2921:1: ( RULE_ID )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2922:1: RULE_ID
            {
             before(grammarAccess.getQASectionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QASection__NameAssignment_1_15827); 
             after(grammarAccess.getQASectionAccess().getNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__NameAssignment_1_1"


    // $ANTLR start "rule__QASection__TitleAssignment_2"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2931:1: rule__QASection__TitleAssignment_2 : ( ruleEString ) ;
    public final void rule__QASection__TitleAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2935:1: ( ( ruleEString ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2936:1: ( ruleEString )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2936:1: ( ruleEString )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2937:1: ruleEString
            {
             before(grammarAccess.getQASectionAccess().getTitleEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__QASection__TitleAssignment_25858);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getQASectionAccess().getTitleEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__TitleAssignment_2"


    // $ANTLR start "rule__QASection__OptionsAssignment_3"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2946:1: rule__QASection__OptionsAssignment_3 : ( ruleQAContainerOptions ) ;
    public final void rule__QASection__OptionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2950:1: ( ( ruleQAContainerOptions ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2951:1: ( ruleQAContainerOptions )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2951:1: ( ruleQAContainerOptions )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2952:1: ruleQAContainerOptions
            {
             before(grammarAccess.getQASectionAccess().getOptionsQAContainerOptionsParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQAContainerOptions_in_rule__QASection__OptionsAssignment_35889);
            ruleQAContainerOptions();

            state._fsp--;

             after(grammarAccess.getQASectionAccess().getOptionsQAContainerOptionsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__OptionsAssignment_3"


    // $ANTLR start "rule__QASection__QuestionsAssignment_5"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2961:1: rule__QASection__QuestionsAssignment_5 : ( ruleQuestion ) ;
    public final void rule__QASection__QuestionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2965:1: ( ( ruleQuestion ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2966:1: ( ruleQuestion )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2966:1: ( ruleQuestion )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2967:1: ruleQuestion
            {
             before(grammarAccess.getQASectionAccess().getQuestionsQuestionParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuestion_in_rule__QASection__QuestionsAssignment_55920);
            ruleQuestion();

            state._fsp--;

             after(grammarAccess.getQASectionAccess().getQuestionsQuestionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QASection__QuestionsAssignment_5"


    // $ANTLR start "rule__TextAnswer__TextAssignment"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2976:1: rule__TextAnswer__TextAssignment : ( ruleEString ) ;
    public final void rule__TextAnswer__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2980:1: ( ( ruleEString ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2981:1: ( ruleEString )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2981:1: ( ruleEString )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2982:1: ruleEString
            {
             before(grammarAccess.getTextAnswerAccess().getTextEStringParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__TextAnswer__TextAssignment5951);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTextAnswerAccess().getTextEStringParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextAnswer__TextAssignment"


    // $ANTLR start "rule__NumberAnswer__NumberAssignment_0"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2991:1: rule__NumberAnswer__NumberAssignment_0 : ( ruleEDouble ) ;
    public final void rule__NumberAnswer__NumberAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2995:1: ( ( ruleEDouble ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2996:1: ( ruleEDouble )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2996:1: ( ruleEDouble )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:2997:1: ruleEDouble
            {
             before(grammarAccess.getNumberAnswerAccess().getNumberEDoubleParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_rule__NumberAnswer__NumberAssignment_05982);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getNumberAnswerAccess().getNumberEDoubleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__NumberAssignment_0"


    // $ANTLR start "rule__NumberAnswer__EpsilonAssignment_1_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3006:1: rule__NumberAnswer__EpsilonAssignment_1_1 : ( ruleEDouble ) ;
    public final void rule__NumberAnswer__EpsilonAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3010:1: ( ( ruleEDouble ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3011:1: ( ruleEDouble )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3011:1: ( ruleEDouble )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3012:1: ruleEDouble
            {
             before(grammarAccess.getNumberAnswerAccess().getEpsilonEDoubleParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_rule__NumberAnswer__EpsilonAssignment_1_16013);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getNumberAnswerAccess().getEpsilonEDoubleParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberAnswer__EpsilonAssignment_1_1"


    // $ANTLR start "rule__YesNoAnswer__YesAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3021:1: rule__YesNoAnswer__YesAssignment_1 : ( ( 'yes' ) ) ;
    public final void rule__YesNoAnswer__YesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3025:1: ( ( ( 'yes' ) ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3026:1: ( ( 'yes' ) )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3026:1: ( ( 'yes' ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3027:1: ( 'yes' )
            {
             before(grammarAccess.getYesNoAnswerAccess().getYesYesKeyword_1_0()); 
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3028:1: ( 'yes' )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3029:1: 'yes'
            {
             before(grammarAccess.getYesNoAnswerAccess().getYesYesKeyword_1_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__YesNoAnswer__YesAssignment_16049); 
             after(grammarAccess.getYesNoAnswerAccess().getYesYesKeyword_1_0()); 

            }

             after(grammarAccess.getYesNoAnswerAccess().getYesYesKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__YesNoAnswer__YesAssignment_1"


    // $ANTLR start "rule__OptionAnswer__OptionNumberAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3044:1: rule__OptionAnswer__OptionNumberAssignment_1 : ( ruleEInt ) ;
    public final void rule__OptionAnswer__OptionNumberAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3048:1: ( ( ruleEInt ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3049:1: ( ruleEInt )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3049:1: ( ruleEInt )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3050:1: ruleEInt
            {
             before(grammarAccess.getOptionAnswerAccess().getOptionNumberEIntParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_rule__OptionAnswer__OptionNumberAssignment_16088);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getOptionAnswerAccess().getOptionNumberEIntParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionAnswer__OptionNumberAssignment_1"


    // $ANTLR start "rule__ExpressionAnswer__ExpressionAssignment_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3059:1: rule__ExpressionAnswer__ExpressionAssignment_1 : ( ruleEString ) ;
    public final void rule__ExpressionAnswer__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3063:1: ( ( ruleEString ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3064:1: ( ruleEString )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3064:1: ( ruleEString )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3065:1: ruleEString
            {
             before(grammarAccess.getExpressionAnswerAccess().getExpressionEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__ExpressionAnswer__ExpressionAssignment_16119);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExpressionAnswerAccess().getExpressionEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__ExpressionAssignment_1"


    // $ANTLR start "rule__ExpressionAnswer__EpsilonAssignment_2_1"
    // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3074:1: rule__ExpressionAnswer__EpsilonAssignment_2_1 : ( ruleEDouble ) ;
    public final void rule__ExpressionAnswer__EpsilonAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3078:1: ( ( ruleEDouble ) )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3079:1: ( ruleEDouble )
            {
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3079:1: ( ruleEDouble )
            // ../qa.xtext.ui/src-gen/qa/xtext/ui/contentassist/antlr/internal/InternalQa.g:3080:1: ruleEDouble
            {
             before(grammarAccess.getExpressionAnswerAccess().getEpsilonEDoubleParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_rule__ExpressionAnswer__EpsilonAssignment_2_16150);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getExpressionAnswerAccess().getEpsilonEDoubleParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionAnswer__EpsilonAssignment_2_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleQATest_in_entryRuleQATest61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQATest68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__Group__0_in_ruleQATest94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_entryRuleQAContainerOptions121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQAContainerOptions128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__0_in_ruleQAContainerOptions154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAPart_in_entryRuleQAPart181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQAPart188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAPart__Alternatives_in_ruleQAPart214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnswer_in_entryRuleAnswer241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnswer248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Answer__Alternatives_in_ruleAnswer274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuestion_in_entryRuleQuestion301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuestion308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__0_in_ruleQuestion334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextRule_in_entryRuleNextRule361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextRule368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__0_in_ruleNextRule394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQASection_in_entryRuleQASection421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQASection428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__0_in_ruleQASection454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextAnswer_in_entryRuleTextAnswer481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextAnswer488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TextAnswer__TextAssignment_in_ruleTextAnswer514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberAnswer_in_entryRuleNumberAnswer541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberAnswer548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group__0_in_ruleNumberAnswer574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleYesNoAnswer_in_entryRuleYesNoAnswer601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleYesNoAnswer608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__Alternatives_in_ruleYesNoAnswer634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionAnswer_in_entryRuleOptionAnswer661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionAnswer668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OptionAnswer__Group__0_in_ruleOptionAnswer694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionAnswer_in_entryRuleExpressionAnswer721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpressionAnswer728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__0_in_ruleExpressionAnswer754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble840 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__0_in_ruleEDouble873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt900 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuestion_in_rule__QAPart__Alternatives969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQASection_in_rule__QAPart__Alternatives986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextAnswer_in_rule__Answer__Alternatives1018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberAnswer_in_rule__Answer__Alternatives1035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleYesNoAnswer_in_rule__Answer__Alternatives1052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionAnswer_in_rule__Answer__Alternatives1069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionAnswer_in_rule__Answer__Alternatives1086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__Group_0__0_in_rule__YesNoAnswer__Alternatives1118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__YesAssignment_1_in_rule__YesNoAnswer__Alternatives1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__EDouble__Alternatives_2_2_01170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__EDouble__Alternatives_2_2_01190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__Group__0__Impl_in_rule__QATest__Group__01222 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QATest__Group__1_in_rule__QATest__Group__01225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__QATest__Group__0__Impl1253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__Group__1__Impl_in_rule__QATest__Group__11284 = new BitSet(new long[]{0x0000000008104010L});
        public static final BitSet FOLLOW_rule__QATest__Group__2_in_rule__QATest__Group__11287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__TitleAssignment_1_in_rule__QATest__Group__1__Impl1314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__Group__2__Impl_in_rule__QATest__Group__21344 = new BitSet(new long[]{0x0000000008104010L});
        public static final BitSet FOLLOW_rule__QATest__Group__3_in_rule__QATest__Group__21347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__OptionsAssignment_2_in_rule__QATest__Group__2__Impl1374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__Group__3__Impl_in_rule__QATest__Group__31405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QATest__PartsAssignment_3_in_rule__QATest__Group__3__Impl1432 = new BitSet(new long[]{0x0000000008100012L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__0__Impl_in_rule__QAContainerOptions__Group__01471 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__1_in_rule__QAContainerOptions__Group__01474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__QAContainerOptions__Group__0__Impl1502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__1__Impl_in_rule__QAContainerOptions__Group__11533 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__2_in_rule__QAContainerOptions__Group__11536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__MaxTriesAssignment_1_in_rule__QAContainerOptions__Group__1__Impl1563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__2__Impl_in_rule__QAContainerOptions__Group__21593 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__3_in_rule__QAContainerOptions__Group__21596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__QAContainerOptions__Group__2__Impl1624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group__3__Impl_in_rule__QAContainerOptions__Group__31655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__0_in_rule__QAContainerOptions__Group__3__Impl1682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__0__Impl_in_rule__QAContainerOptions__Group_3__01721 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__1_in_rule__QAContainerOptions__Group_3__01724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__RevealAnswerAssignment_3_0_in_rule__QAContainerOptions__Group_3__0__Impl1751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__1__Impl_in_rule__QAContainerOptions__Group_3__11781 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__2_in_rule__QAContainerOptions__Group_3__11784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__QAContainerOptions__Group_3__1__Impl1812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QAContainerOptions__Group_3__2__Impl_in_rule__QAContainerOptions__Group_3__21843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__QAContainerOptions__Group_3__2__Impl1871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__0__Impl_in_rule__Question__Group__01908 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rule__Question__Group__1_in_rule__Question__Group__01911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_0__0_in_rule__Question__Group__0__Impl1938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__1__Impl_in_rule__Question__Group__11969 = new BitSet(new long[]{0x0000002780040030L});
        public static final BitSet FOLLOW_rule__Question__Group__2_in_rule__Question__Group__11972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__TextAssignment_1_in_rule__Question__Group__1__Impl1999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__2__Impl_in_rule__Question__Group__22029 = new BitSet(new long[]{0x0000002780040030L});
        public static final BitSet FOLLOW_rule__Question__Group__3_in_rule__Question__Group__22032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Question__Group__2__Impl2061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__3__Impl_in_rule__Question__Group__32094 = new BitSet(new long[]{0x0000000001280000L});
        public static final BitSet FOLLOW_rule__Question__Group__4_in_rule__Question__Group__32097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__CorrectAssignment_3_in_rule__Question__Group__3__Impl2124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__4__Impl_in_rule__Question__Group__42154 = new BitSet(new long[]{0x0000000001280000L});
        public static final BitSet FOLLOW_rule__Question__Group__5_in_rule__Question__Group__42157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Question__Group__4__Impl2186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__5__Impl_in_rule__Question__Group__52219 = new BitSet(new long[]{0x0000000001280000L});
        public static final BitSet FOLLOW_rule__Question__Group__6_in_rule__Question__Group__52222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5__0_in_rule__Question__Group__5__Impl2249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group__6__Impl_in_rule__Question__Group__62280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__NextRulesAssignment_6_in_rule__Question__Group__6__Impl2307 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Question__Group_0__0__Impl_in_rule__Question__Group_0__02352 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Question__Group_0__1_in_rule__Question__Group_0__02355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Question__Group_0__0__Impl2383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_0__1__Impl_in_rule__Question__Group_0__12414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__NameAssignment_0_1_in_rule__Question__Group_0__1__Impl2441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5__0__Impl_in_rule__Question__Group_5__02475 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Question__Group_5__1_in_rule__Question__Group_5__02478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Question__Group_5__0__Impl2506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5__1__Impl_in_rule__Question__Group_5__12537 = new BitSet(new long[]{0x0000002780040030L});
        public static final BitSet FOLLOW_rule__Question__Group_5__2_in_rule__Question__Group_5__12540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Question__Group_5__1__Impl2568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5__2__Impl_in_rule__Question__Group_5__22599 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Question__Group_5__3_in_rule__Question__Group_5__22602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__CandidatesAssignment_5_2_in_rule__Question__Group_5__2__Impl2629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5__3__Impl_in_rule__Question__Group_5__32659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5_3__0_in_rule__Question__Group_5__3__Impl2686 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__Question__Group_5_3__0__Impl_in_rule__Question__Group_5_3__02725 = new BitSet(new long[]{0x0000002780040030L});
        public static final BitSet FOLLOW_rule__Question__Group_5_3__1_in_rule__Question__Group_5_3__02728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Question__Group_5_3__0__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__Group_5_3__1__Impl_in_rule__Question__Group_5_3__12787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Question__CandidatesAssignment_5_3_1_in_rule__Question__Group_5_3__1__Impl2814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__0__Impl_in_rule__NextRule__Group__02848 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__NextRule__Group__1_in_rule__NextRule__Group__02851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__1__Impl_in_rule__NextRule__Group__12909 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__NextRule__Group__2_in_rule__NextRule__Group__12912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__NextRule__Group__1__Impl2940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__2__Impl_in_rule__NextRule__Group__22971 = new BitSet(new long[]{0x0000000002000040L});
        public static final BitSet FOLLOW_rule__NextRule__Group__3_in_rule__NextRule__Group__22974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__NextRule__Group__2__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__3__Impl_in_rule__NextRule__Group__33033 = new BitSet(new long[]{0x0000000002000040L});
        public static final BitSet FOLLOW_rule__NextRule__Group__4_in_rule__NextRule__Group__33036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__NextAssignment_3_in_rule__NextRule__Group__3__Impl3063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group__4__Impl_in_rule__NextRule__Group__43094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__0_in_rule__NextRule__Group__4__Impl3121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__0__Impl_in_rule__NextRule__Group_4__03162 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__1_in_rule__NextRule__Group_4__03165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__NextRule__Group_4__0__Impl3193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__1__Impl_in_rule__NextRule__Group_4__13224 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__2_in_rule__NextRule__Group_4__13227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__TriesAssignment_4_1_in_rule__NextRule__Group_4__1__Impl3254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextRule__Group_4__2__Impl_in_rule__NextRule__Group_4__23284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__NextRule__Group_4__2__Impl3312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__0__Impl_in_rule__QASection__Group__03349 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rule__QASection__Group__1_in_rule__QASection__Group__03352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__QASection__Group__0__Impl3380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__1__Impl_in_rule__QASection__Group__13411 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rule__QASection__Group__2_in_rule__QASection__Group__13414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group_1__0_in_rule__QASection__Group__1__Impl3441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__2__Impl_in_rule__QASection__Group__23472 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_rule__QASection__Group__3_in_rule__QASection__Group__23475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__TitleAssignment_2_in_rule__QASection__Group__2__Impl3502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__3__Impl_in_rule__QASection__Group__33532 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_rule__QASection__Group__4_in_rule__QASection__Group__33535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__OptionsAssignment_3_in_rule__QASection__Group__3__Impl3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__4__Impl_in_rule__QASection__Group__43593 = new BitSet(new long[]{0x0000000020100010L});
        public static final BitSet FOLLOW_rule__QASection__Group__5_in_rule__QASection__Group__43596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__QASection__Group__4__Impl3624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group__5__Impl_in_rule__QASection__Group__53655 = new BitSet(new long[]{0x0000000020100010L});
        public static final BitSet FOLLOW_rule__QASection__Group__6_in_rule__QASection__Group__53658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__QuestionsAssignment_5_in_rule__QASection__Group__5__Impl3685 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_rule__QASection__Group__6__Impl_in_rule__QASection__Group__63716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__QASection__Group__6__Impl3744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group_1__0__Impl_in_rule__QASection__Group_1__03789 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__QASection__Group_1__1_in_rule__QASection__Group_1__03792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__QASection__Group_1__0__Impl3820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__Group_1__1__Impl_in_rule__QASection__Group_1__13851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QASection__NameAssignment_1_1_in_rule__QASection__Group_1__1__Impl3878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group__0__Impl_in_rule__NumberAnswer__Group__03912 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group__1_in_rule__NumberAnswer__Group__03915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__NumberAssignment_0_in_rule__NumberAnswer__Group__0__Impl3942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group__1__Impl_in_rule__NumberAnswer__Group__13972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group_1__0_in_rule__NumberAnswer__Group__1__Impl3999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group_1__0__Impl_in_rule__NumberAnswer__Group_1__04034 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group_1__1_in_rule__NumberAnswer__Group_1__04037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__NumberAnswer__Group_1__0__Impl4065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__Group_1__1__Impl_in_rule__NumberAnswer__Group_1__14096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NumberAnswer__EpsilonAssignment_1_1_in_rule__NumberAnswer__Group_1__1__Impl4123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__Group_0__0__Impl_in_rule__YesNoAnswer__Group_0__04157 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__Group_0__1_in_rule__YesNoAnswer__Group_0__04160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__YesNoAnswer__Group_0__1__Impl_in_rule__YesNoAnswer__Group_0__14218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__YesNoAnswer__Group_0__1__Impl4246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OptionAnswer__Group__0__Impl_in_rule__OptionAnswer__Group__04281 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__OptionAnswer__Group__1_in_rule__OptionAnswer__Group__04284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__OptionAnswer__Group__0__Impl4312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OptionAnswer__Group__1__Impl_in_rule__OptionAnswer__Group__14343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OptionAnswer__OptionNumberAssignment_1_in_rule__OptionAnswer__Group__1__Impl4370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__0__Impl_in_rule__ExpressionAnswer__Group__04404 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__1_in_rule__ExpressionAnswer__Group__04407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ExpressionAnswer__Group__0__Impl4435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__1__Impl_in_rule__ExpressionAnswer__Group__14466 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__2_in_rule__ExpressionAnswer__Group__14469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__ExpressionAssignment_1_in_rule__ExpressionAnswer__Group__1__Impl4496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group__2__Impl_in_rule__ExpressionAnswer__Group__24526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group_2__0_in_rule__ExpressionAnswer__Group__2__Impl4553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group_2__0__Impl_in_rule__ExpressionAnswer__Group_2__04590 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group_2__1_in_rule__ExpressionAnswer__Group_2__04593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ExpressionAnswer__Group_2__0__Impl4621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__Group_2__1__Impl_in_rule__ExpressionAnswer__Group_2__14652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExpressionAnswer__EpsilonAssignment_2_1_in_rule__ExpressionAnswer__Group_2__1__Impl4679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__0__Impl_in_rule__EDouble__Group__04713 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__EDouble__Group__1_in_rule__EDouble__Group__04716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EDouble__Group__0__Impl4745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__1__Impl_in_rule__EDouble__Group__14778 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__EDouble__Group__2_in_rule__EDouble__Group__14781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group__1__Impl4808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__2__Impl_in_rule__EDouble__Group__24837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__0_in_rule__EDouble__Group__2__Impl4864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__0__Impl_in_rule__EDouble__Group_2__04901 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__1_in_rule__EDouble__Group_2__04904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__EDouble__Group_2__0__Impl4932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__1__Impl_in_rule__EDouble__Group_2__14963 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__2_in_rule__EDouble__Group_2__14966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group_2__1__Impl4993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2__2__Impl_in_rule__EDouble__Group_2__25022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__0_in_rule__EDouble__Group_2__2__Impl5049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__0__Impl_in_rule__EDouble__Group_2_2__05086 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__1_in_rule__EDouble__Group_2_2__05089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Alternatives_2_2_0_in_rule__EDouble__Group_2_2__0__Impl5116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__1__Impl_in_rule__EDouble__Group_2_2__15146 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__2_in_rule__EDouble__Group_2_2__15149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EDouble__Group_2_2__1__Impl5178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_2_2__2__Impl_in_rule__EDouble__Group_2_2__25211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group_2_2__2__Impl5238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__05273 = new BitSet(new long[]{0x0000000400000020L});
        public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__05276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__EInt__Group__0__Impl5305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__15338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl5365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__QATest__TitleAssignment_15403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_rule__QATest__OptionsAssignment_25434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAPart_in_rule__QATest__PartsAssignment_35465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__QAContainerOptions__MaxTriesAssignment_15496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__QAContainerOptions__RevealAnswerAssignment_3_05532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Question__NameAssignment_0_15571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Question__TextAssignment_15602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnswer_in_rule__Question__CorrectAssignment_35633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnswer_in_rule__Question__CandidatesAssignment_5_25664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnswer_in_rule__Question__CandidatesAssignment_5_3_15695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextRule_in_rule__Question__NextRulesAssignment_65726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NextRule__NextAssignment_35761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__NextRule__TriesAssignment_4_15796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QASection__NameAssignment_1_15827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__QASection__TitleAssignment_25858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQAContainerOptions_in_rule__QASection__OptionsAssignment_35889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuestion_in_rule__QASection__QuestionsAssignment_55920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__TextAnswer__TextAssignment5951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_rule__NumberAnswer__NumberAssignment_05982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_rule__NumberAnswer__EpsilonAssignment_1_16013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__YesNoAnswer__YesAssignment_16049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_rule__OptionAnswer__OptionNumberAssignment_16088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__ExpressionAnswer__ExpressionAssignment_16119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_rule__ExpressionAnswer__EpsilonAssignment_2_16150 = new BitSet(new long[]{0x0000000000000002L});
    }


}