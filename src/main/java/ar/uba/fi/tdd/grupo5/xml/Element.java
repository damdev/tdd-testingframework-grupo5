package ar.uba.fi.tdd.grupo5.xml;

import java.util.LinkedList;

public abstract class Element {
	
	protected final static String tab = "\t";
	
	protected LinkedList<Element> childs;
	protected LinkedList<Attribute> attributes;
	protected String name;
	protected String tabLevel;
	
	protected String stream;
	
	protected boolean isLeaf;
	
	public Element(String name){
		childs = new LinkedList<Element>();
		attributes = new LinkedList<Attribute>();
		this.name = name;
		this.tabLevel = "";
		stream = "";
		isLeaf = true;
	}
	
	public String getXMLFormatElement(){
		if (isLeaf){
			oneLineTag();
		} else {
			getXMLFormatNoLeafElement();
		}
		return stream;
	}
	
	protected final void getXMLFormatNoLeafElement(){
		openTag();
		for (Element elem : childs) {
			stream += elem.getXMLFormatElement();
		}
		closeTag();
	}
	
	protected final void openTag(){
		stream = tabLevel + "<" + name + getXMLFormatAttributes() + ">\n";
	}
	
	protected final void closeTag(){
		stream += tabLevel + "</" + name + ">\n";
	}
	
	protected final void oneLineTag(){
		stream = tabLevel + "<" + name + getXMLFormatAttributes() + "/>\n";
	}	
	
	protected final String getXMLFormatAttributes(){
		for (Attribute attrib : attributes) {
			stream += attrib.getXMLFormatAttibute();
		}
		return stream;
	}
	
	protected final void setTabLevel(String tabLevel){
		this.tabLevel = tabLevel;
	}
	
	public final void addChild(Element child){
		child.setTabLevel(this.tabLevel + tab);
		childs.add(child);
		isLeaf = false;
	}
	
	public final void addAttribute(String attibuteName, String attibuteValue){
		Attribute attrib = new Attribute(attibuteName, attibuteValue);
		attributes.add(attrib);
	}
	
}
