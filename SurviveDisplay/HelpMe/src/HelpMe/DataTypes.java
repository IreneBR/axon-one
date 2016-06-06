package HelpMe;

public enum DataTypes{
	    STUCK("stuck"),
	    INJURED("injured"),
	    DESTRUCTION("destruction"),
	    SURVIVE("survive"),
	    URGENT_HELP("urgent-help"),
	    WATER_LEVEL("water-level")
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    private DataTypes(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
}
