package ar.uba.fi.tdd.grupo5.framework;

public class Printer {

	private final static String SIMPLE_LINE = "\n­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------\n";
	private final static String DOUBLE_LINE = "\n==================\n";
	private String stream;
	private boolean onScreen;

	public Printer() {
		stream = "";
		onScreen = true;
	}

	public void printOnScreen() {
		onScreen = true;
	}

	public void notPrintOnScreen() {
		onScreen = false;
	}

	public Report printAndReportEmptyTestSuiteMessage(String testName) {
		clearPrintText();
		printEmptyTestSuiteMessage(testName);
		return getReport();
	}

	public void printEmptyTestSuiteMessage(String testName) {
		String buffer = testName + SIMPLE_LINE
				+ "The TestSuite is empty. There are no tests to run.";
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public Report printAndReportNoTestsThatSatisfyPatternMessage(
			String testName, String pattern) {
		clearPrintText();
		printNoTestsThatSatisfyPatternMessage(testName, pattern);
		return getReport();
	}

	public void printNoTestsThatSatisfyPatternMessage(String testName,
			String pattern) {
		String buffer = testName + SIMPLE_LINE
				+ "Not available tests that satisfy the pattern " + pattern;
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printTestSuiteName(String name) {
		String buffer = name + SIMPLE_LINE;
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printOkTestCaseResult(String name, long time) {
		String buffer = "[ok]\t" + name + stringTime(time);
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printErrorTestCaseResult(String name, long time) {
		String buffer = "[error]\t" + name + stringTime(time);
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printFailTestCaseResult(String name, long time) {
		String buffer = "[fail]\t" + name + stringTime(time);
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printSummary(int totalTestCount, int errorCount, int failCount,
			long time) {
		printEndLine();
		String buffer = stringOfStatusTestSuite(errorCount, failCount)
				+ "Summary" + DOUBLE_LINE + stringOfTestCount(totalTestCount)
				+ stringOfErrorCount(errorCount) + stringOfFailCount(failCount)
				+ stringOfSummaryTime(time);
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public void printEndLine() {
		String buffer = "\n";
		printOnScreen(buffer);
		addToStream(buffer);
	}

	public Report getReport() {
		return new Report(stream);
	}

	public void clearPrintText() {
		stream = "";
	}

	private boolean isPrintOnScreen() {
		return onScreen;
	}

	private void printOnScreen(String buffer) {
		if (isPrintOnScreen()) {
			System.out.print(buffer);
		}
	}

	private void addToStream(String buffer) {
		stream += buffer;
	}

	private String stringTime(long time) {
		return " (" + time + " ns)\n";
	}

	private String stringOfStatusTestSuite(int errorCount, int failCount) {
		if ((errorCount == 0) && (failCount == 0)) {
			return "[success] ";
		}
		return "[failure] ";
	}

	private String stringOfTestCount(int testCount) {
		return "Run: " + testCount + "\n";
	}

	private String stringOfErrorCount(int errorCount) {
		return "Errors: " + errorCount + "\n";
	}

	private String stringOfFailCount(int failCount) {
		return "Failures: " + failCount + "\n";
	}

	private String stringOfSummaryTime(long time) {
		return "Time: " + time + " ns\n";
	}
}
