package ar.uba.fi.tdd.grupo5.xml;

public class SkippedElement extends Element {
		
	private String content;
	
	public SkippedElement(boolean isSkipped) {
		super("skipped");
		if (isSkipped){
			setSkipped();
		} else {
			setNoSkipped();
		}
	}

	protected void oneLineTag(){
		stream = tabLevel + "<" + name + ">" + content + "</" + name + ">\n";
	}
		
	public void setSkipped(){
		this.content = "YES";
	}
	
	public void setNoSkipped(){
		this.content = "NO";
	}
	
}
