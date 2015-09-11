package Scenes;


import Renderables.GeometricObject;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.Vector;

public class Parser
{
	Vector<GeometricObject> objects;
	XMLReader reader;
	
	public Parser(String file) throws SAXException
	{
		objects = new Vector<GeometricObject>();
		reader = XMLReaderFactory.createXMLReader(file);
	}
	
	public void ParseToObjects()
	{
		//
	}
	
}
