package ar.uba.fi.tdd.grupo5.framework;

public class Printer {

	private final static String SIMPLE_LINE = "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
	private final static String DOUBLE_LINE = "\n==================\n";
	private String stream;
	private boolean onScreen;

	public Printer() {
		stream = "";
	}

	public void printOnScreen() {
		onScreen = true;
	}

	public void notPrintOnScreen() {
		onScreen = false;
	}

	public void printTestSuiteName(String name) {
		String buffer = name + SIMPLE_LINE;
		printOnScreen(buffer);
		stream = stream + buffer;
	}

	public void printOkTestCaseResult(String name, long time) {
		String buffer = "[ok]\t" + name + "\n";
		printOnScreen(buffer);
		stream = stream + buffer;
	}

	public void printErrorTestCaseResult(String name, long time) {
		String buffer = "[fail]\t" + name + "\n";
		printOnScreen(buffer);
		stream = stream + buffer;
	}

	public void printFailTestCaseResult(String name, long time) {
		String buffer = "[fail]\t" + name + "\n";
		printOnScreen(buffer);
		stream = stream + buffer;
	}

	public void printSummary(int totalTestCount, int errorCount, int failCount) {
		String buffer = getStringOfStatusTestSuite(errorCount, failCount)
				+ "Summary" + DOUBLE_LINE
				+ getStringOfTestCount(totalTestCount)
				+ getStringOfErrorCount(errorCount)
				+ getStringOfFailCount(failCount);
		printOnScreen(buffer);
		stream = stream + buffer;
	}
	
	public String getPrintText() {
		return stream;
	}
	
	public void clearPrintTest() {
		stream = "";
	}

	private boolean isPrintOnScreen() {
		return onScreen;
	}

	private void printOnScreen(String buffer) {
		if (isPrintOnScreen()) {
			System.out.println(buffer);
		}
	}

	private String getStringOfStatusTestSuite(int errorCount, int failCount) {
		if ((errorCount == 0) && (failCount == 0)) {
			return "[success]";
		}
		return "[failure]";
	}

	private String getStringOfTestCount(int testCount) {
		return "Run: " + testCount + "\n";
	}

	private String getStringOfErrorCount(int errorCount) {
		return "Errors: " + errorCount + "\n";
	}

	private String getStringOfFailCount(int failCount) {
		return "Failures: " + failCount + "\n";
	}
}
