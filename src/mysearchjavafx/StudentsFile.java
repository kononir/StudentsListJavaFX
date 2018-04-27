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
import java.util.List;
import javax.xml.transform.stream.*;

import model.*;

/**
 *
 * @author Vlad
 */
public class StudentsFile {
    private String PATH;
    private Document document;
    private List<Student> students;
    
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
    
    private void newSalary(Parent parent, Element parentElement){
        MoneyBr salary = parent.getEarnMoney();
        Element salaryElement = document.createElement("salary");
        parentElement.appendChild(salaryElement);
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
    
    public void saveDocument(List<Student> studentsArray, String PATH) 
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
                numberOfSistersElement.setTextContent(String.valueOf(student.getNumberOfSisters()));
                studentElement.appendChild(numberOfSistersElement);
            });
        } catch(ParserConfigurationException e){
            e.printStackTrace(System.out);
        } finally {
            if(document != null)
                writeDocument();
        }
    }
    
    DefaultHandler handler = new DefaultHandler(){
        StringBuilder globalTagNames = new StringBuilder();

        Student student;
        String studentFirstName;
        String studentSurname;
        String studentLastName;
        String fatherFirstName;
        String fatherSurname;
        String fatherLastName;
        int fatherRubles;
        int fatherPenny;
        String motherFirstName;
        String motherSurname;
        String motherLastName;
        int motherRubles;
        int motherPenny;
        int numberOfBrothers;
        int numberOfSisters;
        Parent mother;
        Parent father;

        @Override
        public void startDocument() throws SAXException{
            System.out.println("Start analysis");
            students = new ArrayList();
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
            globalTagNames.append(qName);
            globalTagNames.append(" ");
        }
        @Override
        public void characters(char ch[], int start, int length)
                throws SAXException
        {
            int startIndexOfDeletedSubstring = globalTagNames.length() - 1;
            int endIndexOfDeletedSubstring = globalTagNames.length();
            globalTagNames.delete(
                    startIndexOfDeletedSubstring, 
                    endIndexOfDeletedSubstring
            );
            String globalTagNamesStr = globalTagNames.toString();
            switch(globalTagNamesStr){
                case "students student firstName":
                    studentFirstName = new String(ch, start, length);
                    break;    
                case "students student surname":
                    studentSurname = new String(ch, start, length);
                    break;
                case "students student lastName":
                    studentLastName = new String(ch, start, length);
                    break;
                case "students student father firstName":
                    fatherFirstName = new String(ch, start, length);
                    break;    
                case "students student father surname":
                    fatherSurname = new String(ch, start, length);
                    break;
                case "students student father lastName":
                    fatherLastName = new String(ch, start, length);
                    break;
                case "students student father salary rubles":
                    fatherRubles = new Integer(new String(ch, start, length));
                    break;    
                case "students student father salary penny":
                    fatherPenny = new Integer(new String(ch, start, length));
                    break;
                case "students student mother firstName":
                    motherFirstName = new String(ch, start, length);
                    break;
                case "students student mother surname":
                    motherSurname = new String(ch, start, length);
                    break;    
                case "students student mother lastName":
                    motherLastName = new String(ch, start, length);
                    break;
                case "students student mother salary rubles":
                    motherRubles = new Integer(new String(ch, start, length));
                    break;
                case "students student mother salary penny":
                    motherPenny = new Integer(new String(ch, start, length));
                    break;   
                case "students student numberOfBrothers":
                    numberOfBrothers = new Integer(new String(ch, start, length));
                    break;
                case "students student numberOfSisters":
                    numberOfSisters = new Integer(new String(ch, start, length));
                    break;
                default:
                    break;
            }
            globalTagNames.append(" ");
        }
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException
        {
            int startIndexOfDeletedSubstring = globalTagNames.length() 
                                             - qName.length() - 1;
            int endIndexOfDeletedSubstring = globalTagNames.length();
            globalTagNames.delete(
                    startIndexOfDeletedSubstring, 
                    endIndexOfDeletedSubstring
            );
            if(qName.equals("student")){
                MoneyBr fatherSalary = new MoneyBr(fatherRubles, fatherPenny);
                father = new Parent(
                    fatherFirstName, 
                    fatherSurname,
                    fatherLastName,
                    fatherSalary
                );
                MoneyBr motherSalary = new MoneyBr(motherRubles, motherPenny);
                mother = new Parent(
                    motherFirstName, 
                    motherSurname,
                    motherLastName,
                    motherSalary
                );
                student = new Student(
                    studentFirstName,
                    studentSurname,
                    studentLastName,
                    father,
                    mother,
                    numberOfBrothers,
                    numberOfSisters
                );
                students.add(student);
            }
            super.endElement(uri, localName, qName);
        }
    };
    
    public List<Student> loadDocument(String PATH){
        try{
            SAXParserFactory saxParserFact = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFact.newSAXParser();
            saxParser.parse(PATH, handler);  
        } catch(IOException | ParserConfigurationException | SAXException e){
            e.printStackTrace(System.out);
        }
        return students;
    }
    
    public StudentsFile(String PATH){
        this.PATH = PATH;
    }
    public StudentsFile(){
        this.PATH = "";
    }
}
