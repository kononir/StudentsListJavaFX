/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import model.Student;

import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import java.io.*;
import javax.xml.transform.stream.*;

import model.*;

/**
 *
 * @author Vlad
 */
public class FileWork {
    private String PATH;
    private Document document;
    
    private void newFIO(Person person, Element personElement){
        Element firstNameElement = document.createElement("firstName");
        firstNameElement.setTextContent(person.getFirstName());
        personElement.appendChild(firstNameElement);
        Element surnameElement = document.createElement("surname");
        surnameElement.setTextContent(person.getSurName());
        personElement.appendChild(surnameElement);
        Element lastNameElement = document.createElement("lastName");
        lastNameElement.setTextContent(person.getLastName());
        personElement.appendChild(lastNameElement);
    }
    
    private void newSalary(Parent parent, Element personElement){
        MoneyBr salary = parent.getEarnMoney();
        Element salaryElement = document.createElement("salary");
        personElement.appendChild(salaryElement);
        Element rublesElement = document.createElement("rubles");
        rublesElement.setTextContent(String.valueOf(salary.getRubles()));
        salaryElement.appendChild(rublesElement);
        Element pennyElement = document.createElement("penny");
        pennyElement.setTextContent(String.valueOf(salary.getPenny()));
        salaryElement.appendChild(pennyElement);
    }
    
    private void writeDocument() 
    {
        try{
            Transformer transformerFactory = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            StreamResult streamRes = new StreamResult(fileOutputStream);
         
            transformerFactory.transform(source, streamRes);
        }
        catch (TransformerException e){
            e.printStackTrace(System.out);
        }
        catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }
    
    public void saveDocument(ArrayList<Student> studentsArray, String PATH) 
    { 
        this.PATH = PATH;
        try{
            DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
            document = docBuilder.newDocument();
            Element studentsElement = document.createElement("students");
            document.appendChild(studentsElement);
            if(studentsArray.isEmpty())
                return;
            
            studentsArray.forEach((student) -> {
                Element studentElement = document.createElement("student");
                studentsElement.appendChild(studentElement);
                newFIO(student, studentElement);
                
                Parent father = student.getFather();
                Element fatherElement = document.createElement("father");
                studentElement.appendChild(fatherElement);
                newFIO(father, fatherElement);
                newSalary(father, fatherElement);
                
                Parent mother = student.getMother();
                Element motherElement = document.createElement("mother");
                studentElement.appendChild(motherElement);
                newFIO(mother, motherElement);
                newSalary(mother, motherElement);
                
                Element numberOfBrothersElement = document.createElement("numberOfBrothers");
                numberOfBrothersElement.setTextContent(String.valueOf(student.getNumberOfBrothers()));
                studentElement.appendChild(numberOfBrothersElement);
                
                Element numberOfSistersElement = document.createElement("numberOfSisters");
                numberOfSistersElement.setTextContent(String.valueOf(student.getNumberOfBrothers()));
                studentElement.appendChild(numberOfSistersElement);
            });
        } catch(ParserConfigurationException e){
            e.printStackTrace(System.out);
        } finally {
            if(document != null)
                writeDocument();
        }
    }
    
    public void loadDocument(){
        DefaultHandler handler = new DefaultHandler(){
            //boolean tagStart = false;
            ArrayList<Student> HBoxesOfCurrentDialog = new ArrayList();
            Student currentStudent;
            Parent currentFather;
            Parent currentMother;
            MoneyBr currentFatherSalary;
            MoneyBr currentMotherSalary;
            String currentQName;
            String currentUri;
            
            @Override
            public void startDocument() throws SAXException{
                System.out.println("Start analysis");
            }
            @Override
            public void endDocument() throws SAXException{
                System.out.println("Finish analysis");
            }
            @Override
            public void startElement(String uri, String localName, 
                    String qName, Attributes attributes)
                    throws SAXException
            {
                currentQName = qName;
                currentUri = uri;
                //tagStart = (!qName.equalsIgnoreCase("students") || !qName.equalsIgnoreCase("student"));
            }
            @Override
            public void characters(char ch[], int start, int length)
                    throws SAXException
            {
                switch(currentQName){
                    case "students":
                        break;
                    case "student":
                        break;
                    case "firstName":
                        break;    
                    case "mother": 
                        break;
                }
            }
            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException
            {
                super.endElement(uri, localName, qName);
            }
        };
    }
    
    public FileWork(String PATH){
        this.PATH = PATH;
    }
    public FileWork(){
        this.PATH = "";
    }
}
