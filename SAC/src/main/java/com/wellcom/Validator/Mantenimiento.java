package com.wellcom.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.wellcom.exceptions.WellException;
import com.wellcom.io.ResourceFile;



public class Mantenimiento {
	


	@SuppressWarnings({"unchecked"})
	public static String fechasLib (String Fiid, String initDate, String ruta) throws FileNotFoundException, JDOMException, IOException, WellException {
		String FechaXml = "";
		String NoFechaXml = "";
		try{
		//ResourceFile rs = new ResourceFile();
		
	    //FileInputStream file = new FileInputStream("LiberacionBancos.xml");
		//File f=rs.setFilePath("./LiberacionBancos.xml");
	    SAXBuilder builder = new SAXBuilder();
		//Document doc = builder.build(new FileInputStream("C:/Proyectos/java/pmr/web/WEB-INF/LiberacionBancos.xml"));
		Document doc = builder.build(new FileInputStream(ruta+"/xmls/LiberacionBancos.xml"));
		Element raiz = doc.getRootElement();
		List<Element> hijosRaiz = raiz.getChildren();
		for(Element hijo: hijosRaiz){
		   if(hijo.getAttributeValue("Fiid").equals(Fiid) ){
		      FechaXml = hijo.getAttributeValue("Fecha");
		      //System.out.println("FechaXML: "+FechaXml);		      
		   }
		   else {
			   NoFechaXml = initDate;
			   //System.out.println("NoFechaXML: "+NoFechaXml);
			   }
		}
		}catch(Exception e){e.printStackTrace();}
		if (FechaXml=="")
			return  NoFechaXml;
		else
			return  FechaXml; 
	}	
	
	@SuppressWarnings({})
	public static String guardaEstado (String estatus, String ruta) throws FileNotFoundException, JDOMException, IOException, WellException {
	    Element root=new Element("Mantenimiento");//Creamos un elemento root
	    Element usuario = null;
	    usuario=new Element("Usuario");
	    usuario.setAttribute("id","aplicacion");
	    usuario.setAttribute("estatus",estatus);
	    root.addContent(usuario);
	    Document doc=new Document(root);//Creamos el documento
	    try{
	      XMLOutputter out=new XMLOutputter(Format.getPrettyFormat()); 
	      FileOutputStream file=new FileOutputStream(ruta+"/xmls/mantenimiento.xml");
	      out.output(doc,file);
	      file.flush();
	      file.close();
	    }catch(Exception e){e.printStackTrace();}   
		return "Exito";
		}		
	
	@SuppressWarnings({"unchecked"})
	public static  String leeEstado(String id, String ruta) throws FileNotFoundException, JDOMException, IOException, WellException {
		String estatus = "";
		//File file = new File("pmr/web/xmls/", "mantenimiento.xml");
	    //String f=file.getAbsolutePath();
	    SAXBuilder builder = new SAXBuilder();
		//Document doc = builder.build(new FileInputStream("C:/Proyectos/java/pmr/web/WEB-INF/LiberacionBancos.xml"));
		Document doc = builder.build(new FileInputStream(ruta+"/xmls/mantenimiento.xml"));
		Element raiz = doc.getRootElement();
		List<Element> hijosRaiz = raiz.getChildren();
		for(Element hijo: hijosRaiz){
		      estatus = hijo.getAttributeValue("estatus");	      
		}
			return  estatus; 		
	}
	
}

