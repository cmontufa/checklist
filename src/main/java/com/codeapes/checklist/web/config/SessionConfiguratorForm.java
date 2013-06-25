package com.codeapes.checklist.web.config;

public class SessionConfiguratorForm {

    private static final int RESULTS_PER_PAGE = 10;

    private String log4jConfigText;
    private int resultsPerPage = RESULTS_PER_PAGE;

    public String getLog4jConfigText() {
		return log4jConfigText;
	}

	public void setLog4jConfigText(String log4jConfigText) {
		this.log4jConfigText = log4jConfigText;
	}

	public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

}
