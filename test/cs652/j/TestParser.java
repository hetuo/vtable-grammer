package cs652.j;

import cs652.j.parser.JLexer;
import cs652.j.parser.JParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestParser extends CommonBaseTest {
	public TestParser(String filename) {
		super(filename);
	}

	@Test
	public void testParse() throws Exception {
		checkJParse(filename);
	}

	public void checkJParse(String filename) throws Exception {
		URL testFolderURL = TestParser.class.getClassLoader().getResource(SAMPLES_DIR);
		String testFolder = testFolderURL.getPath();

		String J_pathToFile = testFolder+"/"+filename;

		ANTLRInputStream input = new ANTLRFileStream(J_pathToFile);
		JLexer l = new JLexer(input);
		TokenStream tokens = new CommonTokenStream(l);

		JParser parser = new JParser(tokens);
		parser.removeErrorListeners();
		int[] errors = {0};
		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
				errors[0]++;
			}
		});
		ParserRuleContext tree = parser.file();
		assertTrue(tree!=null);
		assertEquals(Token.EOF, tree.getStop().getType());
		assertEquals(0, errors[0]);
	}

}
